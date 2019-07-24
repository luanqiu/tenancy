package ddd.tenancy.tenancy.domain.core.vo;

import ddd.base.domain.VO;

import lombok.Builder;
import lombok.Getter;

/**
 * 房屋委托协议
 * date 2019/4/6
 */
@Getter
@Builder
public class HousingEntrustmentAgreementVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
   * 合同id
   */
  private String contractId;

  /**
   * 房源id
   */
  private String housingId;

  /**
   * 业主信息
   */
  private String proprietorId;


}
