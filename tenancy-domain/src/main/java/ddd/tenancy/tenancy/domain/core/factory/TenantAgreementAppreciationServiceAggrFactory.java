package ddd.tenancy.tenancy.domain.core.factory;

import ddd.base.domain.DomainFactory;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.core.aggr.TenantAgreementAppreciationServiceAggr;
import org.springframework.stereotype.Component;

import ddd.tenancy.tenancy.domain.core.entity.TenantAgreementEntity;
import ddd.tenancy.tenancy.domain.support.appreciationservice.entity.AppreciationServiceEntity;

/**
 * TenantAgreementAppreciationServiceAggrFactory
 * date 2019/4/6
 */
@Component
public class TenantAgreementAppreciationServiceAggrFactory implements DomainFactory<VO, TenantAgreementAppreciationServiceAggr> {

  @Override
  public TenantAgreementAppreciationServiceAggr perfect(VO vo) {
    TenantAgreementAppreciationServiceAggr tenantAgreementAppreciationServiceAggr = TenantAgreementAppreciationServiceAggr.get();

    TenantAgreementEntity tenantAgreementEntity = TenantAgreementEntity.get();
    tenantAgreementAppreciationServiceAggr.setTenantAgreementEntity(tenantAgreementEntity);
    AppreciationServiceEntity appreciationServiceEntity = AppreciationServiceEntity.get();
    tenantAgreementAppreciationServiceAggr.setAppreciationServiceEntity(appreciationServiceEntity);
    return tenantAgreementAppreciationServiceAggr;
  }
}
