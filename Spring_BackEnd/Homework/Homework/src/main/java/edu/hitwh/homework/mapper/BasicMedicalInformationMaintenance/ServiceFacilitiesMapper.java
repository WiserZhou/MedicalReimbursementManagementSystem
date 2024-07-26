package edu.hitwh.homework.mapper.BasicMedicalInformationMaintenance;

import edu.hitwh.homework.pojo.BasicMedicalInformationMaintenance.ServiceFacilities;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ServiceFacilitiesMapper {

    /**
     * 分页查询服务设施项目
     * @param offset 偏移量
     * @param size 每页条数
     * @return 服务设施项目列表
     */
    @Select("SELECT * FROM serviceFacilities LIMIT #{offset}, #{size}")
    List<ServiceFacilities> list(@Param("offset") int offset, @Param("size") int size);

    /**
     * 根据ID删除服务设施项目
     * @param ser_id 疾病ID
     */
    @Delete("DELETE FROM serviceFacilities WHERE serviceFacilities_ser_id = #{ser_id}")
    voser_id delete(@Param("ser_id") Integer ser_id);

    /**
     * 添加服务设施项目
     * @param serviceFacilities 服务设施项目
     */
    @Insert("INSERT INTO serviceFacilities (ser_name, ser_exp_type,ser_starttime,ser_endtime,ser_valid)\n" +
            "        VALUES (#{serName}, #{serExpType}, #{serStarttime}, #{serEndtime}, #{serValid})")
    voser_id add(ServiceFacilities serviceFacilities);

    /**
     * 根据ID查询服务设施项目
     * @param ser_id 疾病ID
     * @return 服务设施项目
     */
    @Select("SELECT * FROM serviceFacilities WHERE serviceFacilities_ser_id = #{ser_id}")
    ServiceFacilities selectById(@Param("ser_id") Integer ser_id);

    /**
     * 更新服务设施项目
     * @param serviceFacilities 服务设施项目
     */
    @Update("UPDATE serviceFacilities SET ser_name = #{serName}, ser_exp_type = #{serExpType}, ser_starttime = #{serStarttime}, ser_endtime = #{serEndtime}, ser_valid = #{serValid}" +
            "WHERE serviceFacilities_ser_id = #{serviceFacilitiesId}")
    voser_id update(ServiceFacilities serviceFacilities);
}
