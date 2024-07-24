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
    private String companyType; // 单位类型 (0, 1, 2, 3)
    private String address; // 地址
    private String postcode; // 邮编
    private String phoneNumber; // 联系电话
}
