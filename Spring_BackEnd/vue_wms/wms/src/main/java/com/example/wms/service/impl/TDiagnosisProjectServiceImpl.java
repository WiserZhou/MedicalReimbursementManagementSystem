package com.example.wms.service.impl;

import com.example.wms.poji.PageBean;
import com.example.wms.poji.TDiagnosisProject;
import com.example.wms.mapper.TDiagnosisProjectMapper;
import com.example.wms.poji.TMedicine;
import com.example.wms.service.TDiagnosisProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wms
 * @since 2024-07-25
 */
@Service
public class TDiagnosisProjectServiceImpl extends ServiceImpl<TDiagnosisProjectMapper, TDiagnosisProject> implements TDiagnosisProjectService {

    @Autowired TDiagnosisProjectMapper tDiagnosisProjectMapper;
    @Override
    public PageBean Page(String diaId, String diaName, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Page<TDiagnosisProject> p  = (Page<TDiagnosisProject>)tDiagnosisProjectMapper.list(diaId,diaName);

        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
}
