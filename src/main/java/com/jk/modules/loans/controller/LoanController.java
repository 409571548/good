package com.jk.modules.loans.controller;

import com.github.pagehelper.PageInfo;
import com.jk.common.annotation.OperationLog;
import com.jk.common.base.controller.BaseController;
import com.jk.common.security.token.FormToken;
import com.jk.common.validator.group.Create;
import com.jk.common.validator.group.Update;
import com.jk.modules.loans.model.Loan;
import com.jk.modules.loans.service.LoanService;
import com.jk.modules.repayment.model.Repayment;
import com.jk.modules.repayment.service.RepaymentService;
import com.jk.modules.sys.model.Role;
import com.jk.modules.sys.model.UserRole;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhg on 2018/3/6.
 */
@Controller
@RequestMapping("/admin/loan")
public class LoanController extends BaseController{
    protected final transient Log log = LogFactory.get(this.getClass());

    protected static final String FAILURE = "failure";
    protected static final String SUCCESS = "success";
    private static final String BASE_PATH = "admin/loan/";

    @Autowired
    private LoanService loanService;

    @Autowired
    private RepaymentService repaymentService;

    @RequiresPermissions("loan:list")
    @GetMapping
    public String list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                       ModelMap modelMap){
        //loanService.findAll();
        log.debug("分页查询贷款记录! pageNum = {}", pageNum);
        PageInfo<Loan> pageInfo = loanService.findPageListByWhere(pageNum, PAGESIZE, null);
        log.info("分页查询贷款记录！ pageInfo = {}", pageInfo);
        modelMap.put("pageInfo", pageInfo);
        return BASE_PATH + "admin-loan";
    }

    /**
     * 跳转到角色添加页面
     * @return
     */
    @FormToken(save = true)
    @RequiresPermissions("loan:create")
    @GetMapping(value = "/add")
    public String add(ModelMap modelMap){
        return BASE_PATH + "admin-loan-add";
    }


    /**
     * 检验借款名是否存在
     * @param id
     * @param name
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/isExist")
    public Boolean isExist(Long id, String name){
        boolean flag = true;
        log.debug("检验借款人名称是否存在参数! id= {}, name= {}", id, name);
        Loan record = loanService.findByName(name);
        if (null != record && !record.getId().equals(id)) {
            flag = false;
        }
        log.info("检验借款人名称是否存在结果! flag = {}", flag);
        return flag;
    }


    @FormToken(remove = true)
    @OperationLog(value = "添加借款")
    @RequiresPermissions("loan:create")
    @ResponseBody
    @PostMapping
    public ModelMap saveRole(@Validated({Create.class}) Loan loan){
        ModelMap messagesMap = new ModelMap();
        log.debug("添加借款! loan = {}", loan);
        //执行保存
        loanService.save(loan);
        log.info("添加借款成功! roleId = {}", loan.getId());
        messagesMap.put("status",SUCCESS);
        messagesMap.put("message","添加成功!");
        return messagesMap;
    }


    /**
     * 查询日志详情
     * @param id
     * @return
     */
    @RequiresPermissions("loan:view")
    @GetMapping("/{id}")
    public String view(@PathVariable("id")Long id, ModelMap modelMap){
        Loan loan = loanService.findById(id);
        Repayment repayment = new Repayment();
        repayment.setLoanId(id);

        List<Repayment> pageInfo = repaymentService.findListByWhere(repayment);
        /*log.debug("分页查询贷款记录! pageNum = {}", pageNum);
        PageInfo<Repayment> pageInfo = repaymentService.findPageListByWhere(pageNum, PAGESIZE, repayment);
        log.info("分页查询贷款记录！ pageInfo = {}", pageInfo);*/
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("model", loan);
        return BASE_PATH + "loan-view";
    }


    /**
     * 更新借款信息
     * @param id
     * @param role
     * @return
     */
    @FormToken(remove = true)
    @OperationLog(value = "编辑借款")
    @RequiresPermissions("loan:update")
    @ResponseBody
    @PutMapping(value = "/{loanId}")
    public ModelMap updateRole(@PathVariable("loanId") Long loanId, @Validated({Update.class}) Loan loan){
        ModelMap messagesMap = new ModelMap();
        log.debug("编辑借款参数! loanId= {}, loan = {}", loanId, loan);
        loan.setId(loanId);
        loanService.updateSelective(loan);
        log.info("编辑借款成功! loanId= {}, loan = {}", loanId, loan);
        messagesMap.put("status",SUCCESS);
        messagesMap.put("message","编辑成功!");
        return messagesMap;
    }


    /**
     * 根据主键ID删除借款
     * @param id
     * @return
     */
    @OperationLog(value = "删除借款")
    @RequiresPermissions("loan:delete")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        if (null == id) {
            log.info("删除借款不存在! id = {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("删除借款不存在!");
        }
        Integer flag =  loanService.deleteById(id);
        if(flag > 0){
            log.info("删除借款成功! id = {}", id);
            return ResponseEntity.ok("删除成功!");
        }
        log.info("删除借款失败，但没有抛出异常! id = {}", id);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 跳转到借款编辑页面
     * @return
     */
    @FormToken(save = true)
    @RequiresPermissions("loan:update")
    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap modelMap) throws Exception {
        log.debug("跳转到编辑借款信息页面参数! id = {}", id);
        Loan loan = loanService.findById(id);

        log.info("跳转到编辑借款信息页面成功!, id = {}", id);
        modelMap.put("model", loan);
        return BASE_PATH + "admin-loan-edit";
    }
}
