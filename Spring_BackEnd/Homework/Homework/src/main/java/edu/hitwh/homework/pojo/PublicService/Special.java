package edu.hitwh.homework.pojo.PublicService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Special {
    private String approvalNumber; // 审批编号
    private String personID; // 人员ID
    private String approvalCategory; // 审批类别
    private LocalDate startDate; // 开始日期
    private LocalDate terminationDate; // 终止日期
    private String drugCode; // 药品编码
    private String approvalOpinions;//审批意见
    private String approver;//审批人
    private LocalDate approvalDate;//审批日期
    private String approvalFlag;//审批标志
}
//审批类别
//0	人员就诊机构审批
//1	药品特检特制审批
//2	非定点就医审批
//3	家庭病床审批
//4	离休二乙定点审批
//5	零星报销待遇认定审批类别
//6	慢性病特病审批
//7	门诊特检特制审批
//8	普通待遇审批
//9	异地人员登记
//10	转院申请
//11	追加定额审批