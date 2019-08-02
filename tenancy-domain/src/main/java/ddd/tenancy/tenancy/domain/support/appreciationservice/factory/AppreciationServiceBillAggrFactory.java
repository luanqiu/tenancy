package ddd.tenancy.tenancy.domain.support.appreciationservice.factory;

import ddd.base.domain.DomainFactory;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.support.appreciationservice.aggr.AppreciationServiceBillAggr;
import org.springframework.stereotype.Component;

import ddd.tenancy.tenancy.domain.support.appreciationservice.entity.AppreciationServiceEntity;
import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;

/**
 * AppreciationServiceBillAggrFactory
 * date 2019/4/6
 */
@Component
public class AppreciationServiceBillAggrFactory implements DomainFactory<VO, AppreciationServiceBillAggr> {

  @Override
  public AppreciationServiceBillAggr perfect(VO vo) {
    AppreciationServiceBillAggr appreciationServiceBillAggr = AppreciationServiceBillAggr.get();

    AppreciationServiceEntity appreciationServiceEntity = AppreciationServiceEntity.get();
    appreciationServiceBillAggr.setAppreciationServiceEntity(appreciationServiceEntity);
    BillEntity billEntity = BillEntity.get();
    appreciationServiceBillAggr.setBillEntity(billEntity);
    return appreciationServiceBillAggr;
  }
}
