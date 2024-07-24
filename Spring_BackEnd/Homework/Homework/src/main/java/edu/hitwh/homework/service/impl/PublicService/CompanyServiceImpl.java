package edu.hitwh.homework.service.impl.PublicService;

import edu.hitwh.homework.mapper.PublicService.CompanyMapper;
import edu.hitwh.homework.pojo.PublicService.Company;
import edu.hitwh.homework.service.PublicService.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> list(int page, int size) {
        int offset = (page - 1) * size; // 计算分页偏移量
        return companyMapper.list(offset, size);
    }

    @Override
    public void delete(Integer id) {
        companyMapper.delete(id);
    }

    @Override
    public void add(Company company) {
        companyMapper.add(company);
    }

    @Override
    public Company selectById(Integer id) {
        return companyMapper.selectById(id);
    }

    @Override
    public void update(Company company) {
        companyMapper.update(company);
    }
}
