package ddd.tenancy.tenancy.domain.core.vo;

import ddd.base.domain.VO;

import lombok.Getter;
import lombok.experimental.Builder;

/**
 * 合同明细
 * date 2019/4/6
 */
@Getter
@Builder
public class AgreementInfoVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
   * 合同id
   */
  private String contractId;

  /**
   * 合同期限
   */
  private String timeTerm;

  /**
   * 合同期限单位
   */
  private String timeUnit;

  /**
   * 合同明细id
   */
  private String agreementId;


}
