package ddd.tenancy.tenancy.domain.core.entity;

import ddd.base.domain.DomainEventPublisherI;
import ddd.base.domain.DomainFactory;
import ddd.base.domain.Entity;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.common.specification.ISpecification;
import ddd.tenancy.tenancy.domain.core.event.ProprietorManagementAgreementChangeEvent;
import ddd.tenancy.tenancy.domain.core.repository.ProprietorManagementAgreementRepository;
import ddd.tenancy.tenancy.domain.core.vo.ProprietorManagementAgreementBuildVO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ddd.tenancy.tenancy.domain.core.vo.AgreementInfoVO;
import ddd.tenancy.tenancy.domain.core.vo.HousingEntrustmentAgreementVO;
import ddd.tenancy.tenancy.domain.core.vo.OperatorLogVO;

import javax.annotation.Resource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * ProprietorManagementAgreementEntity
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date 2019/4/6
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProprietorManagementAgreementEntity implements Entity<String> {

  @Resource
  private ProprietorManagementAgreementRepository proprietorManagementAgreementRepository;

  @Resource
  private ISpecification proprietorManagementAgreementCreateSpecification;

  @Resource
  private ISpecification proprietorManagementAgreementLegalSpecification;

  @Resource
  private DomainFactory<ProprietorManagementAgreementBuildVO, ProprietorManagementAgreementEntity> proprietorManagementAgreementEntityFactory;

  @Resource
  private DomainEventPublisherI domainEventPublisher;

  @Override
  public String getUniqueId() {
    return proprietorManagementAgreementId;
  }

  /**
  * 合同id
  */
  private String proprietorManagementAgreementId;

  /**
  * 合同信息
  */
  private AgreementInfoVO agreementInfo;

  /**
  * 房屋委托协议
  */
  private HousingEntrustmentAgreementVO housingEntrustmentAgreement;

  /**
  * 操作记录
  */
  private OperatorLogVO operatorLog;

  /**
  * 创建合同
  */
  public void createProprietorManagementAgreement(VO vo) {

  }

  /**
  * 合同过期
  */
  public void expireProprietorManagementAgreement(VO vo) {

  }

  /**
  * 业主房屋管理合同创建
  */
  public ProprietorManagementAgreementEntity createProprietorManagementAgreement(ProprietorManagementAgreementBuildVO proprietorManagementAgreementBuildVO) {
    try {
      proprietorManagementAgreementCreateSpecification.isSatisfied(proprietorManagementAgreementBuildVO);
      ProprietorManagementAgreementEntity proprietorManagementAgreementEntity = proprietorManagementAgreementEntityFactory.perfect(proprietorManagementAgreementBuildVO);
      proprietorManagementAgreementRepository.insert(proprietorManagementAgreementEntity);
      domainEventPublisher.publish(new ProprietorManagementAgreementChangeEvent(proprietorManagementAgreementEntity), false);
      return proprietorManagementAgreementEntity;
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
  * @param proprietorManagementAgreementId
  * @return
  */
  public ProprietorManagementAgreementEntity getByProprietorManagementAgreementId(String proprietorManagementAgreementId) {
    try {
      return proprietorManagementAgreementRepository.getByProprietorManagementAgreementId(proprietorManagementAgreementId).checkLegal();
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
  public ProprietorManagementAgreementEntity checkLegal() {
    boolean legal = proprietorManagementAgreementLegalSpecification.isSatisfied(this);
    if (!legal) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
    }
    return this;
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final ProprietorManagementAgreementEntity get() {
    return DomainFactory.get(ProprietorManagementAgreementEntity.class);
  }

  public ProprietorManagementAgreementEntity get(ProprietorManagementAgreementBuildVO proprietorManagementAgreementBuildVO) {
    return proprietorManagementAgreementEntityFactory.perfect(proprietorManagementAgreementBuildVO);
  }
}
