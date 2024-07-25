package edu.hitwh.homework.service.impl.PublicService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.hitwh.homework.mapper.PublicService.CompanyMapper;
import edu.hitwh.homework.pojo.PageBean;
import edu.hitwh.homework.pojo.PublicService.Company;
import edu.hitwh.homework.service.PublicService.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public PageBean page(int page, int size, String companyName, String companyType) {
        PageHelper.startPage(page, size);
        List<Company> companyList = companyMapper.list(companyName, companyType);
        Page<Company> p = (Page<Company>) companyList;
        return new PageBean(p.getTotal(), p.getResult());
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
