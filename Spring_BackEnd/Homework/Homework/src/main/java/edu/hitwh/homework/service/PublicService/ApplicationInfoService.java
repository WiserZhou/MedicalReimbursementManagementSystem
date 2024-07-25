package edu.hitwh.homework.service.PublicService;


import edu.hitwh.homework.pojo.PageBean;
import edu.hitwh.homework.pojo.PublicService.ApplicationInfo;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.List;

public interface ApplicationInfoService {


    /**
     * 分页查询班级信息
     *
     * @param page     当前页码
     * @param pageSize 每页显示数量
     * @return 分页结果对象
     */
    PageBean page(Integer page, Integer pageSize, String personID);

    /**
     * 获取所有班级信息
     *
     * @return 班级列表
     */
    List<ApplicationInfo> getAll();

    ApplicationInfo getById(String approvalNumber) throws SQLIntegrityConstraintViolationException;


    void save(ApplicationInfo applicationInfo);


    void update(ApplicationInfo applicationInfo);

    /**
     * 删除班级信息
     *
     */
    void delete(String approvalNumber);

}
