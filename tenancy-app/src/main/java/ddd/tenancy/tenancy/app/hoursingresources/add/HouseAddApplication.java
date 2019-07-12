package ddd.tenancy.tenancy.app.hoursingresources.add;

import ddd.base.domain.Application;
import ddd.tenancy.tenancy.api.common.dto.BaseRequestDTO;
import ddd.tenancy.tenancy.api.common.dto.BaseResponseDTO;
import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import ddd.tenancy.tenancy.domain.core.service.impl.CheckHousingParamsDomainService;
import ddd.tenancy.tenancy.domain.core.service.impl.CheckProprietorDomainService;
import ddd.tenancy.tenancy.domain.core.service.impl.CheckHouseLegalityDomainService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
* HouseAddApplication
*date Jun 4, 2019 12:44:25 PM
*/
@Component
public class HouseAddApplication implements Application<BaseRequestDTO,BaseResponseDTO> {

  @Resource
  private CheckHousingParamsDomainService checkHousingParamsDomainService;

  @Resource
  private CheckProprietorDomainService checkProprietorDomainService;

  @Resource
  private CheckHouseLegalityDomainService checkHouseLegalityDomainService;

  @Override
  public BaseResponseDTO doAction(BaseRequestDTO request) {
    HousingResourcesEntity housingResourcesEntity = HousingResourcesEntity.get();

    checkHousingParamsDomainService.checkHousingParams();

    checkProprietorDomainService.checkProprietor();

    checkHouseLegalityDomainService.checkHouseLegality();

    housingResourcesEntity.checkHousingLegality(null);

    housingResourcesEntity.createHousingResources(null);

    return new BaseResponseDTO();
  }
}
