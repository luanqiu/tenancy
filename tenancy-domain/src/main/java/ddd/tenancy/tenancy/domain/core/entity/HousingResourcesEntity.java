package ddd.tenancy.tenancy.domain.core.entity;

import ddd.base.domain.DomainEventPublisherI;
import ddd.base.domain.DomainFactory;
import ddd.base.domain.Entity;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.common.specification.ISpecification;
import ddd.tenancy.tenancy.domain.core.event.HousingResourcesChangeEvent;
import ddd.tenancy.tenancy.domain.core.repository.HousingResourcesRepository;
import ddd.tenancy.tenancy.domain.core.repository.OperatorLogRepository;
import ddd.tenancy.tenancy.domain.core.vo.HousingResourcesBuildVO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import ddd.tenancy.tenancy.domain.core.vo.OperatorLogTypeEnum;
import ddd.tenancy.tenancy.domain.core.vo.ProprietorInfoVO;
import ddd.tenancy.tenancy.domain.core.vo.PropertyInformationVO;
import ddd.tenancy.tenancy.domain.core.vo.OperatorLogVO;

import javax.annotation.Resource;

import ddd.tenancy.tenancy.domain.core.vo.QueryHousingParamsVO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * HousingResourcesEntity
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date 2019/4/6
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HousingResourcesEntity implements Entity<String> {

  @Override
  public final String getUniqueId() {
    return housingId;
  }

  @Resource
  private HousingResourcesRepository housingResourcesRepository;

  @Resource
  private OperatorLogRepository operatorLogRepository;

  @Resource
  private ISpecification housingResourcesCreateSpecification;

  @Resource
  private ISpecification housingResourcesLegalSpecification;

  @Resource
  private DomainFactory<HousingResourcesBuildVO, HousingResourcesEntity> housingResourcesEntityFactory;

  @Resource
  private DomainEventPublisherI domainEventPublisher;



  /**
  * 房源唯一标识
  */
  private  String housingId;

  /**
  * 房源地址
  */
  private String address;

  /**
  * 业主id
  */
  private String proprietorId;

  /**
  * 业主信息
  */
  private ProprietorInfoVO proprietorInfo;

  /**
  * 物业信息
  */
  private PropertyInformationVO propertyInformation;

  /**
  * 操作记录
  */
  private List<OperatorLogVO> operatorLogs;

  /**
  * 增加房源
  */
  public void createHousingResources(VO vo) {

  }

  /**
  * 更新房源
  */
  public void updateHousingResources(VO vo) {

  }

  /**
  * 可租校验
  */
  public void checkRent(VO vo) {

  }

  /**
  * 校验房源合法性
  */
  public void checkHousingLegality(VO vo) {

  }

  /**
  * 房源创建
  */
  public HousingResourcesEntity createHousingResources(HousingResourcesBuildVO housingResourcesBuildVO) {
    try {
      housingResourcesCreateSpecification.isSatisfied(housingResourcesBuildVO);
      HousingResourcesEntity housingResourcesEntity = housingResourcesEntityFactory.perfect(housingResourcesBuildVO);
      housingResourcesRepository.insert(housingResourcesEntity);
      domainEventPublisher.publish(new HousingResourcesChangeEvent(housingResourcesEntity), false);
      return housingResourcesEntity;
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
  * @param housingId
  * @return
  */
  public HousingResourcesEntity getByHousingId(String housingId) {
    try {
      return housingResourcesRepository.getByHousingId(housingId).checkLegal();
    } catch (TenancySpiException e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
    } catch (TenancyDomainException e) {
      throw e;
    } catch (Exception e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
    }
  }

  /**
   * 根据实际需求查询房源实体
   * @param housingId
   * @param queryHousingParamsVO
   * @return
   */
  public HousingResourcesEntity getByHousingId(String housingId, QueryHousingParamsVO queryHousingParamsVO) {
    try {
      return housingResourcesRepository.getByHousingId(housingId,queryHousingParamsVO).checkLegal();
    } catch (TenancySpiException e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
    } catch (TenancyDomainException e) {
      throw e;
    } catch (Exception e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
    }
  }

  //糟糕的演示
//  public HousingResourcesEntity getByHousingId(String housingId,
//                                               QueryHousingParamsVO queryHousingParamsVO) {
//    try {
//      HousingResourcesEntity
//          housingResourcesEntity = housingResourcesRepository.getByHousingId(housingId).checkLegal();
//      if (queryHousingParamsVO.isQueryOperationLog()) {
//        List<OperatorLogVO> operatorLogVOS =
//            operatorLogRepository.queryByBizIdAndType(housingResourcesEntity.getHousingId(),
//                                                      OperatorLogTypeEnum.OPERATOR_LOG.getType());
//        housingResourcesEntity.setOperatorLogs(operatorLogVOS);
//      }
//      return housingResourcesEntity;
//    } catch (TenancySpiException e) {
//      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
//    } catch (TenancyDomainException e) {
//      throw e;
//    } catch (Exception e) {
//      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
//    }
//  }

  /**
   * 校验应该是自己校验的，这里委托给specification，保持代码的统一
   */
  public HousingResourcesEntity checkLegal() {
    boolean legal = housingResourcesLegalSpecification.isSatisfied(this);
    if (!legal) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
    }
    return this;
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final HousingResourcesEntity get() {
    return DomainFactory.get(HousingResourcesEntity.class);
  }

  public HousingResourcesEntity get(HousingResourcesBuildVO housingResourcesBuildVO) {
    return housingResourcesEntityFactory.perfect(housingResourcesBuildVO);
  }
}
