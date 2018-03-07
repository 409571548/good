package com.jk.modules.repayment.service.impl;

import com.jk.common.base.service.impl.BaseServiceImpl;
import com.jk.modules.loans.model.Loan;
import com.jk.modules.repayment.model.Repayment;
import com.jk.modules.repayment.service.RepaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhg on 2018/3/6.
 */
@Transactional
@Service
public class RepaymentServiceImpl extends BaseServiceImpl<Repayment> implements RepaymentService {

}
