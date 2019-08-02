package ddd.tenancy.tenancy.domain.core.entity;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

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
import ddd.tenancy.tenancy.domain.core.vo.HousingResourcesBuildVO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import ddd.tenancy.tenancy.domain.core.vo.ProprietorInfoVO;
import ddd.tenancy.tenancy.domain.core.vo.PropertyInformationVO;
import ddd.tenancy.tenancy.domain.core.vo.OperatorLogVO;

import javax.annotation.Resource;

import ddd.tenancy.tenancy.domain.core.vo.QueryHousingParamsVO;
import ddd.tenancy.tenancy.domain.core.vo.moment.HoursingAddRequestMomentVO;
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
  private List<OperatorLogVO> operatorLogs = Lists.newArrayList();

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
//  public HousingResourcesEntity createHousingResources2(HousingResourcesBuildVO housingResourcesBuildVO) {
//    housingResourcesCreateSpecification.
//        isSatisfied(housingResourcesBuildVO);
//    return housingResourcesEntityFactory.
//        perfect(housingResourcesBuildVO);
//  }


  /**
  * 房源创建
  */
  public HousingResourcesEntity createHousingResources(HousingResourcesBuildVO housingResourcesBuildVO) {
    try {
      housingResourcesCreateSpecification.isSatisfied(housingResourcesBuildVO);
      HousingResourcesEntity housingResourcesEntity = housingResourcesEntityFactory.perfect(housingResourcesBuildVO);
      housingResourcesRepository.insert(housingResourcesEntity);
      // 这个消息看场景，如果业务方不需要操作记录，直接在这里发送，如果业务方需要操作记录，也可以写在事务落库之后再发送
      // HousingResourcesChangeListener 消费的地方，需要等待事务提交之后，才能开始发送消息，
      // 可以使用 spring 的 TransactionSynchronizationManager 来监听事务的成功和失败
      notifyEntity();
      return housingResourcesEntity;
    } catch (TenancySpiException e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
    } catch (TenancyDomainException e) {
      throw e;
    } catch (Exception e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
    }
  }

  // 实体和值对象一起新增
  public HousingResourcesEntity createHousingResourcesAll(HousingResourcesBuildVO housingResourcesBuildVO) {
    try {
      housingResourcesCreateSpecification.isSatisfied(housingResourcesBuildVO);
      // 得到实体的基本值
      HousingResourcesEntity housingResourcesEntity = housingResourcesEntityFactory.perfect(housingResourcesBuildVO);
      // 得到实体的所有值对象的值
      OperatorLogVO operatorLog = new OperatorLogVO();
      getOperatorLogs().add(operatorLog);
      // 将整个实体进行新增
      housingResourcesRepository.insert(housingResourcesEntity);
      notifyEntity();
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
   * 增加操作记录
   * 操作记录主要记录 5W 1H
   * WHO ： operatorId
   * WHERE ： source
   * WHAT ： housingId
   * WHEN ： time
   * WHY ： 录入房源
   * HOW ： 当前 application 要干什么事情
   */
  public void addOperatorLog(HoursingAddRequestMomentVO hoursingAddRequestMoment) {
    OperatorLogVO operatorLog = new OperatorLogVO();
    operatorLog.setOperatorId(hoursingAddRequestMoment.getOperatorId());// WHO
    operatorLog.setSource(hoursingAddRequestMoment.getSource());//WHERE
    operatorLog.setBizId(getUniqueId());//WHAT
    operatorLog.setBizTime(new Date());//WHEN
    operatorLog.setType("房源添加");//WHY 可以写个枚举
    operatorLog.setContent(JSON.toJSONString(
        new HashMap<String,String>(){{
          put("address",JSON.toJSONString(hoursingAddRequestMoment.getHoursingAddressMomentVO()));
          put("proprietorName",hoursingAddRequestMoment.getProprietorName());
          put("propertyName",hoursingAddRequestMoment.getPropertyName());
          put("propertyFee",hoursingAddRequestMoment.getPropertyFee());
        }}
                           )
    );//HOW 可以选择需要的字段
    housingResourcesRepository.addOperatorLog(operatorLog);
    // 不要忘记 放进去了，重要
    getOperatorLogs().add(operatorLog);
  }

  /**
   * 事件通知
   *  这里应该把自己全部通知出去，HousingResourcesChangeListener 里面会去区分，到底应该发送多少
   */
  public void notifyEntity() {
    domainEventPublisher.publish(new HousingResourcesChangeEvent(this), false);
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
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e);
    } catch (TenancyDomainException e) {
      throw e;
    } catch (Exception e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e);
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
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e);
    } catch (TenancyDomainException e) {
      throw e;
    } catch (Exception e) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e);
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
