package com.atguigu.springboot_config;


import com.atguigu.springboot_config.controller.ReaderController;
import com.atguigu.springboot_config.pojo.Article;
import com.atguigu.springboot_config.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
// 只测试 ReaderController
@WebMvcTest(ReaderController.class)
public class ArticleRestTest {

    @Resource // 与 @AutoWired 的区别 || https://blog.csdn.net/weixin_40423597/article/details/80643990
    private MockMvc mockMvc;

    @MockBean // 如果我们使用了WebMvcTest，只加载了Controller层的bean，那么Controller所依赖的Service没有被加载进来怎么办？ 我们可以用MockBean伪造一个Service 。
    ArticleService articleService;

    @Test
    public void testSaveArticle() throws Exception {
        String testStr = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"zimug\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                "    \"createTime\": \"2017-07-16 05:23:34\",\n" +
                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Article article = objectMapper.readValue(testStr,Article.class);
        // 打桩
        when(articleService.saveArticle(article)).thenReturn(article.toString());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/article")
                .contentType("application/json").content(testStr))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(print())
                .andReturn();

        log.info(result.getResponse().getContentAsString());
    }

}
