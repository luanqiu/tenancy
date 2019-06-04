package ddd.tenancy.tenancy.domain.common.billdetail.vo;

import ddd.base.domain.VO;
import lombok.Getter;

/**
* PayResponseVO
*author  wenhe
*date 2019/6/5
*/
@Getter
public class PayResponseVO implements VO {

  private static final long serialVersionUID = 8364151963622719743L;

  /**
   * 支付结果
   * 成功：success
   * 失败：fail
   * 需要重试：unknown
   */
  private String payStatus;
}
