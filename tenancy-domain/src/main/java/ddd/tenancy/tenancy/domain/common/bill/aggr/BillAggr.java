package ddd.tenancy.tenancy.domain.common.bill.aggr;

import ddd.base.domain.Aggr;
import ddd.base.domain.DomainFactory;
import ddd.base.domain.VO;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.Resource;

import ddd.tenancy.tenancy.domain.common.bill.factory.BillDetailAggrFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;
import ddd.tenancy.tenancy.domain.common.billdetail.entity.BillDetailEntity;

/**
 * BillDetailAggr
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date Jun 4, 2019 12:44:25 PM
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BillAggr implements Aggr<BillEntity> {

  @Resource
  private BillDetailAggrFactory billDetailAggrFactory;

  @Override
  public BillEntity getAggrRoot() {
    return billEntity;
  }

  private BillEntity billEntity;

  private List<BillDetailEntity> billDetailEntity;

  /**
   * 构造账单明细
   */
  public void buildBillDetail(BillEntity billEntity) {
    // 此处聚合的实体我们都用 entity 表示，因为在流程中，
    // BillEntity 已经被查询出来了，这里直接使用即可
    // 所以入参是 entity，如果聚合的实体用唯一标识的话，
    // 这里就再查询一把 BillEntity
    setBillEntity(billEntity);
    // 构造账单明细
    List<BillDetailEntity> billDetailEntities = billDetailAggrFactory
        .buildBillDetail(billEntity);
    // 持久化
    BillDetailEntity.get().batchCreate(billDetailEntities);
  }

  /**
   * @param bizId    账单是为了记录业务的帐，bizId为此业务的唯一标识<br/>
   * @param billType 账单类型，不同业务不同的账单类型<br/>
   */
  public BillAggr queryBillDetailAggrByBizId(String bizId, String billType) {
    BillEntity billEntity = BillEntity.get().getByBizIdAndType(bizId, billType);
    List<BillDetailEntity> billDetailEntities = BillDetailEntity.get()
        .getByBillId(billEntity.getUniqueId());
    return billDetailAggrFactory.perfect(billEntity,billDetailEntities);
  }


  /**
   *
   * @param vo
   * @return
   */
  public BillAggr get(VO vo) {
    return billDetailAggrFactory.perfect(vo);
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final BillAggr get() {
    return DomainFactory.get(BillAggr.class);
  }

}
