package com.dajian.service;

import com.dajian.entity.Goods;
import com.dajian.entity.PageBean;

public interface GoodsService extends BaseService<Goods> {
    PageBean findByPage(Goods goods, int pageCode, int pageSize);
}
