package com.cheng.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheng.dao.UserMapper;
import com.cheng.domain.User;
import com.cheng.domain.UserExample;
import com.cheng.domain.UserExample.Criteria;

@Repository
public class UserDao implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int countByExample(UserExample example) {
        return userMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserExample example) {
        return userMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String uid) {
        return userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public User selectByPrimaryKey(String uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int updateByExampleSelective(User record, UserExample example) {
        return userMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(User record, UserExample example) {
        return userMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    public List<User> selectByActivationCode(String activationCode) {
        UserExample userExample = new UserExample();
        Criteria createCriteria = userExample.createCriteria();
        createCriteria.andActivationcodeEqualTo(activationCode);
        return userMapper.selectByExample(userExample);
    }

    public List<User> select(User user) {
        UserExample userExample = new UserExample();
        Criteria createCriteria = userExample.createCriteria();
        createCriteria.andLoginnameEqualTo(user.getLoginname())
                .andLoginpassEqualTo(user.getLoginpass());
        return userMapper.selectByExample(userExample);
    }

}
