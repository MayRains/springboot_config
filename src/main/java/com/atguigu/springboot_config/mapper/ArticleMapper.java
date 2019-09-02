package com.atguigu.springboot_config.mapper;


import com.atguigu.springboot_config.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface ArticleMapper {

    @Select("select *  from article where id = #{id}")
    Article findById(long id);

    @Insert("insert into article(author,content,title,createTime) values (#{author},#{content},#{title},#{createTime})")
    void insert(Article rec);
}
