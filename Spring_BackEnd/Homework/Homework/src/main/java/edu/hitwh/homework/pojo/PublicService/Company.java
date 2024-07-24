package edu.hitwh.homework.pojo.PublicService;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private int companyId; // 单位编码
    private String companyName; // 单位名称
    private String companyAddress; // 单位地址
    // 其他字段可根据实际业务需求添加
}
