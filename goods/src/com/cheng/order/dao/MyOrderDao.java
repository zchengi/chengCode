package com.cheng.order.dao;

import java.util.List;
import java.util.Map;

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
        return this.myOrderMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(myOrderExample example) {
        return this.myOrderMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String oid) {
        return this.myOrderMapper.deleteByPrimaryKey(oid);
    }

    @Override
    public int insert(myOrder record) {
        return this.myOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(myOrder record) {
        return this.myOrderMapper.insertSelective(record);
    }

    @Override
    public List<myOrder> selectByExample(myOrderExample example) {
        return this.myOrderMapper.selectByExample(example);
    }

    @Override
    public myOrder selectByPrimaryKey(String oid) {
        return this.myOrderMapper.selectByPrimaryKey(oid);
    }

    @Override
    public int updateByExampleSelective(myOrder record, myOrderExample example) {
        return this.myOrderMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(myOrder record, myOrderExample example) {
        return this.myOrderMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(myOrder record) {
        return this.myOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(myOrder record) {
        return this.myOrderMapper.updateByPrimaryKey(record);
    }

    public List<DingdanPovo> selectdingdanbyuid(String uid) {
        return this.myOrderMapper.selectdingdanbyuid(uid);
    }

    @Override
    public DingdanPovo selectByOid(String oid) {
        return this.myOrderMapper.selectByOid(oid);
    }

    @Override
    public void updateDindans(Map<String, Object> map) {
        this.myOrderMapper.updateDindans(map);
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
