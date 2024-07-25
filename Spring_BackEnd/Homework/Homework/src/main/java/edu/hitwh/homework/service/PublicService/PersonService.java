package edu.hitwh.homework.service.PublicService;

import edu.hitwh.homework.pojo.PageBean;
import edu.hitwh.homework.pojo.PublicService.Person;

public interface PersonService {

    /**
     * 查询人员信息，支持分页
     * @param page 页码
     * @param size 每页条数
     * @return 人员信息列表
     */
    PageBean page(int page, int size, String personName, String personType);

    /**
     * 根据id删除人员信息
     * @param id 人员ID
     */
    void delete(Integer id);

    /**
     * 添加人员信息
     * @param person 人员信息
     */
    void add(Person person);

    /**
     * 根据id查询人员信息
     * @param id 人员ID
     * @return 人员信息
     */
    Person selectById(Integer id);

    /**
     * 更新人员信息
     * @param person 人员信息
     */
    void update(Person person);
}
