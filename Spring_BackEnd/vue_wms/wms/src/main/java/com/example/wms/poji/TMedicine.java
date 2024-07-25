package com.example.wms.poji;

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
 * @since 2024-07-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TMedicine对象", description="")
public class TMedicine implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String medId;

    private String medName;

    private String medMeasurement;

    private String medSize;

    private String medStarttime;

    private String medEndtime;

    private String medValid;

    private String medExpType;

    private String medExpLevel;

    private Integer medMaxPrize;

    private String medSpecialmark;

    private String medTradename;

    private Integer medHosLevel;

    private Integer medApprovalmark;


}
