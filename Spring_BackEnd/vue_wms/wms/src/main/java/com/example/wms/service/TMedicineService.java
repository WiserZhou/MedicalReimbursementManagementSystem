package com.example.wms.service;

import com.example.wms.poji.PageBean;
import com.example.wms.poji.TMedicine;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wms
 * @since 2024-07-24
 */
public interface TMedicineService extends IService<TMedicine> {


    PageBean Page(String medId,String medName,Integer page, Integer pageSize);
}
