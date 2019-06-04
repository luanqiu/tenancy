package ddd.tenancy.tenancy.domain.core.factory;

import ddd.base.domain.DomainFactory;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.core.aggr.ProprietorManagementAgreementBillAggr;
import org.springframework.stereotype.Component;

import ddd.tenancy.tenancy.domain.core.entity.ProprietorManagementAgreementEntity;
import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;

/**
 * ProprietorManagementAgreementBillAggrFactory
 * date 2019/4/6
 */
@Component
public class ProprietorManagementAgreementBillAggrFactory implements DomainFactory<VO, ProprietorManagementAgreementBillAggr> {

  @Override
  public ProprietorManagementAgreementBillAggr perfect(VO vo) {
    ProprietorManagementAgreementBillAggr proprietorManagementAgreementBillAggr = ProprietorManagementAgreementBillAggr.get();

    ProprietorManagementAgreementEntity proprietorManagementAgreementEntity = ProprietorManagementAgreementEntity.get();
    proprietorManagementAgreementBillAggr.setProprietorManagementAgreementEntity(proprietorManagementAgreementEntity);
    BillEntity billEntity = BillEntity.get();
    proprietorManagementAgreementBillAggr.setBillEntity(billEntity);
    return proprietorManagementAgreementBillAggr;
  }
}
