package com.atguigu.springboot_config.pojo;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
// 不加下面两个注解（有参构造器，无参构造器） @JsonIgnore 会出错  No fallback setter/field defined for creator property 'id'
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder(value = {"content","title"})
public class Article {

//    @JsonIgnore || 排除该属性的序列化与反序列化
    private Long  id;

//    @JsonProperty(value = "creator") || 修改json属性值
    private String author;

    private String title;

    private String content;
    @JsonInclude(JsonInclude.Include.NON_NULL) // 如果json子串中的值为空则不做序列化和反序列化处理
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") // 格式化属性格式
    private Date createTime;

    private List<Reader> reader;
}
