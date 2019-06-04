package ddd.tenancy.tenancy.domain.core.factory;

import ddd.base.domain.DomainFactory;
import ddd.tenancy.tenancy.domain.core.entity.TenantAgreementEntity;
import ddd.tenancy.tenancy.domain.core.vo.TenantAgreementBuildVO;
import org.springframework.stereotype.Component;

/**
 * TenantAgreementFactory
 * perfect 简单的构造示范
 * date 2019/4/6
 */
@Component
public class TenantAgreementEntityFactory implements DomainFactory<TenantAgreementBuildVO, TenantAgreementEntity> {

  @Override
  public TenantAgreementEntity perfect(TenantAgreementBuildVO vo) {
    TenantAgreementEntity entity = TenantAgreementEntity.get();
    entity.setAgreementId("");
    return entity;
  }
}
