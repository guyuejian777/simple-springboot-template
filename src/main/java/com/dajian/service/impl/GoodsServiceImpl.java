package com.dajian.service.impl;

import com.dajian.entity.Goods;
import com.dajian.entity.PageBean;
import com.dajian.mapper.GoodsMapper;
import com.dajian.service.GoodsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 86156
 * @date 2019/7/19
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /*
    分页查询-条件查询方法
    goods   查询条件
    pageCode 当前页
    pageSize 每页的记录数
     */
    @Override
    public PageBean findByPage(Goods goods, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<Goods> page = goodsMapper.findByPage(goods);
        return new PageBean(page.getTotal(),page.getResult());
    }

    @Override
    public List<Goods> findAll() {
        return goodsMapper.findAll();
    }


    @Override
    public List<Goods> findById(Long id) {
        return goodsMapper.findById(id);
    }

    @Override
    public void create(Goods goods) {
        goodsMapper.create(goods);
    }

    @Override
    public void delete(Long... ids) {
        for (int i=0; i<ids.length; i++){
            goodsMapper.delete(ids[i]);
        }
    }

    @Override
    public void update(Goods goods) {
        goodsMapper.update(goods);
    }
}
