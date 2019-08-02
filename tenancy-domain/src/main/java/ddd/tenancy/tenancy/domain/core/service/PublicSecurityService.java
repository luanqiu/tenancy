package  ddd.tenancy.tenancy.domain.core.service;

import ddd.tenancy.tenancy.domain.common.account.entity.AccountEntity;
import ddd.tenancy.tenancy.domain.common.account.vo.AccountCheckReponseVO;

/**
 * PublicSecurityService
 * date Jun 4, 2019 12:44:25 PM
 */
public interface PublicSecurityService {

  /**
   * 公安系统
   */
  AccountCheckReponseVO publicSecurity(AccountEntity accountEntity);

}
