package com.jk.modules.repayment.model;

import com.jk.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = true)
public class Repayment  extends BaseEntity {
    private Long loanId;

    private Date repayTime;

    private Double accrualInterestPayable;

    private Double actualPaymentAmount;

    private Double arrearage;

    private String remark;

    private String createBy;

    private String modifyBy;

}