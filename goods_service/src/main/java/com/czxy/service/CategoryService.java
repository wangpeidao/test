package com.czxy.service;


import com.czxy.dao.CategoryDao;
import com.czxy.pojo.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Resource
    private CategoryDao categoryDao;

    /**
     * 查询所有分类
     * @return
     */
    public List<Category> findAllCategory() {
        return categoryDao.findAllCategory();
    }
}
