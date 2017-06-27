package com.cheng.order.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheng.dao.myOrderMapper;
import com.cheng.domain.myOrder;
import com.cheng.domain.myOrderExample;
import com.cheng.order.povo.DingdanPovo;

@Repository
public class MyOrderDao implements myOrderMapper {

	@Autowired
	private myOrderMapper myOrderMapper;
	
	@Override
	public int countByExample(myOrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(myOrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String oid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(myOrder record) {
		return this.myOrderMapper.insert(record);
	}

	@Override
	public int insertSelective(myOrder record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<myOrder> selectByExample(myOrderExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public myOrder selectByPrimaryKey(String oid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(myOrder record, myOrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(myOrder record, myOrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(myOrder record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(myOrder record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<DingdanPovo> selectdingdanbyuid(String uid) {
		return this.myOrderMapper.selectdingdanbyuid(uid);
	}

}
