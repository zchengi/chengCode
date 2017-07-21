package com.cheng.classified.service;

import java.util.List;

import com.cheng.category.pojo.Categorypojo;
import com.cheng.domain.Category;

public interface ClassifiedService {

    List<Categorypojo> getCategory() throws Exception;

    String deleteCategory1(String cid);

    String deleteCategory2(String cid);

    String add(Category category);

    Category toEdit(String cid);

    String edit(Category category);
}
