package ddd.tenancy.tenancy.domain.core.factory;

import ddd.base.domain.DomainFactory;
import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import ddd.tenancy.tenancy.domain.core.vo.HousingResourcesBuildVO;
import org.springframework.stereotype.Component;

/**
 * HousingResourcesFactory
 * perfect 简单的构造示范
 * date 2019/4/6
 */
@Component
public class HousingResourcesEntityFactory implements DomainFactory<HousingResourcesBuildVO, HousingResourcesEntity> {

  @Override
  public HousingResourcesEntity perfect(HousingResourcesBuildVO vo) {
    HousingResourcesEntity entity = HousingResourcesEntity.get();
    entity.setHousingId("");
    entity.setAddress(vo.getAddress());
    entity.setProprietorId(vo.getProprietorId());
    entity.setPropertyInformation(vo.getProprietorId());
    return entity;
  }
}
