package ddd.tenancy.tenancy.domain.core.entity;

import ddd.base.domain.DomainEventPublisherI;
import ddd.base.domain.DomainFactory;
import ddd.base.domain.Entity;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.common.specification.ISpecification;
import ddd.tenancy.tenancy.domain.core.event.TenantAgreementChangeEvent;
import ddd.tenancy.tenancy.domain.core.repository.TenantAgreementRepository;
import ddd.tenancy.tenancy.domain.core.vo.TenantAgreementBuildVO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ddd.tenancy.tenancy.domain.core.vo.AgreementInfoVO;

import javax.annotation.Resource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * TenantAgreementEntity
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date 2019/4/6
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TenantAgreementEntity implements Entity<String> {

  @Resource
  private TenantAgreementRepository tenantAgreementRepository;

  @Resource
  private ISpecification tenantAgreementCreateSpecification;

  @Resource
  private ISpecification tenantAgreementLegalSpecification;

  @Resource
  private DomainFactory<TenantAgreementBuildVO, TenantAgreementEntity> tenantAgreementEntityFactory;

  @Resource
  private DomainEventPublisherI domainEventPublisher;

  @Override
  public String getUniqueId() {
    return agreementId;
  }

  /**
  * 租房合同唯一标识
  */
  private String agreementId;

  /**
  * 合同明细
  */
  private AgreementInfoVO agreementInfo;

  /**
  * 签订合同
  */
  public void signAgreement(VO vo) {

  }

  /**
  * 合同到期
  */
  public void expireAgreement(VO vo) {

  }

  /**
  * 续约合同
  */
  public void renewAgreement(VO vo) {

  }

  /**
  * 退订合同
  */
  public void unsubscribeAgreement(VO vo) {

  }

  /**
  * 换房
  */
  public void exchangeHouses(VO vo) {

  }

  /**
  * 租房合同创建
  */
  public TenantAgreementEntity createTenantAgreement(TenantAgreementBuildVO tenantAgreementBuildVO) {
    try {
      tenantAgreementCreateSpecification.isSatisfied(tenantAgreementBuildVO);
      TenantAgreementEntity tenantAgreementEntity = tenantAgreementEntityFactory.perfect(tenantAgreementBuildVO);
      tenantAgreementRepository.insert(tenantAgreementEntity);
      domainEventPublisher.publish(new TenantAgreementChangeEvent(tenantAgreementEntity), false);
      return tenantAgreementEntity;
    } catch (TenancySpiException e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
    } catch (TenancyDomainException e) {
      throw e;
    } catch (Exception e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
    }
  }

  /**
  *
  * @param agreementId
  * @return
  */
  public TenantAgreementEntity getByAgreementId(String agreementId) {
    try {
      return tenantAgreementRepository.getByAgreementId(agreementId).checkLegal();
    } catch (TenancySpiException e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
    } catch (TenancyDomainException e) {
      throw e;
    } catch (Exception e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
    }
  }

  /**
   * 校验应该是自己校验的，这里委托给specification，保持代码的统一
   */
  public TenantAgreementEntity checkLegal() {
    boolean legal = tenantAgreementLegalSpecification.isSatisfied(this);
    if (!legal) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
    }
    return this;
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final TenantAgreementEntity get() {
    return DomainFactory.get(TenantAgreementEntity.class);
  }

  public TenantAgreementEntity get(TenantAgreementBuildVO tenantAgreementBuildVO) {
    return tenantAgreementEntityFactory.perfect(tenantAgreementBuildVO);
  }
}
