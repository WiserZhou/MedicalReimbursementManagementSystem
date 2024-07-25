package edu.hitwh.homework.mapper.PublicService;


import edu.hitwh.homework.pojo.PublicService.Special;
import org.apache.ibatis.annotations.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@Mapper
public interface SpecialMapper {

    // 根据条件查询班级列表
    List<Special> list(@Param("personID") String personID);

    // 插入班级信息
    @Insert("INSERT INTO t_sepcial_approval (approval_number, person_ID, approval_category, start_date, termination_date,drug_code," +
            "approval_opinions,approver,approval_date,approval_flag) " +
            "VALUES (#{approvalNumber}, #{personID}, #{approvalCategory}, #{startTime}, #{terminationDate},#{drugCode}," +
            "#{approvalOpinions},#{approver},#{approvalDate},#{approvalFlag})")
    void insert(Special Special) throws SQLIntegrityConstraintViolationException;

    // 更新班级信息
    void update(Special Special) throws SQLIntegrityConstraintViolationException;

    // 删除班级信息
    @Delete("DELETE FROM t_sepcial_approval WHERE approval_number = #{approvalNumber}")
    void delete(String approvalNumber) throws SQLIntegrityConstraintViolationException;

    // 获取所有班级列表
    @Select("SELECT * FROM t_sepcial_approval")
    List<Special> getAll();


    @Select("SELECT * FROM t_sepcial_approval WHERE approval_number = #{approvalNumber}")
    Special findByID(String approvalNumber) throws SQLIntegrityConstraintViolationException;


}
