package com.cheng.admin.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheng.admin.dao.AdminDao;
import com.cheng.admin.service.AdminService;
import com.cheng.domain.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	public Admin login(Admin admin) {
		return adminDao.selectByNameAndpwdForadmin(admin);
	}
}
