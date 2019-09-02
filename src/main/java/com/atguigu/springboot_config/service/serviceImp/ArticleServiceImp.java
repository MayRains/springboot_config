package com.atguigu.springboot_config.service.serviceImp;

import com.atguigu.springboot_config.config.DozerBeanMapper;
import com.atguigu.springboot_config.dao.ArticleDao;
import com.atguigu.springboot_config.mapper.ArticleMapper;
import com.atguigu.springboot_config.pojo.Article;
import com.atguigu.springboot_config.service.ArticleService;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class ArticleServiceImp implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;


    @Override
    public Article findById(Long id) {
        return articleMapper.findById(id);
    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insert(article);
    }
}
