package com.jk.service;

import com.github.pagehelper.PageInfo;
import com.jk.model.PayStream;

/**
 * Created by JK on 2017/1/19.
 */
public interface PayStreamService extends BaseService<PayStream>{
    /**
     *
     * @param pageNum  当前页码
     * @param pageSize  每页显示条数
     * @param username 用户名
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     * @throws Exception
     */
    public PageInfo<PayStream> findPage(Integer pageNum ,Integer pageSize ,String findproject, String finduser, 
            String findtimestart, String findtimeend,String ordertype,String ordervalue) throws Exception;

}