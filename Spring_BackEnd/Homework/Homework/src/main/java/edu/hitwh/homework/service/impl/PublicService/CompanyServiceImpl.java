package edu.hitwh.homework.service.impl.PublicService;


import edu.hitwh.homework.mapper.PublicService.CompanyMapper;
import edu.hitwh.homework.service.PublicService.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

//    @Override
//    public List<Class> getAllClasses() {
//        return classMapper.getAllClasses();
//    }
//
//    @Override
//    public Class selectById(Integer id) {
//        return classMapper.selectById(id);
//    }
//
//    @Override
//    public List<Class> filterClassByDate(String startDate, String endDate) {
//        // Call the corresponding method in the mapper layer to retrieve data
//        return classMapper.filterClassByDate(startDate, endDate);
//    }
//
//    @Override
//    public List<Class> searchClassByName(String className) {
//        // Call the corresponding method in the mapper layer to retrieve data
//        return classMapper.searchClassByName(className);
//    }
//
//    @Override
//    public void addClass(Class classInfo) {
//        // Call the corresponding method in the mapper layer to add data
//        classMapper.addClass(classInfo);
//    }
//
//    @Override
//    public void deleteClass(Integer classId) {
//        // Call the corresponding method in the mapper layer to delete data
//        classMapper.deleteClass(classId);
//    }
//
//    @Override
//    public void updateClass(Class classInfo) {
//        // Call the corresponding method in the mapper layer to update data
//        classMapper.updateClass(classInfo);
//    }


}
