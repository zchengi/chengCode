package com.cheng.cartitem.service;

import java.util.List;

import com.cheng.cartitem.povo.CartItempovo;
import com.cheng.domain.CartItem;

public interface CartItemService {

	List<CartItempovo> getCartIems(String uid);

	void removeCartitem(String cartitemid);
	
	void editCartitem(CartItem newcartItem);
	
	List<CartItempovo> addCartitem(CartItem newcartItem,String uid);
	
	void deleteCartitems(String[] ids);
}
