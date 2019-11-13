package com.dajian.mapper;

import com.dajian.entity.Goods;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> findAll();

    Page<Goods> findByPage(Goods goods);

    List<Goods> findById(Long id);
    void update(Goods goods);

    void delete(Long id);

    void create(Goods goods);

}
