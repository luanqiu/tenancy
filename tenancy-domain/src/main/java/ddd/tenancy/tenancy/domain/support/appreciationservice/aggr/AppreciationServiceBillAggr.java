package ddd.tenancy.tenancy.domain.support.appreciationservice.aggr;

import ddd.base.domain.Aggr;
import ddd.base.domain.DomainFactory;
import ddd.base.domain.VO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import ddd.tenancy.tenancy.domain.support.appreciationservice.entity.AppreciationServiceEntity;
import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;

/**
 * AppreciationServiceBillAggr
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date Jun 4, 2019 12:44:25 PM
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AppreciationServiceBillAggr implements Aggr<AppreciationServiceEntity> {

  @Resource
  private DomainFactory<VO, AppreciationServiceBillAggr> appreciationServiceBillAggrFactory;

  @Override
  public AppreciationServiceEntity getAggrRoot() {
    return appreciationServiceEntity;
  }

  private AppreciationServiceEntity appreciationServiceEntity;

  private BillEntity billEntity;

  /**
  * 构造增值服务账单
  */
  public void buildBill() {

  }

  /**
   *
   * @param vo
   * @return
   */
  public AppreciationServiceBillAggr get(VO vo) {
    return appreciationServiceBillAggrFactory.perfect(vo);
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final AppreciationServiceBillAggr get() {
    return DomainFactory.get(AppreciationServiceBillAggr.class);
  }

}
