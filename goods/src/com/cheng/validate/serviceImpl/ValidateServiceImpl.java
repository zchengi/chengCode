package com.cheng.validate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheng.validate.dao.ValidateDao;
import com.cheng.validate.service.ValidateService;

/**
 * 与验证相关的控制层
 */
@Service
public class ValidateServiceImpl implements ValidateService {

	@Autowired
	private ValidateDao validateDao;

	/**
	 * 验证用户名是否有重复
	 * 
	 * @return 重复返回1 否则返回0
	 */
	public int valiLoginName(String loginname) {
		return validateDao.valiLoginName(loginname);
	}

	public Boolean valiemail(String email) {
		return validateDao.valiemail(email);
	}
}
