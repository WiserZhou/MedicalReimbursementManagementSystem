package com.example.wms.mapper;

import com.example.wms.poji.TDiagnosisProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.wms.poji.TMedicine;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wms
 * @since 2024-07-25
 */
public interface TDiagnosisProjectMapper extends BaseMapper<TDiagnosisProject> {
    @Select("select * from t_diagnosis_project")
    public List<TDiagnosisProject> list(String diaId, String diaName);
}
