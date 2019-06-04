package ddd.tenancy.tenancy.domain.core.factory;

import ddd.base.domain.DomainFactory;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.core.aggr.TenantAgreementBillAggr;
import org.springframework.stereotype.Component;

import ddd.tenancy.tenancy.domain.core.entity.TenantAgreementEntity;
import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;

/**
 * TenantAgreementBillAggrFactory
 * date 2019/4/6
 */
@Component
public class TenantAgreementBillAggrFactory implements DomainFactory<VO, TenantAgreementBillAggr> {

  @Override
  public TenantAgreementBillAggr perfect(VO vo) {
    TenantAgreementBillAggr tenantAgreementBillAggr = TenantAgreementBillAggr.get();

    TenantAgreementEntity tenantAgreementEntity = TenantAgreementEntity.get();
    tenantAgreementBillAggr.setTenantAgreementEntity(tenantAgreementEntity);
    BillEntity billEntity = BillEntity.get();
    tenantAgreementBillAggr.setBillEntity(billEntity);
    return tenantAgreementBillAggr;
  }
}
