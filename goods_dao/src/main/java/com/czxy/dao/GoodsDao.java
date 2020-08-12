package com.czxy.dao;

import com.czxy.pojo.Goods;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;



@org.apache.ibatis.annotations.Mapper
public interface GoodsDao extends Mapper<Goods> {
    /**
     * 校验商品名
     * @param goods_name
     * @return
     */
    @Select("select * from tbl_goods where  goods_name =#{goods_name}")
    List<Goods> checkPname(@Param("goods_name") String goods_name);

    /**
     * 查询所有商品
     * @return
     */
    @Select("select * from tbl_goods")
    @Results({
          @Result(property = "cid",column = "cid"),
          @Result(property = "category",column = "cid",one = @One(select = "com.czxy.dao.CategoryDao.findCategoryByCid"))
    })
    List<Goods> findAllGoods();






}
