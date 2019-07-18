package  ddd.tenancy.tenancy.domain.core.service.impl;

import ddd.base.domain.DomainService;
import ddd.tenancy.tenancy.domain.core.service.HousePropertyAdminService;
import ddd.tenancy.tenancy.domain.core.vo.moment.HoursingAddRequestMomentVO;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 校验房源合法性
 * date Jun 4, 2019 12:44:25 PM
 */
@Service
public class CheckHouseLegalityDomainService implements DomainService {

  @Resource
  private HousePropertyAdminService housePropertyAdminService;

  // TODO: 2019/7/18  
  public void checkHouseLegality(HoursingAddRequestMomentVO hoursingAddRequestMomentVO) {
    housePropertyAdminService.housePropertyAdmin();
  }
}
