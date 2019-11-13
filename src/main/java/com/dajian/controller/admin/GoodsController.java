package com.dajian.controller.admin;

import com.dajian.entity.Goods;
import com.dajian.entity.PageBean;
import com.dajian.entity.Result;
import com.dajian.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 86156
 * @date 2019/7/20
 */
@RestController
@RequestMapping("/goods")
public class GoodsController  {
    @Autowired
    private GoodsService goodsService;
    //分页查询 查询条件 每页的记录数
    @RequestMapping("/findByConPage")
    public PageBean findByConPage(Goods goods,
                                  @RequestParam(value = "pageCode", required = false) int pageCode,
                                  @RequestParam(value = "pageSize", required = false) int pageSize){
        return goodsService.findByPage(goods, pageCode,pageSize);
    }

    //新增商品
    @RequestMapping("/create")
    public Result create(@RequestBody Goods goods){
        try{
            goodsService.create(goods);
            return new Result( true, "创建成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result( false, "发生未知错误");
        }
    }

    //更新数据
    @RequestMapping("/update")
    public Result update(@RequestBody Goods goods){
        try{
            goodsService.update(goods);
            return new Result( true, "创建成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result( false, "发生未知错误");
        }
    }

    /*
    批量删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long... ids){
        try{
            goodsService.delete(ids);
            return new Result(true, "更新数据成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result( false, "发生未知错误");
        }
    }

    @RequestMapping("/findById")
    public List<Goods> findById(@RequestParam(value = "id", required = false) Long id){
        return goodsService.findById(id);
    }
}
