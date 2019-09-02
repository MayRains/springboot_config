package com.atguigu.springboot_config.dao;


import com.atguigu.springboot_config.pojo.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


public class ArticleDao {

    @Resource
    private JdbcTemplate masterJdbcTemplate;

    public void saveArticle(Article article,JdbcTemplate jdbcTemplate){
        String sql = "INSERT INTO article(author,title,content,createtime) values(?,?,?,?)";
        if (jdbcTemplate == null){
            jdbcTemplate = masterJdbcTemplate;
        }
        jdbcTemplate.update(sql,
                article.getAuthor(),article.getTitle(),
                article.getContent(),article.getCreateTime());
    }

}
