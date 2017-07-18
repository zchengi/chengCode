package com.cheng.management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheng.management.dao.OrderManageDao;
import com.cheng.management.service.OrderManageService;
import com.cheng.order.povo.DingdanPovo;

@Service
public class OrderManageServiceImpl implements OrderManageService {

	@Autowired
	private OrderManageDao orderManageDao;

	public List<DingdanPovo> toList() {
		return orderManageDao.selectAll();
	}

	public List<DingdanPovo> findByStatus(int status) {
		return orderManageDao.selectByStatus(status);
	}

	public DingdanPovo findByOid(String oid) {
		return orderManageDao.selectByOid(oid);
	}

	public String deliver(String oid) {
		DingdanPovo dingdan = orderManageDao.selectByOid(oid);
		if (2 != dingdan.getStatus()) {
			return "订单状态不对，不能发货！";
		}
		dingdan.setStatus(3);
		int i = orderManageDao.updateByPrimaryKey(dingdan);
		if (i > 0) {
			return "订单已发货！";
		}
		return "订单发货失败！";
	}

	public String cancel(String oid) {
		DingdanPovo dingdan = orderManageDao.selectByOid(oid);
		if (1 != dingdan.getStatus()) {
			return "订单状态不对，不能取消！";
		}
		dingdan.setStatus(5);
		int i = orderManageDao.updateByPrimaryKey(dingdan);
		if (i > 0) {
			return "订单已取消！";
		}
		return "订单取消失败！";
	}
}
