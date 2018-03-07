package com.jk.modules.loans.service.impl;

import com.jk.common.base.service.impl.BaseServiceImpl;
import com.jk.modules.loans.model.Loan;
import com.jk.modules.loans.service.LoanService;
import com.jk.modules.log.model.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhg on 2018/3/6.
 */
@Transactional
@Service
public class LoanServiceImpl extends BaseServiceImpl<Loan> implements LoanService{

    @Override
    public Loan findByName(String name) {
        Loan loan= new Loan();
        loan.setLoanName(name);
        return this.findOne(loan);
    }
}
