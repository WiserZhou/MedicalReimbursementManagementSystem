package edu.hitwh.homework.controller.BasicMedicalInformationMaintenance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/disease")
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;

    // 疾病信息列表查询，支持分页
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        log.info("查询全部的疾病信息数据，页码: {}, 每页条数: {}", page, size);
        List<Disease> disease = diseaseService.list(page, size);
        return Result.success(disease);
    }

    // 删除疾病信息
    @DeleteMapping("/{disease_id}")
    public Result delete(@PathVariable Integer disease_id) {
        log.info("根据disease_id删除疾病信息: {}", disease_id);
        diseaseService.delete(disease_id);
        return Result.success();
    }

    // 添加疾病信息
    @PostMapping
    public Result add(@RequestBody Disease disease) {
        log.info("新增疾病信息：{}", disease);
        diseaseService.add(disease);
        return Result.success();
    }

    // 根据ID查询疾病信息
    @GetMapping("/{disease_id}")
    public Result selectById(@PathVariable Integer disease_id) {
        log.info("根据disease_id查询疾病信息: {}", disease_id);
        Disease disease = diseaseService.selectById(disease_id);
        return Result.success(disease);
    }

    // 修改疾病信息
    @PutMapping
    public Result update(@RequestBody Disease disease) {
        log.info("更新疾病信息: {}", disease);
        diseaseService.update(disease);
        return Result.success();
    }
}
