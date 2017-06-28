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

	@RequestMapping(value = "/dingdan", method = RequestMethod.POST)
	public String dingdan(String[] ids, myOrder dingdan, Model model) {

		myOrder dingdan2 = orderServiceImpl.adddingdan(ids, dingdan);
		model.addAttribute("dingdan", dingdan2);
		return "jsps/order/ordersucc";
	}

	@RequestMapping(value = "/getdingdans/{uid}", method = RequestMethod.GET)
	public String getdingdans(@PathVariable String uid, Model model) {
		List<DingdanPovo> dingdans = orderServiceImpl.getdingdans(uid);
		model.addAttribute("dingdans", dingdans);
		return "jsps/order/list";
	}

	@RequestMapping(value = "/getdingdan/{oid}", method = RequestMethod.GET)
	public String getDingdan(@PathVariable String oid, Model model) {
		DingdanPovo dingdan = orderServiceImpl.getDingdan(oid);
		model.addAttribute("dingdan", dingdan);
		return "jsps/order/desc";
	}

	// 确认
	@RequestMapping(value = "/affirm/{oid}", method = RequestMethod.GET)
	public String affirmDingdan(@PathVariable String oid, Model model) {
		orderServiceImpl.affirmDingdan(oid);

		model.addAttribute("code", "success");
		model.addAttribute("msg", "订单已确认");
		return "jsps/msg";
	}

	// 取消
	@RequestMapping(value = "/cancel/{oid}", method = RequestMethod.GET)
	public String cancelDingdan(@PathVariable String oid, Model model) {
		orderServiceImpl.cancelDingdan(oid);

		model.addAttribute("code", "success");
		model.addAttribute("msg", "订单已取消");
		return "jsps/msg";
	}
	// 将要支付
	@RequestMapping(value = "/payying/{oid}", method = RequestMethod.GET)
	public String payyingDingdan(@PathVariable String oid, Model model) {
		DingdanPovo dingdan = orderServiceImpl.getDingdan(oid);
		model.addAttribute("dingdan", dingdan);
		return "jsps/order/desc";
	}
}
