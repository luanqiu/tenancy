package ddd.tenancy.tenancy.domain.common.bill.entity;

import ddd.base.domain.DomainEventPublisherI;
import ddd.base.domain.DomainFactory;
import ddd.base.domain.Entity;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.common.specification.ISpecification;
import ddd.tenancy.tenancy.domain.common.bill.event.BillChangeEvent;
import ddd.tenancy.tenancy.domain.common.bill.repository.BillRepository;
import ddd.tenancy.tenancy.domain.common.bill.vo.BillBuildVO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * BillEntity
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date 2019/4/6
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BillEntity implements Entity<String> {

  @Resource
  private BillRepository billRepository;

  @Resource
  private ISpecification billCreateSpecification;

  @Resource
  private ISpecification billLegalSpecification;

  @Resource
  private DomainFactory<BillBuildVO, BillEntity> billEntityFactory;

  @Resource
  private DomainEventPublisherI domainEventPublisher;

  @Override
  public String getUniqueId() {
    return billId;
  }

  /**
  * 账单唯一标识
  */
  private String billId;

  /**
   * 账单类型
   *
   */
  private String type;

  /**
  * 创建账单
  */
  public void createBill(VO vo) {

  }

  /**
  * 账单提前结算
  */
  public void billAdvanceSettlement(VO vo) {

  }

  /**
  * 账单到期
  */
  public void matureBill(VO vo) {

  }

  /**
  * 账单创建
  */
  public BillEntity createBill(BillBuildVO billBuildVO) {
    try {
      billCreateSpecification.isSatisfied(billBuildVO);
      BillEntity billEntity = billEntityFactory.perfect(billBuildVO);
      billRepository.insert(billEntity);
      domainEventPublisher.publish(new BillChangeEvent(billEntity), false);
      return billEntity;
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
  * @param billId
  * @return
  */
  public BillEntity getByBillId(String billId) {
    try {
      return billRepository.getByBillId(billId).checkLegal();
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
  public BillEntity checkLegal() {
    boolean legal = billLegalSpecification.isSatisfied(this);
    if (!legal) {
      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
    }
    return this;
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final BillEntity get() {
    return DomainFactory.get(BillEntity.class);
  }

  public BillEntity get(BillBuildVO billBuildVO) {
    return billEntityFactory.perfect(billBuildVO);
  }

  public BillEntity getByBizIdAndType(String bizId, String billType) {
    return null;
  }
}
