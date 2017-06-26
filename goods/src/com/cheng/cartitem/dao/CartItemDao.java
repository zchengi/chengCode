package com.cheng.cartitem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheng.cartitem.povo.CartItempovo;
import com.cheng.dao.CartItemMapper;
import com.cheng.domain.CartItem;
import com.cheng.domain.CartItemExample;

@Repository
public class CartItemDao implements CartItemMapper {
	@Autowired
	private CartItemMapper cartItemMapper;

	public List<CartItem> selectHavacartItem(CartItem newcartItem) {
		CartItemExample cartItemExample = new CartItemExample();
		cartItemExample.createCriteria().andUidEqualTo(newcartItem.getUid())
				.andBidEqualTo(newcartItem.getBid());
		return cartItemMapper.selectByExample(cartItemExample);
	}

	public List<CartItempovo> selectCartIempovoByUid(String uid) {
		List<CartItempovo> selectCartIempovoByUid = cartItemMapper
				.selectCartIempovoByUid(uid);
		return selectCartIempovoByUid;
	}

	@Override
	public int countByExample(CartItemExample example) {
		return 0;
	}

	@Override
	public int deleteByExample(CartItemExample example) {
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String cartitemid) {
		return this.cartItemMapper.deleteByPrimaryKey(cartitemid);
	}

	@Override
	public int insert(CartItem record) {
		return this.cartItemMapper.insert(record);
	}

	@Override
	public int insertSelective(CartItem record) {
		return 0;
	}

	@Override
	public List<CartItem> selectByExample(CartItemExample example) {
		return null;
	}

	@Override
	public CartItem selectByPrimaryKey(String cartitemid) {
		return null;
	}

	@Override
	public int updateByExampleSelective(CartItem record, CartItemExample example) {
		return 0;
	}

	@Override
	public int updateByExample(CartItem record, CartItemExample example) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(CartItem record) {
		return this.cartItemMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CartItem record) {
		return this.cartItemMapper.updateByPrimaryKey(record);
	}

}
