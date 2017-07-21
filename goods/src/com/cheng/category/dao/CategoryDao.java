package com.cheng.category.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheng.category.pojo.Categorypojo;
import com.cheng.dao.CategoryMapper;
import com.cheng.domain.Category;
import com.cheng.domain.CategoryExample;

@Repository
public class CategoryDao implements CategoryMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询所有图书列表信息
     */
    public List<Categorypojo> selectAllcategorys() throws Exception {
        List<Categorypojo> categorypojos = new ArrayList<Categorypojo>();
        CategoryExample categoryExample = new CategoryExample();

        categoryExample.createCriteria().andPidIsNull();
        List<Category> list = this.categoryMapper
                .selectByExample(categoryExample);

        for (Category category : list) {

            Categorypojo pojo = new Categorypojo();
            BeanUtils.copyProperties(pojo, category);

            CategoryExample categoryExample2 = new CategoryExample();
            categoryExample2.createCriteria().andPidEqualTo(category.getCid());
            List<Category> selectByExample = categoryMapper
                    .selectByExample(categoryExample2);
            pojo.setChildren(selectByExample);

            categorypojos.add(pojo);
        }
        // System.out.println(categorypojos);
        return categorypojos;
    }

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

    @Override
    public List<Category> selectByCidForPid(String cid) {
        return this.categoryMapper.selectByCidForPid(cid);
    }
}
