package com.czxy.service;


import com.czxy.dao.GoodsDao;
import com.czxy.pojo.Goods;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;

    /**
     * 校验商品名称
     * @param pname
     * @return
     */
    public Boolean checkPname(String pname) {
            //查询
        List<Goods> goodsList = goodsDao.checkPname(pname);

        if (goodsList!=null && goodsList.size() !=0 ){
            //说明已经存在
            return  false;
        }

        return true;
    }

    /**
     * 添加商品
     * @param goods
     */
    public void addGoods(Goods goods) {
        goodsDao.insert(goods);
    }

    /**
     * 查询所有商品
     * @return
     */
    public List<Goods> findAllGoods() {

          List<Goods> goodsList =  goodsDao.findAllGoods();
        return goodsList;
    }
}
