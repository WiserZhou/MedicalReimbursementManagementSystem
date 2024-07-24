package edu.hitwh.homework.service.PublicService;

import edu.hitwh.homework.pojo.PublicService.Company;
import java.util.List;

public interface CompanyService {

    /**
     * 查询单位信息，支持分页
     * @param page 页码
     * @param size 每页条数
     * @return 单位信息列表
     */
    List<Company> list(int page, int size);

    /**
     * 根据id删除单位信息
     * @param id 单位ID
     */
    void delete(Integer id);

    /**
     * 添加单位信息
     * @param company 单位信息
     */
    void add(Company company);

    /**
     * 根据id查询单位信息
     * @param id 单位ID
     * @return 单位信息
     */
    Company selectById(Integer id);

    /**
     * 更新单位信息
     * @param company 单位信息
     */
    void update(Company company);
}
