package ddd.tenancy.tenancy.domain.common.bill.factory;

import ddd.base.domain.DomainFactory;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.common.bill.aggr.BillDetailAggr;
import org.springframework.stereotype.Component;

import java.util.List;

import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;
import ddd.tenancy.tenancy.domain.common.billdetail.entity.BillDetailEntity;

/**
 * BillDetailAggrFactory
 * date 2019/4/6
 */
@Component
public class BillDetailAggrFactory implements DomainFactory<VO, BillDetailAggr> {

  @Override
  public BillDetailAggr perfect(VO vo) {
    BillDetailAggr billDetailAggr = BillDetailAggr.get();

    BillEntity billEntity = BillEntity.get();
    billDetailAggr.setBillEntity(billEntity);
    List<BillDetailEntity> billDetailEntitys = BillDetailEntity.get().getByBillId(null);
    billDetailAggr.setBillDetailEntity(billDetailEntitys);
    return billDetailAggr;
  }

  public BillDetailAggr perfect(BillEntity billEntities,List<BillDetailEntity> billDetailEntity){
    BillDetailAggr billDetailAggr = new BillDetailAggr();
    billDetailAggr.setBillDetailEntity(billDetailEntity);
    billDetailAggr.setBillEntity(billEntities);
    return billDetailAggr;
  }
}
