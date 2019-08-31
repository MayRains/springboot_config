package com.atguigu.springboot_config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class SpringbootConfigApplicationTests {

    @Resource
    private MockMvc mockMvc;

    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {
//        最低级别 trace 可以在配置文件中修改日志级别 || logging.level.com.atguigu=trace
        logger.trace("跟踪trace");
        logger.debug("debug日志");
//        spring boot 默认使用的是info级别 || 由低至高
        logger.info("info_log");
        logger.warn("warn_log");
        logger.error("error_log");
    }
    @Test
    public void saveAricle() throws Exception{
        String testStr = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"zimug\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                "    \"createTime\": \"2017-07-16 05:23:34\",\n" +
                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";
        MvcResult res = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,"/rest/article")
                                .contentType("application/json").content(testStr))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                                .andDo(print())
                                .andReturn();
        log.info(res.getResponse().getContentAsString());
    }

}
