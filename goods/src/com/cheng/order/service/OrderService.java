package com.cheng.order.service;

import java.util.List;

import com.cheng.domain.myOrder;
import com.cheng.order.povo.DingdanPovo;

public interface OrderService {

	myOrder adddingdan(String[] ids, myOrder order);

	List<DingdanPovo> getdingdans(String uid);

	DingdanPovo getDingdan(String oid);

	void affirmDingdan(String oid);

	void cancelDingdan(String oid);

	String payDingdan(String oid);
}
