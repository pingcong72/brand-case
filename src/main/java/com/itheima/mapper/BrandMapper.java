package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    @Select("select * from tb_brand order by id desc")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values (null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status})")
    void add(Brand brand);

    /**
     * 根据id批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 根据id删除单挑记录
     * @param id
     */
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);

    /**
     * 分页查询
     * @param begin 开始索引
     * @param size 查询记录数
     * @return BrandBean集合
     */
    @Select("select * from tb_brand limit #{begin}, #{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总记录数
     * @return 总记录数
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    /**
     * 根据条件进行分页查询
     * @param begin 开始索引
     * @param size 查询记录数
     * @param brand 查询条件
     * @return 满足条件的Brand记录
     */
    List<Brand> selectByCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    /**
     * 根据条件查询满足记录数
     * @return 满足条件的记录数
     */
    int selectTotalCountByCondition(Brand brand);

    /**
     * 修改brand
     * @param brand 要修改信息的brand对象
     */
    @Update("update tb_brand set brand_name = #{brandName}, company_name = #{companyName}, ordered = #{ordered}, description = #{description}, status = #{status} where id = #{id}")
    void update(Brand brand);
}
