package com.cheng.order.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;
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
		return "jsps/order/pay";
	}

	// 支付
	@RequestMapping(value = "/pay/{oid}", method = RequestMethod.GET)
	public void payDingdan(@PathVariable String oid, Model model,
			HttpServletResponse response) {
		String result = orderServiceImpl.payDingdan(oid);
		try {
			response.getWriter().println("<html>" + result + "</html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 支付成功页面跳转
	@RequestMapping(value = "/returnurl", method = RequestMethod.GET)
	public String returnUrl(Model model, HttpServletRequest request)
			throws UnsupportedEncodingException, AlipayApiException {

		// 获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter
				.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			try {
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params,
				AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名
		// ——请在这里编写您的程序（以下代码仅作参考）——
		if (signVerified) {
			model.addAttribute("code", "success");
			model.addAttribute("msg", "支付成功");
		} else {
			model.addAttribute("code", "error");
			model.addAttribute("msg", "支付失败");
		}

		return "jsps/msg";
	}
}
