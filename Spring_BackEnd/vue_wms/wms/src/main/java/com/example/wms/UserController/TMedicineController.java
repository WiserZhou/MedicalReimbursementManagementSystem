package com.example.wms.UserController;


import com.example.wms.poji.PageBean;
import com.example.wms.poji.Result;
import com.example.wms.poji.TMedicine;
import com.example.wms.service.TMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wms
 * @since 2024-07-24
 */
@RestController
@RequestMapping("/t-medicine")
public class TMedicineController {
    @Autowired TMedicineService tMedicineService;

    @GetMapping
    public Result getAllMedicine(@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 String medId,
                                 String medName) {

        PageBean pageBean = tMedicineService.Page(medId,medName,page, pageSize);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result deleteMedicine(@PathVariable("ids") List<Integer> ids) {

        tMedicineService.removeByIds(ids);
        return Result.success();
    }

    @PostMapping()
    public Result addMedicine(@RequestBody TMedicine tMedicine) {
        tMedicineService.save(tMedicine);
        return Result.success();

    }

    @GetMapping("/{id}")
    public Result list(@PathVariable Integer id) {

        return Result.success(tMedicineService.getById(id));
    }
    
    @PutMapping
    public Result updateMedicine(@RequestBody TMedicine tMedicine) {
        tMedicineService.updateById(tMedicine);
        return Result.success();
    }

}
