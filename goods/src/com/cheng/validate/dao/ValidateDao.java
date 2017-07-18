package com.cheng.validate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheng.dao.UserMapper;
import com.cheng.domain.User;
import com.cheng.domain.UserExample;
import com.cheng.domain.UserExample.Criteria;

@Repository
public class ValidateDao implements UserMapper {
	@Autowired
	private UserMapper userMapper;

	@Override
	public int countByExample(UserExample example) {
		return this.userMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(UserExample example) {
		return this.userMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String uid) {
		return this.userMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public int insert(User record) {
		return this.userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		return this.userMapper.insertSelective(record);
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		return this.userMapper.selectByExample(example);
	}

	@Override
	public User selectByPrimaryKey(String uid) {
		return this.userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public int updateByExampleSelective(User record, UserExample example) {
		return this.userMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(User record, UserExample example) {
		return this.userMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return this.userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return this.userMapper.updateByPrimaryKey(record);
	}

	public int valiLoginName(String loginname) {
		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andLoginnameEqualTo(loginname);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() == 0) {
			return 0;
		}
		return 1;
	}

	public Boolean valiemail(String email) {
		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andEmailEqualTo(email);
		List<User> emails = userMapper.selectByExample(userExample);
		if (emails.size() == 0) {
			return true;
		}
		return false;
	}
}
