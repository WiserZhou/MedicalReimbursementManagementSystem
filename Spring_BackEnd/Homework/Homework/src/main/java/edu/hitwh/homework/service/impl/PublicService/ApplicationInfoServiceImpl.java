package edu.hitwh.homework.service.impl.PublicService;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.hitwh.homework.mapper.PublicService.ApplicationInfoMapper;
import edu.hitwh.homework.pojo.PageBean;
import edu.hitwh.homework.pojo.PublicService.ApplicationInfo;
import edu.hitwh.homework.service.PublicService.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class ApplicationInfoServiceImpl implements ApplicationInfoService {

    @Autowired
    private ApplicationInfoMapper applicationInfoMapper;

    /**
     * 分页查询班级信息
     *
     * @param page     页码
     * @param pageSize 每页记录数
     * @return 分页后的班级信息
     */
    @Override
    public PageBean page(Integer page, Integer pageSize, String personID) {
        PageHelper.startPage(page, pageSize);
        List<ApplicationInfo> classList = applicationInfoMapper.list(personID);
        PageInfo<ApplicationInfo> pageInfo = new PageInfo<>(classList);
        return new PageBean(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 获取所有班级信息
     *
     * @return 所有班级信息列表
     */
    @Override
    public List<ApplicationInfo> getAll() {
        return applicationInfoMapper.getAll();
    }

    /**
     * 根据ID查询班级信息
     *
     * @return 对应ID的班级信息
     */
    @Override
    public ApplicationInfo getById(String approvalNumber) throws SQLIntegrityConstraintViolationException {
        return applicationInfoMapper.findByID(approvalNumber);
    }

    @Override
    public void save(ApplicationInfo applicationInfo) {
        try {
            applicationInfoMapper.insert(applicationInfo);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("该审批单已存在", e);
        }
    }

    @Override
    public void update(ApplicationInfo applicationInfo) {
        try {
            applicationInfoMapper.update(applicationInfo);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("该班级名称已存在", e);
        }
    }

    @Override
    public void delete(String approvalNumber) {
        try {
            applicationInfoMapper.delete(approvalNumber);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("无法直接删除", e);
        }
    }

}
