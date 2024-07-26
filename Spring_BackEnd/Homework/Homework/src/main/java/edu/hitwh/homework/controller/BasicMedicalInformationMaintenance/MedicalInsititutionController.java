package edu.hitwh.homework.controller.BasicMedicalInformationMaintenance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/medicalInsititution")

public class MedicalInsititutionController {
    @Autowired
    private MedicalInsititutionService medicalInsititutionService;

    // 定点医疗机构信息列表查询，支持分页
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        log.info("查询全部的定点医疗机构信息数据，页码: {}, 每页条数: {}", page, size);
        List<MedicalInsititution> medicalInsititution = medicalInsititutionService.list(page, size);
        return Result.success(medicalInsititution);
    }

    // 删除定点医疗机构信息
    @DeleteMapping("/{dia_id}")
    public Result delete(@PathVariable Integer dia_id) {
        log.info("根据dia_id删除定点医疗机构信息: {}", dia_id);
        medicalInsititutionService.delete(dia_id);
        return Result.success();
    }

    // 添加定点医疗机构信息
    @PostMapping
    public Result add(@RequestBody MedicalInsititution medicalInsititution) {
        log.info("新增定点医疗机构信息：{}", medicalInsititution);
        medicalInsititutionService.add(medicalInsititution);
        return Result.success();
    }

    // 根据ID查询定点医疗机构信息
    @GetMapping("/{dia_id}")
    public Result selectById(@PathVariable Integer dia_id) {
        log.info("根据dia_id查询定点医疗机构信息: {}", dia_id);
        MedicalInsititution medicalInsititution = medicalInsititutionService.selectById(dia_id);
        return Result.success(medicalInsititution);
    }

    // 修改定点医疗机构信息
    @PutMapping
    public Result update(@RequestBody MedicalInsititution medicalInsititution) {
        log.info("更新定点医疗机构信息: {}", medicalInsititution);
        medicalInsititutionService.update(medicalInsititution);
        return Result.success();
    }
}
