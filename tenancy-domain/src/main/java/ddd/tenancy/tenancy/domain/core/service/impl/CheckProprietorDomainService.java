package  ddd.tenancy.tenancy.domain.core.service.impl;

import ddd.base.domain.DomainService;
import ddd.tenancy.tenancy.domain.core.service.PublicSecurityService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 校验业主有效信息
 * date Jun 4, 2019 12:44:25 PM
 */
@Service
public class CheckProprietorDomainService implements DomainService {

  @Resource
  private PublicSecurityService publicSecurityService;

  /**
   * 校验业主有效信息
   * @param proprietorId
   * @param proprietorName
   */
  public void checkProprietor(String proprietorId,String proprietorName) {
    // TODO: 2019/7/18 未完成
    publicSecurityService.publicSecurity();
  }
}
