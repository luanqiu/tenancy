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

  public void checkProprietor() {
    publicSecurityService.publicSecurity();
  }
}
