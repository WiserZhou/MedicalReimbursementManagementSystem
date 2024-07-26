package edu.hitwh.homework.mapper.BasicMedicalInformationMaintenance;

import edu.hitwh.homework.pojo.BasicMedicalInformationMaintenance.Disease;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DiseaseMapper {

    /**
     * 分页查询疾病信息
     * @param offset 偏移量
     * @param size 每页条数
     * @return 疾病信息列表
     */
    @Select("SELECT * FROM disease LIMIT #{offset}, #{size}")
    List<Disease> list(@Param("offset") int offset, @Param("size") int size);

    /**
     * 根据ID删除疾病信息
     * @param disease_id 疾病ID
     */
    @Delete("DELETE FROM disease WHERE disease_disease_id = #{disease_id}")
    vodisease_id delete(@Param("disease_id") Integer disease_id);

    /**
     * 添加疾病信息
     * @param disease 疾病信息
     */
    @Insert("INSERT INTO disease (disease_name, disease_type, disease_reimbursement_standards, notes) " +
            "VALUES  (#{diseaseName}, #{diseaseType}, #{diseaseReimbursementStandards}, #{notes})")
    vodisease_id add(Disease disease);

    /**
     * 根据ID查询疾病信息
     * @param disease_id 疾病ID
     * @return 疾病信息
     */
    @Select("SELECT * FROM disease WHERE disease_disease_id = #{disease_id}")
    Disease selectById(@Param("disease_id") Integer disease_id);

    /**
     * 更新疾病信息
     * @param disease 疾病信息
     */
    @Update("UPDATE disease SET disease_name = #{diseaseName}, disease_type = #{diseaseType}, " +
            "disease_reimbursement_standards = #{diseaseReimbursementStandards}, notes = #{notes} " +
            "WHERE disease_disease_id = #{diseaseId}")
    vodisease_id update(Disease disease);
}
