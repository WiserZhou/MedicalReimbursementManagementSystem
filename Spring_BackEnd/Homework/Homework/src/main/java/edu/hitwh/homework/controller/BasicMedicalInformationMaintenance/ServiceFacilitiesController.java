package edu.hitwh.homework.controller.BasicMedicalInformationMaintenance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/serviceFacilities")

public class ServiceFacilitiesController {
    @Autowired
    private ServiceFacilitiesService serviceFacilitiesService;

    // 服务设施项目列表查询，支持分页
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        log.info("查询全部的服务设施项目数据，页码: {}, 每页条数: {}", page, size);
        List<ServiceFacilities> serviceFacilities = serviceFacilitiesService.list(page, size);
        return Result.success(serviceFacilities);
    }

    // 删除服务设施项目
    @DeleteMapping("/{ser_id}")
    public Result delete(@PathVariable Integer ser_id) {
        log.info("根据ser_id删除服务设施项目: {}", ser_id);
        serviceFacilitiesService.delete(ser_id);
        return Result.success();
    }

    // 添加服务设施项目
    @PostMapping
    public Result add(@RequestBody ServiceFacilities serviceFacilities) {
        log.info("新增服务设施项目：{}", serviceFacilities);
        serviceFacilitiesService.add(serviceFacilities);
        return Result.success();
    }

    // 根据ID查询服务设施项目
    @GetMapping("/{ser_id}")
    public Result selectById(@PathVariable Integer ser_id) {
        log.info("根据ser_id查询服务设施项目: {}", ser_id);
        ServiceFacilities serviceFacilities = serviceFacilitiesService.selectById(ser_id);
        return Result.success(serviceFacilities);
    }

    // 修改服务设施项目
    @PutMapping
    public Result update(@RequestBody ServiceFacilities serviceFacilities) {
        log.info("更新服务设施项目: {}", serviceFacilities);
        serviceFacilitiesService.update(serviceFacilities);
        return Result.success();
    }
}
