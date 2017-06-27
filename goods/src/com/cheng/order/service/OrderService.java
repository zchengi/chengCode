package com.cheng.order.service;

import java.util.List;

import com.cheng.domain.myOrder;
import com.cheng.order.povo.DingdanPovo;

public interface OrderService {
	
	myOrder dindan(String[] ids, myOrder order);
	List<DingdanPovo> getDindans(String uid);
}
