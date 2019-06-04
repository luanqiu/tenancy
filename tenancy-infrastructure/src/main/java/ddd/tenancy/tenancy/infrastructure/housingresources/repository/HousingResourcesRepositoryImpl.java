package ddd.tenancy.tenancy.infrastructure.housingresources.repository;

import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import ddd.tenancy.tenancy.domain.core.repository.HousingResourcesRepository;
import org.springframework.stereotype.Repository;

/**
* HousingResourcesRepositoryImpl
*date Jun 4, 2019 12:44:25 PM
*/
@Repository
public class HousingResourcesRepositoryImpl implements HousingResourcesRepository {

  @Override
  public Boolean createHousingResources(VO vo) {
    return null;
  }

  @Override
  public void insert(HousingResourcesEntity housingResourcesEntity) {

  }

  @Override
  public HousingResourcesEntity getByHousingId(String housingId) {
    return null;
  }

}
