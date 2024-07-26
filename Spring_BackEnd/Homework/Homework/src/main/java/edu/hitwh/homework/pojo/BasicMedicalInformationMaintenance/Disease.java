package edu.hitwh.homework.pojo.BasicMedicalInformationMaintenance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disease {
    private int DiseaseId; // 疾病编码
    private String DiseaseName; // 病种名称
    private String DiseaseType; // 疾病种类
    private String DiseaseReimbursementStandards; // 疾病报销标志
    private String Notes; // 备注
}





