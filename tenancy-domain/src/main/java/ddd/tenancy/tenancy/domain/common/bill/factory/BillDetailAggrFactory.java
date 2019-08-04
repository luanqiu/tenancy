package ddd.tenancy.tenancy.domain.common.bill.factory;

import com.google.common.collect.Lists;

import ddd.base.domain.DomainFactory;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.domain.common.bill.aggr.BillAggr;
import org.springframework.stereotype.Component;

import java.util.List;

import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;
import ddd.tenancy.tenancy.domain.common.billdetail.entity.BillDetailEntity;

/**
 * BillDetailAggrFactory
 * date 2019/4/6
 */
@Component
public class BillDetailAggrFactory implements DomainFactory<VO, BillAggr> {

  @Override
  public BillAggr perfect(VO vo) {
    BillAggr billDetailAggr = BillAggr.get();
    BillEntity billEntity = BillEntity.get();
    billDetailAggr.setBillEntity(billEntity);
    List<BillDetailEntity> billDetailEntitys = BillDetailEntity.get().getByBillId(null);
    billDetailAggr.setBillDetailEntity(billDetailEntitys);
    return billDetailAggr;
  }

  public BillAggr perfect(BillEntity billEntities, List<BillDetailEntity> billDetailEntity){
    BillAggr billDetailAggr = new BillAggr();
    billDetailAggr.setBillDetailEntity(billDetailEntity);
    billDetailAggr.setBillEntity(billEntities);
    return billDetailAggr;
  }

  public List<BillDetailEntity> buildBillDetail(BillEntity billEntity) {
    // 账单类型
    // 记帐的场景主要有：业主合同帐、增值服务帐、租房合同帐
    // 我们可以抽象成生成多个账单明细，和一个账单明细。
    switch (billEntity.getType()){
      // 业主合同帐 生成多个账单明细
      case "ProprietorManagementAgreement":
        return buildMoreDetail(billEntity);
      // 业主合同帐 生成多个账单明细
      case "TenantAgreement":
        return buildMoreDetail(billEntity);
      // 业主合同帐 生成一个账单明细
      case "appreciationService":
        return buildDetail(billEntity);
      default:
        break;
    }
    throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
  }

  // 具体的逻辑省略了，不太清楚账单明细到底有那些具体的字段
  private List<BillDetailEntity> buildDetail(BillEntity billEntity) {
    List<BillDetailEntity> billDetailEntities = Lists.newArrayList();
    BillDetailEntity billDetailEntity = new BillDetailEntity();
    billDetailEntities.add(billDetailEntity);
    return billDetailEntities;
  }

  private List<BillDetailEntity> buildMoreDetail(BillEntity billEntity) {
    List<BillDetailEntity> billDetailEntities = Lists.newArrayList();
    return billDetailEntities;
  }
}
