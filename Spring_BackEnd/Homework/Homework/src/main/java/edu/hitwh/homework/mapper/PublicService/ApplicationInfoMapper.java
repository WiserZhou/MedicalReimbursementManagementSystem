package edu.hitwh.homework.mapper.PublicService;


import edu.hitwh.homework.pojo.PublicService.ApplicationInfo;
import io.jsonwebtoken.lang.Classes;
import org.apache.ibatis.annotations.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.List;


@Mapper
public interface ApplicationInfoMapper {

    // 根据条件查询班级列表
    List<ApplicationInfo> list(@Param("personID") String personID);

    // 插入班级信息
    @Insert("INSERT INTO t_application_info (approval_number, person_ID, approval_category, start_date, termination_date,medical_institution_code," +
            "approval_opinions,approver,approval_date,approval_flag) " +
            "VALUES (#{approvalNumber}, #{personID}, #{approvalCategory}, #{startTime}, #{terminationDate},#{medicalInstitutionCode}," +
            "#{approvalOpinions},#{approver},#{approvalDate},#{approvalFlag})")
    void insert(ApplicationInfo applicationInfo) throws SQLIntegrityConstraintViolationException;

    // 更新班级信息
    void update(ApplicationInfo applicationInfo) throws SQLIntegrityConstraintViolationException;

    // 删除班级信息
    @Delete("DELETE FROM t_application_info WHERE approval_number = #{approvalNumber}")
    void delete(String approvalNumber) throws SQLIntegrityConstraintViolationException;

    // 获取所有班级列表
    @Select("SELECT * FROM t_application_info")
    List<ApplicationInfo> getAll();


    @Select("SELECT * FROM t_application_info WHERE approval_number = #{approvalNumber}")
    ApplicationInfo findByID(String approvalNumber) throws SQLIntegrityConstraintViolationException;


}
