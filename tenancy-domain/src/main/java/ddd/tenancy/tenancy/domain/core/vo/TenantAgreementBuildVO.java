package ddd.tenancy.tenancy.domain.core.vo;

import ddd.base.domain.VO;

import lombok.Data;

/**
 * TenantAgreementBuildVO
 * date 2019/4/6
 */
@Data
public class TenantAgreementBuildVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
  * 租房合同唯一标识
  */
  private String agreementId;

}
