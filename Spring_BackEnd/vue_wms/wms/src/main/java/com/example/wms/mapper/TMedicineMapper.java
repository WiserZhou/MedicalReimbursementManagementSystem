package com.example.wms.mapper;

import com.example.wms.poji.TMedicine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wms
 * @since 2024-07-24
 */
public interface TMedicineMapper extends BaseMapper<TMedicine> {
    @Select("select * from t_medicine")
    public List<TMedicine> list(String medId,String medName);



}
