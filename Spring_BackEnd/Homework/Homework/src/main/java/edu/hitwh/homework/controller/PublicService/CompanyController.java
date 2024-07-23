package edu.hitwh.homework.controller.PublicService;



import edu.hitwh.homework.service.PublicService.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

//    @GetMapping
//    public Result getAllClasses() {
//        List<Class> classes = classService.getAllClasses();
//        return Result.success(classes);
//    }
//
//    @GetMapping("/{id}")
//    public Result selectById(@PathVariable Integer id){
//        log.info("根据id查询班级:{} ", id);
//        Class aClass = classService.selectById(id);
//        return Result.success(aClass);
//    }
//
//
//    @PostMapping("/search")
//    public Result searchClassByName(@RequestBody Map<String, String> request) {
//        String className = request.get("class_name");
//        List<Class> classes = classService.searchClassByName(className);
//        return Result.success(classes);
//    }
//
//    @PostMapping("/filter")
//    public Result filterClassByDate(@RequestBody Map<String, String> request) {
//        String startDate = request.get("start_date");
//        String endDate = request.get("end_date");
//        List<Class> classes = classService.filterClassByDate(startDate, endDate);
//        return Result.success(classes);
//    }
//
//    @PostMapping("/add")
//    public Result addClass(@RequestBody Class classInfo) {
//        classService.addClass(classInfo);
//        return Result.success(null);
//    }
//
//    @DeleteMapping("/delete/{classId}")
//    public Result deleteClass(@PathVariable("classId") Integer classId) {
//        classService.deleteClass(classId);
//        return Result.success(null);
//    }
//
//    @PutMapping("/update")
//    public Result updateClass(@RequestBody Class classInfo) {
//        classService.updateClass(classInfo);
//        return Result.success(null);
//    }
}


