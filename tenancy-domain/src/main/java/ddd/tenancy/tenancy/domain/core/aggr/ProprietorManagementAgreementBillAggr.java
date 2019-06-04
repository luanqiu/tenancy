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

import ddd.tenancy.tenancy.domain.core.entity.ProprietorManagementAgreementEntity;
import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;

/**
 * ProprietorManagementAgreementBillAggr
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date Jun 4, 2019 12:44:25 PM
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProprietorManagementAgreementBillAggr implements Aggr<ProprietorManagementAgreementEntity> {

  @Resource
  private DomainFactory<VO, ProprietorManagementAgreementBillAggr> proprietorManagementAgreementBillAggrFactory;

  @Override
  public ProprietorManagementAgreementEntity getAggrRoot() {
    return proprietorManagementAgreementEntity;
  }

  @Resource
  private ProprietorManagementAgreementEntity proprietorManagementAgreementEntity;

  @Resource
  private BillEntity billEntity;

  /**
  * 构造业主合同账单
  */
  public void buildProprietorManagementAgreementBill() {

  }

  /**
   *
   * @param vo
   * @return
   */
  public ProprietorManagementAgreementBillAggr get(VO vo) {
    return proprietorManagementAgreementBillAggrFactory.perfect(vo);
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final ProprietorManagementAgreementBillAggr get() {
    return DomainFactory.get(ProprietorManagementAgreementBillAggr.class);
  }

}
