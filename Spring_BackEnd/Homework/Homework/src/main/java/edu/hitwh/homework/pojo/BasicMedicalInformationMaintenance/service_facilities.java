package edu.hitwh.homework.pojo.BasicMedicalInformationMaintenance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class service_facilities {
    private int SerId; // 医疗服务设施编码
    private String SerName; // 服务设施名称
    private String SerExpType; // 收费类别
    private String SerStarttime; // 开始日期
    private String SerEndtime; // 终止日期
    private String SerValid; // 有效标志
}






