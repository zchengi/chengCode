package com.cheng.admin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheng.dao.AdminMapper;
import com.cheng.domain.Admin;
import com.cheng.domain.AdminExample;

@Repository
public class AdminDao implements AdminMapper {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int countByExample(AdminExample example) {
        return this.adminMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdminExample example) {
        return this.adminMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String adminid) {
        return this.adminMapper.deleteByPrimaryKey(adminid);
    }

    @Override
    public int insert(Admin record) {
        return this.adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return this.adminMapper.insertSelective(record);
    }

    @Override
    public List<Admin> selectByExample(AdminExample example) {
        return this.adminMapper.selectByExample(example);
    }

    @Override
    public Admin selectByPrimaryKey(String adminid) {
        return this.adminMapper.selectByPrimaryKey(adminid);
    }

    @Override
    public int updateByExampleSelective(Admin record, AdminExample example) {
        return this.adminMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Admin record, AdminExample example) {
        return this.adminMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return this.adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return this.adminMapper.updateByPrimaryKey(record);
    }

    public Admin selectByNameAndpwdForadmin(Admin admin) {
        return this.adminMapper.selectByNameAndpwdForadmin(admin);
    }

}
