package ddd.tenancy.tenancy.domain.common.bill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * BillEnum
 * author  wenhe
 * date 2019/6/4
 */
@Getter
@AllArgsConstructor
public enum BillTypeEnum {
  TENANT_AGREEMENT_TYPE("tenantAgreementType", "租房合同帐");

  private String code;
  private String desc;

}
