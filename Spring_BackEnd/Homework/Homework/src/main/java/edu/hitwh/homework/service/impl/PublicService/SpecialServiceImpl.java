package edu.hitwh.homework.service.impl.PublicService;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.hitwh.homework.mapper.PublicService.SpecialMapper;
import edu.hitwh.homework.pojo.PageBean;
import edu.hitwh.homework.pojo.PublicService.Special;
import edu.hitwh.homework.service.PublicService.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class SpecialServiceImpl implements SpecialService {

    @Autowired
    private SpecialMapper specialMapper;

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
        List<Special> classList = specialMapper.list(personID);
        PageInfo<Special> pageInfo = new PageInfo<>(classList);
        return new PageBean(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 获取所有班级信息
     *
     * @return 所有班级信息列表
     */
    @Override
    public List<Special> getAll() {
        return specialMapper.getAll();
    }

    /**
     * 根据ID查询班级信息
     *
     * @return 对应ID的班级信息
     */
    @Override
    public Special getById(String approvalNumber) throws SQLIntegrityConstraintViolationException {
        return specialMapper.findByID(approvalNumber);
    }

    @Override
    public void save(Special Special) {
        try {
            specialMapper.insert(Special);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("该审批单已存在", e);
        }
    }

    @Override
    public void update(Special Special) {
        try {
            specialMapper.update(Special);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("该班级名称已存在", e);
        }
    }

    @Override
    public void delete(String approvalNumber) {
        try {
            specialMapper.delete(approvalNumber);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("无法直接删除", e);
        }
    }

}
