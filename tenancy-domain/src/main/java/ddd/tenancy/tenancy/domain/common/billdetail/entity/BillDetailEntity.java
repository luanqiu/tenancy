package ddd.tenancy.tenancy.domain.common.billdetail.entity;

import ddd.base.domain.DomainEventPublisherI;
import ddd.base.domain.DomainFactory;
import ddd.base.domain.Entity;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.common.specification.ISpecification;
import ddd.tenancy.tenancy.domain.common.billdetail.event.BillDetailChangeEvent;
import ddd.tenancy.tenancy.domain.common.billdetail.repository.BillDetailRepository;
import ddd.tenancy.tenancy.domain.common.billdetail.vo.BillDetailBuildVO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.util.List;

import javax.annotation.Resource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * BillDetailEntity
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date 2019/4/6
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BillDetailEntity implements Entity<String> {

  @Resource
  private BillDetailRepository billDetailRepository;

  @Resource
  private ISpecification billDetailCreateSpecification;

  @Resource
  private ISpecification billDetailLegalSpecification;

  @Resource
  private DomainFactory<BillDetailBuildVO, BillDetailEntity> billDetailEntityFactory;

  @Resource
  private DomainEventPublisherI domainEventPublisher;


  @Override
  public String getUniqueId() {
    return billDetailId;
  }

  /**
  * 账单明细唯一标识
  */
  private String billDetailId;

  /**
  * 新增账单明细
  */
  public void createBillDetail(VO vo) {

  }

  /**
   * 更改账单明细状态为成功
   */
  public void successBillDetail() {

  }

  /**
   * 更改账单明细状态为失败
   */
  public void failBillDetail() {

  }

  /**
   * 更改账单明细状态为重试
   */
  public void retryBillDetail() {

  }

  /**
  * 账单明细创建
  */
  public BillDetailEntity createBillDetail(BillDetailBuildVO billDetailBuildVO) {
    try {
      billDetailCreateSpecification.isSatisfied(billDetailBuildVO);
      BillDetailEntity billDetailEntity = billDetailEntityFactory.perfect(billDetailBuildVO);
      billDetailRepository.insert(billDetailEntity);
      domainEventPublisher.publish(new BillDetailChangeEvent(billDetailEntity), false);
      return billDetailEntity;
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
  * @param billDetailId
  * @return
  */
  public BillDetailEntity getByBillDetailId(String billDetailId) {
    try {
      return billDetailRepository.getByBillDetailId(billDetailId).checkLegal();
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
  public BillDetailEntity checkLegal() {
    boolean legal = billDetailLegalSpecification.isSatisfied(this);
    if (!legal) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
    }
    return this;
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final BillDetailEntity get() {
    return DomainFactory.get(BillDetailEntity.class);
  }

  public BillDetailEntity get(BillDetailBuildVO billDetailBuildVO) {
    return billDetailEntityFactory.perfect(billDetailBuildVO);
  }

  public List<BillDetailEntity> getByBillId(String billId) {
    return null;
  }

  /**
   * 批量新增
   * @param billDetailEntities
   */
  public void batchCreate(List<BillDetailEntity> billDetailEntities) {

  }
}
