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
import ddd.tenancy.tenancy.domain.support.appreciationservice.entity.AppreciationServiceEntity;

/**
 * TenantAgreementAppreciationServiceAggr
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date Jun 4, 2019 12:44:25 PM
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TenantAgreementAppreciationServiceAggr implements Aggr<TenantAgreementEntity> {

  @Resource
  private DomainFactory<VO, TenantAgreementAppreciationServiceAggr> tenantAgreementAppreciationServiceAggrFactory;

  @Override
  public TenantAgreementEntity getAggrRoot() {
    return tenantAgreementEntity;
  }

  private TenantAgreementEntity tenantAgreementEntity;

  private AppreciationServiceEntity appreciationServiceEntity;

  /**
  * 构造增值服务
  */
  public void buildAppreciationService() {

  }

  /**
   *
   * @param vo
   * @return
   */
  public TenantAgreementAppreciationServiceAggr get(VO vo) {
    return tenantAgreementAppreciationServiceAggrFactory.perfect(vo);
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final TenantAgreementAppreciationServiceAggr get() {
    return DomainFactory.get(TenantAgreementAppreciationServiceAggr.class);
  }

}
