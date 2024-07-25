package edu.hitwh.homework.pojo.PublicService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int peopleId; // 个人ID
    private String idType; // 证件类型
    private String id; // 证件编号
    private String name; // 姓名
    private String sex; // 性别
    private String nationality; // 民族
    private Date birthday; // 出生日期
    private Date workDate; // 参加工作日期
    private Date retirementDate; // 离退休日期
    private String retirement; // 离退休状态
    private String residenceType; // 户口性质
    private String residenceAddress; // 户口所在地
    private String education; // 文化程度
    private String politicalStatus; // 政治面貌
    private String identity; // 个人身份
    private String employment; // 用工形式
    private String technicalPosition; // 专业技术职务
    private String workerLevel; // 国家职业资格等级（工人技术等级）
    private String marriage; // 婚姻状况
    private String administrativePosition; // 行政职务
    private String note; // 备注
    private Integer companyId; // 单位编码
    private String medicalPersonnel; // 医疗人员类别
    private String health; // 健康状况
    private String modelWorker; // 劳模标志
    private String cadre; // 干部标志
    private String civilServant; // 公务员标志
    private String authorizedStrength; // 在编标志
    private String residentType; // 居民类别
    private String flexibleEmployment; // 灵活就业标志
    private String migrantWorker; // 农民工标志
    private String employer; // 雇主标志
    private String militaryPersonnel; // 军转人员标志
    private String socialSecurityId; // 社保卡号（系统自动生成）
    private String medinsId; // 定点医疗机构编码
}
