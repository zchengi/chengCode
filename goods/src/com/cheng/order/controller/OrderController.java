package com.cheng.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cheng.domain.myOrder;
import com.cheng.order.povo.DingdanPovo;
import com.cheng.order.serviceImpl.OrderServiceImpl;

@RequestMapping("/order")
@Controller
public class OrderController {

	@Autowired
	private OrderServiceImpl orderServiceImpl;

	@RequestMapping(value = "/dindan", method = RequestMethod.POST)
	public String dindan(String[] ids, myOrder dindan, Model model) {

		myOrder dindan2 = orderServiceImpl.addDindan(ids, dindan);
		model.addAttribute("dindan", dindan2);
		return "jsps/order/ordersucc";
	}

	@RequestMapping(value = "/getdindans/{uid}", method = RequestMethod.GET)
	public String getDindans(@PathVariable String uid, Model model) {
		List<DingdanPovo> dindans = orderServiceImpl.getDindans(uid);
		model.addAttribute("dindans", dindans);
		return "jsps/order/list";
	}
}
