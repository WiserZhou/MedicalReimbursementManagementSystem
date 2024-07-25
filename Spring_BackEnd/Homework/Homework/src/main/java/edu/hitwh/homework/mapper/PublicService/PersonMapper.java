package edu.hitwh.homework.mapper.PublicService;

import edu.hitwh.homework.pojo.PublicService.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonMapper {

    /**
     * 分页查询人员信息
     * @param personName 人员姓名
     * @param personType 人员类型
     * @return 人员信息列表
     */
    public List<Person> list(String personName, String personType);

    /**
     * 根据ID删除人员信息
     * @param id 人员ID
     */
    @Delete("DELETE FROM people WHERE people_id = #{id}")
    void delete(@Param("id") Integer id);

    /**
     * 添加人员信息
     * @param person 人员信息
     */
    @Insert("INSERT INTO people (ID_type, ID, name, sex, nationality, birthday, work_date, retirement_date, retirement, residence_type, residence_address, education, political_status, identity, employment, technical_position, worker_level, marriage, administrative_position, note, company_id, medical_personnel, health, model_worker, cadre, civil_servant, authorized_strength, resident_type, flexible_employment, migrant_worker, employer, military_personnel, social_security_id, medins_id) " +
            "VALUES (#{idType}, #{id}, #{name}, #{sex}, #{nationality}, #{birthday}, #{workDate}, #{retirementDate}, #{retirement}, #{residenceType}, #{residenceAddress}, #{education}, #{politicalStatus}, #{identity}, #{employment}, #{technicalPosition}, #{workerLevel}, #{marriage}, #{administrativePosition}, #{note}, #{companyId}, #{medicalPersonnel}, #{health}, #{modelWorker}, #{cadre}, #{civilServant}, #{authorizedStrength}, #{residentType}, #{flexibleEmployment}, #{migrantWorker}, #{employer}, #{militaryPersonnel}, #{socialSecurityId}, #{medinsId})")
    void add(Person person);

    /**
     * 根据ID查询人员信息
     * @param id 人员ID
     * @return 人员信息
     */
    @Select("SELECT * FROM people WHERE people_id = #{id}")
    Person selectById(@Param("id") Integer id);

    /**
     * 更新人员信息
     * @param person 人员信息
     */
    @Update("UPDATE people SET ID_type = #{idType}, ID = #{id}, name = #{name}, sex = #{sex}, nationality = #{nationality}, birthday = #{birthday}, work_date = #{workDate}, retirement_date = #{retirementDate}, retirement = #{retirement}, residence_type = #{residenceType}, residence_address = #{residenceAddress}, education = #{education}, political_status = #{politicalStatus}, identity = #{identity}, employment = #{employment}, technical_position = #{technicalPosition}, worker_level = #{workerLevel}, marriage = #{marriage}, administrative_position = #{administrativePosition}, note = #{note}, company_id = #{companyId}, medical_personnel = #{medicalPersonnel}, health = #{health}, model_worker = #{modelWorker}, cadre = #{cadre}, civil_servant = #{civilServant}, authorized_strength = #{authorizedStrength}, resident_type = #{residentType}, flexible_employment = #{flexibleEmployment}, migrant_worker = #{migrantWorker}, employer = #{employer}, military_personnel = #{militaryPersonnel}, social_security_id = #{socialSecurityId}, medins_id = #{medinsId} " +
            "WHERE people_id = #{peopleId}")
    void update(Person person);
}
