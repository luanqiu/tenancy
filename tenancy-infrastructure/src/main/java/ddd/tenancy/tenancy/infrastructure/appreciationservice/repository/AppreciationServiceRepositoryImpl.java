package ddd.tenancy.tenancy.infrastructure.appreciationservice.repository;

import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.support.appreciationservice.entity.AppreciationServiceEntity;
import ddd.tenancy.tenancy.domain.support.appreciationservice.repository.AppreciationServiceRepository;
import org.springframework.stereotype.Repository;

/**
* AppreciationServiceRepositoryImpl
*date Jun 4, 2019 12:44:25 PM
*/
@Repository
public class AppreciationServiceRepositoryImpl implements AppreciationServiceRepository {

  @Override
  public Boolean createAppreciationService(VO vo) {
    return null;
  }

  @Override
  public void insert(AppreciationServiceEntity appreciationServiceEntity) {

  }

  @Override
  public AppreciationServiceEntity getByAppreciationServiceId(String appreciationServiceId) {
    return null;
  }

}
