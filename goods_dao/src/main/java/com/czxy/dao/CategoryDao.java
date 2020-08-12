package com.czxy.dao;

import com.czxy.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CategoryDao {

    /**
     * 查询所有的分类
     * @return
     */
    @Select("select  * from  tbl_category")
    List<Category> findAllCategory();

    /**
     * 通过cid查询分类
     * @param cid
     * @return
     */

    @Select("select * from tbl_category where cid = #{cid}")
    Category findCategoryByCid(@Param("cid") String cid);

}
