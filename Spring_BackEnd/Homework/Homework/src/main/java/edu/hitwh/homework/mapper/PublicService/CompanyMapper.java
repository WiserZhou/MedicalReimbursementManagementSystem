package edu.hitwh.homework.mapper.PublicService;

import edu.hitwh.homework.pojo.PublicService.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {

    /**
     * 分页查询单位信息
     * @param offset 偏移量
     * @param size 每页条数
     * @return 单位信息列表
     */
    @Select("SELECT * FROM company LIMIT #{offset}, #{size}")
    List<Company> list(@Param("offset") int offset, @Param("size") int size);

    /**
     * 根据ID删除单位信息
     * @param id 单位ID
     */
    @Delete("DELETE FROM company WHERE company_id = #{id}")
    void delete(@Param("id") Integer id);

    /**
     * 添加单位信息
     * @param company 单位信息
     */
    @Insert("INSERT INTO company (company_name, company_type, address, postcode, phone_number) " +
            "VALUES (#{companyName}, #{companyType}, #{address}, #{postcode}, #{phoneNumber})")
    void add(Company company);

    /**
     * 根据ID查询单位信息
     * @param id 单位ID
     * @return 单位信息
     */
    @Select("SELECT * FROM company WHERE company_id = #{id}")
    Company selectById(@Param("id") Integer id);

    /**
     * 更新单位信息
     * @param company 单位信息
     */
    @Update("UPDATE company SET company_name = #{companyName}, company_type = #{companyType}, " +
            "address = #{address}, postcode = #{postcode}, phone_number = #{phoneNumber} " +
            "WHERE company_id = #{companyId}")
    void update(Company company);
}
