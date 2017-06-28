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
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("oid", oid);	
		map.put("status",4);	
		myOrderDao.updateDindans(map);
	}

	public void cancelDingdan(String oid) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("oid", oid);	
		map.put("status",5);	
		myOrderDao.updateDindans(map);
	}
}
