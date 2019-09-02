package com.atguigu.springboot_config.service;


import com.atguigu.springboot_config.pojo.Article;

public interface ArticleService {

     Article findById(Long id);
     void insertArticle(Article article);
}
