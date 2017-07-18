package com.cheng.category.service;

import java.util.List;

import com.cheng.category.pojo.Categorypojo;

public interface ICategorService {

	List<Categorypojo> getCategory() throws Exception;
}
