package com.cheng.cartitem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cheng.cartitem.povo.CartItempovo;
import com.cheng.cartitem.serviceImpl.CartItemServiceImpl;
import com.cheng.domain.CartItem;
import com.cheng.domain.User;

@RequestMapping("/cartitem")
@Controller
public class CartItemController {

	@Autowired
	private CartItemServiceImpl cartItemServiceImpl;

	/**
	 * 查询购物车
	 */
	@RequestMapping(value = "/getcartitems/{uid}", method = RequestMethod.GET)
	public String getCartItems(@PathVariable String uid, Model model) {
		List<CartItempovo> povos = cartItemServiceImpl.getCartIems(uid);
		model.addAttribute("cartItems", povos);
		return "jsps/cart/list";
	}

	/**
	 * 删除购物车
	 */
	@RequestMapping(value = "/removecartitem/{cartitemid}", method = RequestMethod.GET)
	public String removeCartitem(@PathVariable String cartitemid,
			HttpSession session) {
		cartItemServiceImpl.removeCartitem(cartitemid);
		User user = (User) session.getAttribute("user");
		return "redirect:/cartitem/getcartitems/" + user.getUid();
	}

	/**
	 * 修改购物车
	 */
	@RequestMapping(value = "/editcartitem")
	public String editCartitem(CartItem newcartItem, HttpSession session) {
		cartItemServiceImpl.editCartitem(newcartItem);

		User user = (User) session.getAttribute("user");
		return "redirect:/cartitem/getcartitems/" + user.getUid();
	}

	/**
	 * 添加购物车
	 */
	@RequestMapping(value = "/addcartitem", method = RequestMethod.POST)
	public String addCartitem(CartItem newcartItem, HttpSession session,
			Model model) {
		User user = (User) session.getAttribute("user");
		newcartItem.setUid(user.getUid());
		List<CartItempovo> povos = cartItemServiceImpl.addCartitem(newcartItem,user.getUid());
		model.addAttribute("cartItems", povos);
		return "jsps/cart/list";
	}
}