package edu.hitwh.homework.pojo.BasicMedicalInformationMaintenance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class medical_insititution {
    private int DiaId; // 诊疗项目编码
    private String DiaName; // 项目名称
    private String DiaExpType; // 收费类别
    private String DiaExpLevel; // 收费项目等级
    private String DiaMaxPrize; // 最高限价
    private String DiaStarttime; // 开始日期
    private String DiaEndtime; // 终止日期
    private String DiaValid; // 有效标志
    private String DiaHosLevel; // 医院等级
    private String DiaApprovalmark; //是否需要审批标志
}










