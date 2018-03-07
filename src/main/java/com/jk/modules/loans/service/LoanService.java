package com.jk.modules.loans.service;

import com.jk.common.base.service.BaseService;
import com.jk.modules.loans.model.Loan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhg on 2018/3/6.
 */
public interface LoanService extends BaseService<Loan> {

    Loan findByName(String name);
}
