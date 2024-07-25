package edu.hitwh.homework.service.PublicService;


import edu.hitwh.homework.pojo.PageBean;
import edu.hitwh.homework.pojo.PublicService.Special;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface SpecialService {


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
    List<Special> getAll();

    Special getById(String approvalNumber) throws SQLIntegrityConstraintViolationException;


    void save(Special Special);


    void update(Special Special);

    /**
     * 删除班级信息
     *
     */
    void delete(String approvalNumber);

}
