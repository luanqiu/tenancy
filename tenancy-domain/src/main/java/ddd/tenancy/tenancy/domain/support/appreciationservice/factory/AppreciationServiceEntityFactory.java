package ddd.tenancy.tenancy.domain.support.appreciationservice.factory;

import ddd.base.domain.DomainFactory;
import ddd.tenancy.tenancy.domain.support.appreciationservice.entity.AppreciationServiceEntity;
import ddd.tenancy.tenancy.domain.support.appreciationservice.vo.AppreciationServiceBuildVO;
import org.springframework.stereotype.Component;

/**
 * AppreciationServiceFactory
 * perfect 简单的构造示范
 * date 2019/4/6
 */
@Component
public class AppreciationServiceEntityFactory implements DomainFactory<AppreciationServiceBuildVO, AppreciationServiceEntity> {

  @Override
  public AppreciationServiceEntity perfect(AppreciationServiceBuildVO vo) {
    AppreciationServiceEntity entity = AppreciationServiceEntity.get();
    entity.setAppreciationServiceId("");
    return entity;
  }
}
