package com.cheng.classified.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheng.dao.CategoryMapper;
import com.cheng.domain.Category;
import com.cheng.domain.CategoryExample;

@Repository
public class ClassifiedDao implements CategoryMapper {
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public int countByExample(CategoryExample example) {
		return this.categoryMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CategoryExample example) {
		return this.categoryMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String cid) {
		return this.categoryMapper.deleteByPrimaryKey(cid);
	}

	@Override
	public int insert(Category record) {
		return this.categoryMapper.insert(record);
	}

	@Override
	public int insertSelective(Category record) {
		return this.insertSelective(record);
	}

	@Override
	public List<Category> selectByExample(CategoryExample example) {
		return this.categoryMapper.selectByExample(example);
	}

	@Override
	public Category selectByPrimaryKey(String cid) {
		return this.categoryMapper.selectByPrimaryKey(cid);
	}

	@Override
	public int updateByExampleSelective(Category record, CategoryExample example) {
		return this.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Category record, CategoryExample example) {
		return this.categoryMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Category record) {
		return this.categoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Category record) {
		return this.categoryMapper.updateByPrimaryKey(record);
	}

	public List<Category> selectByCidForPid(String cid) {
		CategoryExample example = new CategoryExample();
		example.createCriteria().andPidEqualTo(cid);
		return categoryMapper.selectByExample(example);
	}

	public List<Category> selectByCname(Category category) {
		CategoryExample example = new CategoryExample();
		example.createCriteria().andCnameEqualTo(category.getCname());
		return categoryMapper.selectByExample(example);
	}
}
