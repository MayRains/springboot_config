package com.atguigu.springboot_config;


import com.atguigu.springboot_config.dao.ArticleDao;
import com.atguigu.springboot_config.pojo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleDaoTest {

    @Resource
    private ArticleDao articleDao;
    @Resource
    private JdbcTemplate masterJdbcTemplate;
    @Resource
    private JdbcTemplate clusterJdbcTemplate;

    @Test
    public void testDb(){
        articleDao.saveArticle(Article.builder().author("夏目漱石").title("我是猫")
                .content("niko").createTime(new Date()).build(),masterJdbcTemplate);

        articleDao.saveArticle(Article.builder().author("江南").title("龙族").content("火之晨曦")
        .createTime(new Date()).build(), clusterJdbcTemplate);
    }

}
