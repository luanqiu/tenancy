package ddd.tenancy.tenancy.spi.decouplingcontext.publicsecurity;

import ddd.tenancy.tenancy.domain.common.account.entity.AccountEntity;
import ddd.tenancy.tenancy.domain.common.account.vo.AccountCheckReponseVO;
import ddd.tenancy.tenancy.domain.core.service.PublicSecurityService;
import org.springframework.stereotype.Service;

/**
 * 公安系统
 * date Jun 4, 2019 12:44:25 PM
 */
@Service
public class PublicSecurityServiceImpl implements PublicSecurityService {


  @Override
  public AccountCheckReponseVO publicSecurity(AccountEntity accountEntity) {
    return null;
  }
}
