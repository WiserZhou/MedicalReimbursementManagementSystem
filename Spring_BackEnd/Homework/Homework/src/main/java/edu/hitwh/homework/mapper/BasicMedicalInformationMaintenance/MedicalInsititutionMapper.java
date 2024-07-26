package edu.hitwh.homework.mapper.BasicMedicalInformationMaintenance;

import edu.hitwh.homework.pojo.BasicMedicalInformationMaintenance.MedicalInsititution;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MedicalInsititutionMapper {

    /**
     * 分页查询定点医疗机构信息
     * @param offset 偏移量
     * @param size 每页条数
     * @return 定点医疗机构信息列表
     */
    @Select("SELECT * FROM medicalInsititution LIMIT #{offset}, #{size}")
    List<MedicalInsititution> list(@Param("offset") int offset, @Param("size") int size);

    /**
     * 根据ID删除定点医疗机构信息
     * @param dia_id 定点医疗机构ID
     */
    @Delete("DELETE FROM medicalInsititution WHERE medicalInsititution_dia_id = #{dia_id}")
    vodia_id delete(@Param("dia_id") Integer dia_id);

    /**
     * 添加定点医疗机构信息
     * @param medicalInsititution 定点医疗机构信息
     */
    @Insert("INSERT INTO medicalInsititution (dia_name, dia_exp_type,dia_exp_level ,dia_max_prize,dia_starttime,dia_endtime,dia_valid,dia_hos_level,dia_approvalmark) " +
            "VALUES  (#{diaName}, #{diaExpType}, #{diaExpLevel}, #{diaMaxPrize}, #{diaStarttime}, #{diaEndtime}, #{diaValid}, #{diaHosLevel}, #{diaApprovalmark})")
    vodia_id add(MedicalInsititution medicalInsititution);

    /**
     * 根据ID查询定点医疗机构信息
     * @param dia_id 定点医疗机构ID
     * @return 定点医疗机构信息
     */
    @Select("SELECT * FROM medicalInsititution WHERE medicalInsititution_dia_id = #{dia_id}")
    MedicalInsititution selectById(@Param("dia_id") Integer dia_id);

    /**
     * 更新定点医疗机构信息
     * @param medicalInsititution 定点医疗机构信息
     */
    @Update("UPDATE medicalInsititution SET dia_name = #{diaName}, dia_exp_type = #{diaExpType},dia_exp_level = #{diaExpLevel}, dia_max_prize = #{diaMaxPrize}, dia_starttime = #{diaStarttime}, dia_endtime = #{diaEndtime}, dia_valid = #{diaValid}, dia_hos_level = #{diaHosLevel}, dia_approvalmark = #{diaApprovalmark}")
    vodia_id update(MedicalInsititution medicalInsititution);
}
