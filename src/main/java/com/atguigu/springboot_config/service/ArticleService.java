package com.atguigu.springboot_config.service;


import com.atguigu.springboot_config.pojo.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ArticleService {

    public String saveArticle(Article article){

        log.info("save_Article()",article);
        return "测试";
    }
}
