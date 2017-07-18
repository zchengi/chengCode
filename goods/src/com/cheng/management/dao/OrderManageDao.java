package com.cheng.management.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheng.dao.myOrderMapper;
import com.cheng.domain.myOrder;
import com.cheng.domain.myOrderExample;
import com.cheng.order.povo.DingdanPovo;

@Repository
public class OrderManageDao implements myOrderMapper {

	@Autowired
	private myOrderMapper myOrderMapper;

	@Override
	public DingdanPovo selectByOid(String oid) {
		return myOrderMapper.selectByOid(oid);
	}

	@Override
	public void updateDindans(Map<String, Object> map) {
		this.updateDindans(map);
	}

	@Override
	public List<DingdanPovo> selectdingdanbyuid(String uid) {
		return myOrderMapper.selectdingdanbyuid(uid);
	}

	@Override
	public int countByExample(myOrderExample example) {
		return myOrderMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(myOrderExample example) {
		return myOrderMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String oid) {
		return myOrderMapper.deleteByPrimaryKey(oid);
	}

	@Override
	public int insert(myOrder record) {
		return myOrderMapper.insert(record);
	}

	@Override
	public int insertSelective(myOrder record) {
		return myOrderMapper.insertSelective(record);
	}

	@Override
	public List<myOrder> selectByExample(myOrderExample example) {
		return myOrderMapper.selectByExample(example);
	}

	@Override
	public myOrder selectByPrimaryKey(String oid) {
		return myOrderMapper.selectByPrimaryKey(oid);
	}

	@Override
	public int updateByExampleSelective(myOrder record, myOrderExample example) {
		return myOrderMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(myOrder record, myOrderExample example) {
		return myOrderMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(myOrder record) {
		return myOrderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(myOrder record) {
		return myOrderMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<DingdanPovo> selectAll() {
		return myOrderMapper.selectAll();
	}

	@Override
	public List<DingdanPovo> selectByStatus(int status) {
		return myOrderMapper.selectByStatus(status);
	}

}
