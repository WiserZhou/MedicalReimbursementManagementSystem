package com.example.wms.poji;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wms
 * @since 2024-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TDiagnosisProject对象", description="")
public class TDiagnosisProject implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String diaId;

    private String diaName;

    private String diaExpType;

    private String diaExpLevel;

    private String diaStarttime;

    private String diaEndtime;

    private String diaValid;

    private Integer diaMaxPrize;

    private Integer diaHosLevel;

    private Integer diaApprovalmark;


}
