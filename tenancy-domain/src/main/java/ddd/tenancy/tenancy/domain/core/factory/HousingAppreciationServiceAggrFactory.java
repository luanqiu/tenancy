package ddd.tenancy.tenancy.domain.core.factory;

import ddd.base.domain.DomainFactory;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.core.aggr.HousingAppreciationServiceAggr;
import org.springframework.stereotype.Component;

import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import ddd.tenancy.tenancy.domain.support.appreciationservice.entity.AppreciationServiceEntity;

/**
 * HousingAppreciationServiceAggrFactory
 * date 2019/4/6
 */
@Component
public class HousingAppreciationServiceAggrFactory implements DomainFactory<VO, HousingAppreciationServiceAggr> {

  @Override
  public HousingAppreciationServiceAggr perfect(VO vo) {
    HousingAppreciationServiceAggr housingAppreciationServiceAggr = HousingAppreciationServiceAggr.get();

    HousingResourcesEntity housingResourcesEntity = HousingResourcesEntity.get();
    housingAppreciationServiceAggr.setHousingResourcesEntity(housingResourcesEntity);
    AppreciationServiceEntity appreciationServiceEntity = AppreciationServiceEntity.get();
    housingAppreciationServiceAggr.setAppreciationServiceEntity(appreciationServiceEntity);
    return housingAppreciationServiceAggr;
  }
}
