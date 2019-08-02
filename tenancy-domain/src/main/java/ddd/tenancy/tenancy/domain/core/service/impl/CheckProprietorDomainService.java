package ddd.tenancy.tenancy.domain.core.service.impl;

import ddd.base.domain.DomainService;
import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.domain.common.account.entity.AccountEntity;
import ddd.tenancy.tenancy.domain.common.account.vo.AccountCheckReponseVO;
import ddd.tenancy.tenancy.domain.common.account.vo.AccountCheckRequestVO;
import ddd.tenancy.tenancy.domain.core.service.AccountService;
import ddd.tenancy.tenancy.domain.core.service.PublicSecurityService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 校验业主有效信息
 * 这里有两种方案：
 * 1. 公司有一定的规范，有用户系统，业主的信息被用户系统管理着的，这
 * 时候只需要调用用户系统的接口校验合法性即可。
 *
 * 2. 公司规模较小，还木有拆分出用户系统，所有的业务都在我们房源系统里面。
 * date Jun 4, 2019 12:44:25 PM
 */
@Service
public class CheckProprietorDomainService implements DomainService {

  @Resource
  private AccountService accountService;

  @Resource
  private PublicSecurityService publicSecurityService;

  /**
   * 方案 1
   */
  public void checkProprietor(String proprietorId) {
    if (!accountService.checkAccountLegal(Long.valueOf(proprietorId))) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
    }
  }

  public void checkAccountLegal(AccountCheckRequestVO request) {
    AccountEntity account = AccountEntity.get().getByAccountId(request.getAccountId());
    // 简单的校验
    account.check();
    // 调用公安系统进行校验
    AccountCheckReponseVO reponse = publicSecurityService.
        publicSecurity(account);

    if(!reponse.isCheckSuccess()){
      throw new RuntimeException(reponse.getFailReason());
    }
  }


}
