package ddd.tenancy.tenancy.domain.common.account.vo;

import ddd.base.domain.VO;
import lombok.Builder;
import lombok.Getter;

/**
* AccountCheckRequestVO
*author  wenhe
*date 2019/7/31
*/
@Getter
@Builder
public class AccountCheckRequestVO implements VO {

  private static final long serialVersionUID = 8355637868740549953L;

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

}
