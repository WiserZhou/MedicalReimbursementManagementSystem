package com.example.wms.service.impl;

import com.example.wms.poji.PageBean;
import com.example.wms.poji.TMedicine;
import com.example.wms.mapper.TMedicineMapper;
import com.example.wms.service.TMedicineService;
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
 * @since 2024-07-24
 */
@Service
public class TMedicineServiceImpl extends ServiceImpl<TMedicineMapper, TMedicine> implements TMedicineService {

    @Autowired  TMedicineMapper tMedicineMapper;

    @Override
    public PageBean Page(String diaId,String diaName,Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Page<TMedicine> p  = (Page<TMedicine>)tMedicineMapper.list(diaId,diaName);

        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
}
