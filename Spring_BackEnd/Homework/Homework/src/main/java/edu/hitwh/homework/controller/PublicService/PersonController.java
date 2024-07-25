package edu.hitwh.homework.controller.PublicService;

import edu.hitwh.homework.pojo.PageBean;
import edu.hitwh.homework.pojo.PublicService.Person;
import edu.hitwh.homework.pojo.Result;
import edu.hitwh.homework.service.PublicService.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    // 人员列表查询，支持分页
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String personName,
                       String personRole) {

        log.info("分页查询，参数:{},{},{},{}", page, pageSize, personName, personRole);
        PageBean pageBean = (PageBean) personService.page(page, pageSize, personName, personRole);
        return Result.success(pageBean);
    }

    // 删除人员
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除人员: {}", id);
        personService.delete(id);
        return Result.success();
    }

    // 添加人员
    @PostMapping
    public Result add(@RequestBody Person person) {
        log.info("新增人员：{}", person);
        personService.add(person);
        return Result.success();
    }

    // 根据ID查询人员
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        log.info("根据id查询人员: {}", id);
        Person person = personService.selectById(id);
        return Result.success(person);
    }

    // 修改人员
    @PutMapping
    public Result update(@RequestBody Person person) {
        log.info("更新人员: {}", person);
        personService.update(person);
        return Result.success();
    }
}
