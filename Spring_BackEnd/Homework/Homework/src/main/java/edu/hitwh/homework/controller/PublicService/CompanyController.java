package edu.hitwh.homework.controller.PublicService;


import edu.hitwh.homework.pojo.PublicService.Company;
import edu.hitwh.homework.pojo.Result;

import edu.hitwh.homework.service.PublicService.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // 单位列表查询，支持分页
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        log.info("查询全部的单位数据，页码: {}, 每页条数: {}", page, size);
        List<Company> companies = companyService.list(page, size);
        return Result.success(companies);
    }

    // 删除单位
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除单位: {}", id);
        companyService.delete(id);
        return Result.success();
    }

    // 添加单位
    @PostMapping
    public Result add(@RequestBody Company company) {
        log.info("新增单位：{}", company);
        companyService.add(company);
        return Result.success();
    }

    // 根据ID查询单位
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        log.info("根据id查询单位: {}", id);
        Company company = companyService.selectById(id);
        return Result.success(company);
    }

    // 修改单位
    @PutMapping
    public Result update(@RequestBody Company company) {
        log.info("更新单位: {}", company);
        companyService.update(company);
        return Result.success();
    }
}
