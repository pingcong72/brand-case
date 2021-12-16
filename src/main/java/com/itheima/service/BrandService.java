package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

/**
 * @Author: Ping
 * @Date: 2021-12-12 01:24
 * @Description: TODO
 */
public interface BrandService {

    List<Brand> selectAll();

    void add(Brand brand);

    /**
     * 批量删除
     * @param ids 批量选择的brand对象id集合
     */
    void deleteByIds(int[] ids);

    void deleteById(int id);

    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页显示条数
     * @return PageBean对象
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /**
     * 根据条件查询记录
     * @param currentPage 当前页码
     * @param pageSize 每页显示条数
     * @param brand 条件对象
     * @return PageBean对象
     */
    PageBean<Brand> selectByCondition(int currentPage, int pageSize, Brand brand);

    /**
     * 修改brand信息
     * @param brand 要修改的brand记录
     */
    void update(Brand brand);
}
