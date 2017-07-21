package com.cheng.category.pojo;

import java.util.List;

import com.cheng.domain.Category;

public class Categorypojo extends Category {

    private List<Category> children;

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
