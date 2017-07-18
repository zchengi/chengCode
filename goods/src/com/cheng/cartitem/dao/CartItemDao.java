package com.cheng.cartitem.dao;

import java.util.List;
import java.util.Map;

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
		return this.cartItemMapper.selectByExample(cartItemExample);
	}

	public List<CartItempovo> selectCartIempovoByUid(String uid) {
		List<CartItempovo> selectCartIempovoByUid = cartItemMapper
				.selectCartIempovoByUid(uid);
		return selectCartIempovoByUid;
	}

	public CartItempovo selectCartIempovoByCartitemid(String cartiemid) {
		CartItempovo selectCartIempovoByUid = cartItemMapper
				.selectCartIempovoByCartitemid(cartiemid);
		return selectCartIempovoByUid;
	}

	@Override
	public int countByExample(CartItemExample example) {
		return this.cartItemMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CartItemExample example) {
		return this.cartItemMapper.deleteByExample(example);
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
		return this.cartItemMapper.insertSelective(record);
	}

	@Override
	public List<CartItem> selectByExample(CartItemExample example) {
		return this.cartItemMapper.selectByExample(example);
	}

	@Override
	public CartItem selectByPrimaryKey(String cartitemid) {
		return this.cartItemMapper.selectByPrimaryKey(cartitemid);
	}

	@Override
	public int updateByExampleSelective(CartItem record, CartItemExample example) {
		return this.cartItemMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(CartItem record, CartItemExample example) {
		return this.cartItemMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(CartItem record) {
		return this.cartItemMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CartItem record) {
		return this.cartItemMapper.updateByPrimaryKey(record);
	}

	@Override
	public void deleteCartitems(Map<String, Object> ids) {
		this.cartItemMapper.deleteCartitems(ids);
	}
	@Override
	public List<CartItempovo> selectAccounts(Map<String, Object> map) {
		return this.cartItemMapper.selectAccounts(map);
	}
}
