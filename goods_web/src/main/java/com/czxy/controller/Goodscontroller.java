package com.czxy.controller;


import com.czxy.pojo.Goods;
import com.czxy.service.GoodsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class Goodscontroller{

    @Resource
    private GoodsService goodsService;
    /**
     * 查询所有的商品
     * @return
     */
    @GetMapping("/findAllGoods")
    public ResponseEntity<List<Goods>> findAllGoods(){
        List<Goods> goodsList = goodsService.findAllGoods();
        System.err.println(goodsList);
        return ResponseEntity.ok(goodsList);
    }

    /**
     * 校验商品名称
     * @param pname
     * @return
     */
    @GetMapping("/checkPname/{pname}")
    public ResponseEntity<Boolean> checkPname(@PathVariable("pname")String pname){

            //查询条件
        System.err.println(pname);
        Boolean result =  goodsService.checkPname(pname);



        return ResponseEntity.ok(result);
    }

    /**
     * 添加商品
     * @param goods
     * @return
     */
    @PostMapping("/addGoods")
    public String addGoods(Goods goods){

        System.out.println(goods);
        //添加商品
        goodsService.addGoods(goods);
     //重定向
        return "redirect:/goods/list.jsp";
    }


}
