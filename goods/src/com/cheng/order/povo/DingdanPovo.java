package com.cheng.order.povo;

import java.util.List;

import com.cheng.domain.Orderitem;
import com.cheng.domain.myOrder;

public class DingdanPovo extends myOrder {
	private List<Orderitem> orderitems;

	public List<Orderitem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}
}
