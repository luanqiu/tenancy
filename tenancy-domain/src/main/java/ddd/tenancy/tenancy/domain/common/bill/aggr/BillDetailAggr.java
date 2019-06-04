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
import ddd.tenancy.tenancy.domain.common.bill.vo.BillTypeEnum;
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
public class BillDetailAggr implements Aggr<BillEntity> {

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
  public void buildBillDetail() {

  }

  /**
   * @param bizId    账单是为了记录业务的帐，bizId为此业务的唯一标识<br/>
   *                 如：帐是记录着租客租房的帐，bizId就为租房合同的唯一标识 (agreementId)
   * @param billType 账单类型，不同业务不同的账单类型<br/>
   *                 如果记录的是租房合同的帐，就是租房合同帐类型,这个类型的枚举放在bill的vo的package下面就好了
   *                 @see BillTypeEnum
   */
  public BillDetailAggr queryBillDetailAggrByBizId(String bizId, String billType) {
    BillEntity billEntity = BillEntity.get().getByBizId(bizId, billType);
    List<BillDetailEntity> billDetailEntities = BillDetailEntity.get().getByBillId(billEntity.getUniqueId());
    return billDetailAggrFactory.perfect(billEntity,billDetailEntities);
  }


  /**
   *
   * @param vo
   * @return
   */
  public BillDetailAggr get(VO vo) {
    return billDetailAggrFactory.perfect(vo);
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final BillDetailAggr get() {
    return DomainFactory.get(BillDetailAggr.class);
  }

}
