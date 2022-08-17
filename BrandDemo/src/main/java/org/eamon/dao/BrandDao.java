package org.eamon.dao;

import org.apache.ibatis.annotations.*;
import org.eamon.bean.Brand;
import org.eamon.bean.PageParam;

import java.util.List;

public interface BrandDao {
    /**
     * 查询所有信息
     */
    @Results(id = "brandMap", value = {
            @Result(column = "company_name", property = "companyName"),
            @Result(column = "brand_name", property = "brandName")
    })
    @Select("select * from tb_brand")
    List<Brand> showAll();

    /**
     * 添加新的品牌
     */

    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    int insert(Brand brand);

    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status=#{status} where id = #{id}")
    int update(Brand brand);

    int delete(@Param("ids") int[] ids);

    int totalBrands(PageParam pageParam);

    List<Brand> pagination(@Param("offset") int offset,@Param("pageParam") PageParam pageParam);
}
