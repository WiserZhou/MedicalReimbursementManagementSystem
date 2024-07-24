package edu.hitwh.homework.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 分页查询结果封装类
 * write by Jerry Xin
 * 2024.4.18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total; //总记录数,api文档已经说明
    private List rows; //数据列表,api文档已经说明
}
