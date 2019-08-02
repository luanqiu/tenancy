package ddd.tenancy.tenancy.domain.common.account.entity;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
public class AccountEntity implements Entity<String> {

  @Resource
  private DomainEventPublisherI domainEventPublisher;

  @Override
  public String getUniqueId() {
    return accountId;
  }

  /**
   * 用户 id
   */
  private String accountId;

  /**
   * 用户名称
   */
  private String accountName;

  /**
   * 正面照
   */
  private byte[] fullFacePhoto;

  /**
   * 身份证
   */
  private String idCard;

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final AccountEntity get() {
    return DomainFactory.get(AccountEntity.class);
  }

  public AccountEntity getByAccountId(String accountId) {
    return null;
  }

  // account 自检
  public void check() {
  }
}
