package com.jk.modules.loans.model;

import com.jk.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by zhg on 2018/3/6.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Loan  extends BaseEntity {

    /**
     * 借款人
     */
    private String loanName;

    /**
     * 借款金额
     */
    private Double loanPrice;

    /**
     * 利息
     */
    private Double accrual;

    /**
     * 备注
     */
    private String remark;

    private String createBy;

    private String modifyBy;
}
