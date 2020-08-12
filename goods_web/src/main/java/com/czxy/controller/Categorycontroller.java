package com.czxy.controller;


import com.czxy.pojo.Category;
import com.czxy.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/category")
public class Categorycontroller {

    @Resource
    private CategoryService categoryService;

    /**
     * 查询所有分类
     * @return
     */
    @GetMapping("/findAllCategory")
    public ResponseEntity<List<Category>> findAllCategory(HttpServletRequest request ){
       List<Category> categoryList = categoryService.findAllCategory();
       return ResponseEntity.ok(categoryList);
    }


}
