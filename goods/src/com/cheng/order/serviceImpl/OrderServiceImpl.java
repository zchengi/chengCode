package com.cheng.order.serviceImpl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

	public myOrder addDindan(String[] ids, myOrder dindan) {

		dindan.setOid(UUIDHelper.getUUID());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dindan.setOrdertime(sdf.format(date));
		dindan.setStatus(1);
		myOrderDao.insert(dindan);

		for (String cartitemid : ids) {
			Orderitem orderitem = new Orderitem();
			CartItempovo cartItempovo = cartItemDao
					.selectCartIempovoByCartitemid(cartitemid);
			orderitem.setBid(cartItempovo.getBid());
			orderitem.setBname(cartItempovo.getBname());
			orderitem.setCurrprice(cartItempovo.getCurrprice());
			orderitem.setImageB(cartItempovo.getImageB());
			orderitem.setOid(dindan.getOid());
			orderitem.setOrderitemid(UUIDHelper.getUUID());
			orderitem.setQuantity(cartItempovo.getCartItem().getQuantity());
			orderitem.setSubtotal(new BigDecimal(cartItempovo.getSubTotal()));
			
			cartItemDao.deleteByPrimaryKey(cartitemid);
			orderitemMapper.insert(orderitem);
		}
		
		//删除已经提交订单的购物车列表

		return dindan;
	}

	public List<DingdanPovo> getDindans(String uid) {
		return myOrderDao.selectdingdanbyuid(uid);
	}
}
