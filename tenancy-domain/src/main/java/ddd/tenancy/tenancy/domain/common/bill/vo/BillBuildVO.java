package ddd.tenancy.tenancy.domain.common.bill.vo;

import ddd.base.domain.VO;

import lombok.Data;

/**
 * BillBuildVO
 * date 2019/4/6
 */
@Data
public class BillBuildVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
  * 账单唯一标识
  */
  private String billId;

}
