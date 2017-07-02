package com.cheng.order.serviceImpl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uuid.UUIDHelper;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.cheng.cartitem.dao.CartItemDao;
import com.cheng.cartitem.povo.CartItempovo;
import com.cheng.dao.OrderitemMapper;
import com.cheng.domain.Orderitem;
import com.cheng.domain.myOrder;
import com.cheng.order.dao.MyOrderDao;
import com.cheng.order.povo.DingdanPovo;
import com.cheng.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private MyOrderDao myOrderDao;

	@Autowired
	private CartItemDao cartItemDao;

	@Autowired
	private OrderitemMapper orderitemMapper;

	public myOrder adddingdan(String[] ids, myOrder dingdan) {

		dingdan.setOid(UUIDHelper.getUUID());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dingdan.setOrdertime(sdf.format(date));
		dingdan.setStatus(1);
		myOrderDao.insert(dingdan);

		for (String cartitemid : ids) {
			Orderitem orderitem = new Orderitem();
			CartItempovo cartItempovo = cartItemDao
					.selectCartIempovoByCartitemid(cartitemid);
			orderitem.setBid(cartItempovo.getBid());
			orderitem.setBname(cartItempovo.getBname());
			orderitem.setCurrprice(cartItempovo.getCurrprice());
			orderitem.setImageB(cartItempovo.getImageB());
			orderitem.setOid(dingdan.getOid());
			orderitem.setOrderitemid(UUIDHelper.getUUID());
			orderitem.setQuantity(cartItempovo.getCartItem().getQuantity());
			orderitem.setSubtotal(new BigDecimal(cartItempovo.getSubTotal()));
			// 删除已经提交订单的购物车列表
			cartItemDao.deleteByPrimaryKey(cartitemid);

			// 添加订单
			orderitemMapper.insert(orderitem);
		}

		return dingdan;
	}

	public List<DingdanPovo> getdingdans(String uid) {
		return myOrderDao.selectdingdanbyuid(uid);
	}

	public DingdanPovo getDingdan(String oid) {
		return myOrderDao.selectByOid(oid);
	}

	public void affirmDingdan(String oid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oid", oid);
		map.put("status", 4);
		myOrderDao.updateDindans(map);
	}

	public void cancelDingdan(String oid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oid", oid);
		map.put("status", 5);
		myOrderDao.updateDindans(map);
	}

	public String payDingdan(String oid) {
		DingdanPovo dingdan = myOrderDao.selectByOid(oid);

		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(
				AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json",
				AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);

		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		// 同步请求
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		// alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

		// 信息
		String WIDout_trade_no = dingdan.getOid();
		String WIDtotal_amount = dingdan.getTotal().toString();
		String WIDsubject = "tushu";
		String WIDbody = "zzz";

		// 商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = new String(WIDout_trade_no);
		// 付款金额，必填
		String total_amount = new String(WIDtotal_amount);
		// 订单名称，必填
		String subject = new String(WIDsubject);
		// 商品描述，可空
		String body = new String(WIDbody);

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no
				+ "\"," + "\"total_amount\":\"" + total_amount + "\","
				+ "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body
				+ "\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		String result = null;
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
