package com.atguigu.springboot_config.controller;

import com.atguigu.springboot_config.pojo.AjaxResponse;
import com.atguigu.springboot_config.pojo.Article;
import com.atguigu.springboot_config.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
// private static final Logger log = LoggerFactory.getLogger(ReaderController.class);
@RestController
@RequestMapping("/rest")
public class ReaderController {
    @Resource
    ArticleService articleService;

    @ApiOperation(value = "添加文章",notes = "添加新的文章",tags = "Article",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功",response = AjaxResponse.class),
            @ApiResponse(code = 400,message = "用户输入错误",response = AjaxResponse.class),
            @ApiResponse(code = 500,message = "系统内部错误",response = AjaxResponse.class)
    })
    @PostMapping(value = "/article",produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody Article article){

        log.info("saveArticle:{}"+articleService.saveArticle(article));
        return AjaxResponse.success(article);
    }

    @DeleteMapping(value = "/article/{id}",produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Long id){
        log.info("deleteArticle:{}",id);
        return AjaxResponse.success(id);
    }

    @PutMapping(value = "/article/{id}",produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id,@RequestBody Article article){
        article.setId(id);
         log.info("updateArticle:{}",article);
         return AjaxResponse.success(article);
    }

    @GetMapping(value = "/article/{id}",produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id){
        Article article = Article.builder().id(1L).author("松尾芭蕉").
                    content("岁月为百代之过客").createTime(new Date()).title("奥之细道").build();
        return AjaxResponse.success(article);

    }
}
