package com.cheng.cartitem.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uuid.UUIDHelper;

import com.cheng.cartitem.dao.CartItemDao;
import com.cheng.cartitem.povo.CartItempovo;
import com.cheng.cartitem.service.CartItemService;
import com.cheng.domain.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public List<CartItempovo> getCartIems(String uid) {
        return cartItemDao.selectCartIempovoByUid(uid);
    }

    @Override
    public void removeCartitem(String cartitemid) {
        cartItemDao.deleteByPrimaryKey(cartitemid);
    }

    @Override
    public void editCartitem(CartItem newcartItem) {
        cartItemDao.updateByPrimaryKeySelective(newcartItem);
    }

    @Override
    public List<CartItempovo> addCartitem(CartItem newcartItem, String uid) {
        newcartItem.setCartitemid(UUIDHelper.getUUID());
        List<CartItem> list = cartItemDao.selectHavacartItem(newcartItem);
        if (list == null || list.size() == 0) {
            cartItemDao.insert(newcartItem);
        } else {
            CartItem cartItem = list.get(0);
            cartItem.setQuantity(newcartItem.getQuantity()
                    + cartItem.getQuantity());
            cartItemDao.updateByPrimaryKey(cartItem);
        }
        return cartItemDao.selectCartIempovoByUid(uid);
    }

    @Override
    public void deleteCartitems(String[] ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ids", ids);
        cartItemDao.deleteCartitems(map);
    }

    @Override
    public List<CartItempovo> selectAccounts(String[] ids, String uid) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ids", ids);
        map.put("uid", uid);
        return cartItemDao.selectAccounts(map);
    }
}
