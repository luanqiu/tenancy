package ddd.tenancy.tenancy.domain.support.appreciationservice.entity;

import ddd.base.domain.DomainEventPublisherI;
import ddd.base.domain.DomainFactory;
import ddd.base.domain.Entity;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.common.specification.ISpecification;
import ddd.tenancy.tenancy.domain.support.appreciationservice.event.AppreciationServiceChangeEvent;
import ddd.tenancy.tenancy.domain.support.appreciationservice.repository.AppreciationServiceRepository;
import ddd.tenancy.tenancy.domain.support.appreciationservice.vo.AppreciationServiceBuildVO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ddd.tenancy.tenancy.domain.support.appreciationservice.vo.ServiceInfoVO;

import javax.annotation.Resource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * AppreciationServiceEntity
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date 2019/4/6
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AppreciationServiceEntity implements Entity<String> {

  @Resource
  private AppreciationServiceRepository appreciationServiceRepository;

  @Resource
  private ISpecification appreciationServiceCreateSpecification;

  @Resource
  private ISpecification appreciationServiceLegalSpecification;

  @Resource
  private DomainFactory<AppreciationServiceBuildVO, AppreciationServiceEntity> appreciationServiceEntityFactory;

  @Resource
  private DomainEventPublisherI domainEventPublisher;

  @Override
  public String getUniqueId() {
    return appreciationServiceId;
  }

  /**
  * 增值服务唯一标识
  */
  private String appreciationServiceId;

  /**
  * 服务信息
  */
  private ServiceInfoVO serviceInfo;

  /**
  * 新增增值服务
  */
  public void createAppreciationService(VO vo) {

  }

  /**
  * 更改增值服务状态到完成
  */
  public void successAppreciationService(VO vo) {

  }

  /**
  * 更改增值服务状态到完成
  */
  public void completeAppreciationService(VO vo) {

  }

  /**
  * 增值服务创建
  */
  public AppreciationServiceEntity createAppreciationService(AppreciationServiceBuildVO appreciationServiceBuildVO) {
    try {
      appreciationServiceCreateSpecification.isSatisfied(appreciationServiceBuildVO);
      AppreciationServiceEntity appreciationServiceEntity = appreciationServiceEntityFactory.perfect(appreciationServiceBuildVO);
      appreciationServiceRepository.insert(appreciationServiceEntity);
      domainEventPublisher.publish(new AppreciationServiceChangeEvent(appreciationServiceEntity), false);
      return appreciationServiceEntity;
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
  * @param appreciationServiceId
  * @return
  */
  public AppreciationServiceEntity getByAppreciationServiceId(String appreciationServiceId) {
    try {
      return appreciationServiceRepository.getByAppreciationServiceId(appreciationServiceId).checkLegal();
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
  public AppreciationServiceEntity checkLegal() {
    boolean legal = appreciationServiceLegalSpecification.isSatisfied(this);
    if (!legal) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
    }
    return this;
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final AppreciationServiceEntity get() {
    return DomainFactory.get(AppreciationServiceEntity.class);
  }

  public AppreciationServiceEntity get(AppreciationServiceBuildVO appreciationServiceBuildVO) {
    return appreciationServiceEntityFactory.perfect(appreciationServiceBuildVO);
  }
}
