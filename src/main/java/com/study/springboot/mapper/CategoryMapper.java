package com.study.springboot.mapper;

import com.study.springboot.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from category_")
    List<Category> findAll();

    @Insert("insert into category_ values(null, #{name})")
    public void save(Category category);

    @Delete("delete from category_ where id=#{id}")
    public void delete(int id);

    @Select("select * from category_ where id=#{id}")
    public Category get(int id);

    @Update("update category_ set name=#{name} where id=#{id}")
    public void update(Category category);
}
