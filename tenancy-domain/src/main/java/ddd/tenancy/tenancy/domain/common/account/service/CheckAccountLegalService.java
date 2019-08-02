package ddd.tenancy.tenancy.domain.common.account.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import ddd.base.domain.DomainService;
import ddd.tenancy.tenancy.domain.common.account.entity.AccountEntity;
import ddd.tenancy.tenancy.domain.common.account.vo.AccountCheckReponseVO;
import ddd.tenancy.tenancy.domain.common.account.vo.AccountCheckRequestVO;
import ddd.tenancy.tenancy.domain.core.service.PublicSecurityService;

/**
 * CheckAccountLegalService
 * author  wenhe
 * date 2019/7/31
 */
@Service
public class CheckAccountLegalService implements DomainService {

  @Resource
  private PublicSecurityService publicSecurityService;

  /**
   * 校验账户合法性
   * 1. 从账户信息查出所有信息
   * 2. 丢给下游公安系统去校验身份证、照片等信息是否过期等等，过期了需要重新上传身份证信息
   * 不过期则通过。
   * @param request
   */
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
