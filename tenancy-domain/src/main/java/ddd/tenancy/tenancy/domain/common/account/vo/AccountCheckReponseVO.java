package ddd.tenancy.tenancy.domain.common.account.vo;

import ddd.base.domain.VO;
import lombok.Data;

/**
* AccountCheckReponseVO
*author  wenhe
*date 2019/7/31
*/
@Data
public class AccountCheckReponseVO implements VO {


  private static final long serialVersionUID = -8799303596957375705L;

  /**
   * 校验是否通过
   */
  private boolean checkSuccess;

  /**
   * 校验 未通过 原因
   */
  private String failReason;
}
