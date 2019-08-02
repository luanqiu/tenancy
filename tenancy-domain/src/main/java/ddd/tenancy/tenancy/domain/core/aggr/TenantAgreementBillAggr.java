package ddd.tenancy.tenancy.domain.core.aggr;

import ddd.base.domain.Aggr;
import ddd.base.domain.DomainFactory;
import ddd.base.domain.VO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import ddd.tenancy.tenancy.domain.core.entity.TenantAgreementEntity;
import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;

/**
 * TenantAgreementBillAggr
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date Jun 4, 2019 12:44:25 PM
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TenantAgreementBillAggr implements Aggr<TenantAgreementEntity> {

  @Resource
  private DomainFactory<VO, TenantAgreementBillAggr> tenantAgreementBillAggrFactory;

  @Override
  public TenantAgreementEntity getAggrRoot() {
    return tenantAgreementEntity;
  }

  private TenantAgreementEntity tenantAgreementEntity;

  private BillEntity billEntity;

  /**
  * 构造租房合同账单
  */
  public void buildTenantAgreementBill() {

  }

  /**
   *
   * @param vo
   * @return
   */
  public TenantAgreementBillAggr get(VO vo) {
    return tenantAgreementBillAggrFactory.perfect(vo);
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final TenantAgreementBillAggr get() {
    return DomainFactory.get(TenantAgreementBillAggr.class);
  }

}
