package com.cheng.category.pojo;

import java.util.List;

import com.cheng.domain.Category;

public class Categorypojo extends Category {

	private List<Category> children;

	@Override
	public String toString() {
		return super.toString()+"Categorypojo [children=" + children + "]";
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}
}
