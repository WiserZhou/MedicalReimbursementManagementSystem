package com.example.wms.service;

import com.example.wms.poji.PageBean;
import com.example.wms.poji.TDiagnosisProject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wms
 * @since 2024-07-25
 */
public interface TDiagnosisProjectService extends IService<TDiagnosisProject> {

    PageBean Page(String diaId, String diaName, Integer page, Integer pageSize);
}
