package edu.hitwh.homework.controller.PublicService;


import edu.hitwh.homework.pojo.PageBean;
import edu.hitwh.homework.pojo.PublicService.ApplicationInfo;
import edu.hitwh.homework.pojo.PublicService.Special;
import edu.hitwh.homework.pojo.Result;
import edu.hitwh.homework.service.PublicService.ApplicationInfoService;
import edu.hitwh.homework.service.PublicService.SpecialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/special")
public class SpecialController {
    @Autowired
    private SpecialService specialService;

    // 获取所有班级列表
    @GetMapping("/list")
    public Result getAll() {
        log.info("获取班级列表");
        List<Special> classList = specialService.getAll();
        return Result.success(classList);
    }

    // 根据班级ID获取班级信息
    @GetMapping("/{approvalNumber}")
    public Result getById(@PathVariable String approvalNumber) throws SQLIntegrityConstraintViolationException {
        log.info("获取对应班级ID的班级信息");
        Special classes = specialService.getById(approvalNumber);
        return Result.success(classes);
    }

    // 新增班级
    @PostMapping
    public Result save(@RequestBody Special classes) {
        log.info("新增班级：class:{}", classes);
        try {
            specialService.save(classes);
            return Result.success();
        } catch (RuntimeException e) {
            return Result.error("该班级名称已存在!");
        }
    }

    // 分页查询班级列表
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @RequestParam String personID) {
        PageBean pageBean = specialService.page(page, pageSize, personID);
        return Result.success(pageBean);
    }

    // 修改班级信息
    @PutMapping
    public Result update(@RequestBody Special classes) {
        log.info("修改班级，class:{}", classes);
        try {
            specialService.update(classes);
            return Result.success();
        } catch (RuntimeException e) {
            return Result.error("该班级名称已存在!");
        }
    }

    // 删除班级
    @DeleteMapping("/{approvalNumber}")
    public Result delete(@PathVariable String approvalNumber) {
        try {
            specialService.delete(approvalNumber);
            return Result.success();
        } catch (RuntimeException e) {
            return Result.error("该班级内仍然有学员，无法成功删除，请在调整完学员所属班级后再次删除！");
        }
    }
}


