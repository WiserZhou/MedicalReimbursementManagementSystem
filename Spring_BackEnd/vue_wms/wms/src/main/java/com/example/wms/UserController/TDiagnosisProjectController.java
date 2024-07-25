package com.example.wms.UserController;


import com.example.wms.poji.PageBean;
import com.example.wms.poji.Result;
import com.example.wms.poji.TDiagnosisProject;
import com.example.wms.poji.TMedicine;
import com.example.wms.service.TDiagnosisProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wms
 * @since 2024-07-25
 */
@RestController
@RequestMapping("/t-diagnosis-project")
public class TDiagnosisProjectController {
    @Autowired TDiagnosisProjectService tDiagnosisProjectService;

    @GetMapping
    public Result getAllMedicine(@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 String diaId,
                                 String diaName) {

        PageBean pageBean = tDiagnosisProjectService.Page(diaId,diaName,page, pageSize);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result deleteMedicine(@PathVariable("ids") List<Integer> ids) {

        tDiagnosisProjectService.removeByIds(ids);
        return Result.success();
    }

    @PostMapping()
    public Result addMedicine(@RequestBody TDiagnosisProject tDiagnosisProject) {
        tDiagnosisProjectService.save(tDiagnosisProject);
        return Result.success();

    }

    @GetMapping("/{id}")
    public Result list(@PathVariable Integer id) {

        return Result.success(tDiagnosisProjectService.getById(id));
    }

    @PutMapping
    public Result updateMedicine(@RequestBody TDiagnosisProject tDiagnosisProject) {
        tDiagnosisProjectService.updateById(tDiagnosisProject);
        return Result.success();
    }
}
