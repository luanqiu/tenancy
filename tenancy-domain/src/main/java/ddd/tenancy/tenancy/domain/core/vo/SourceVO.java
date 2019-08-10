package ddd.tenancy.tenancy.domain.core.vo;

import ddd.base.domain.VO;
import lombok.Data;

/**
* SourceVO
*author  wenhe
*date 2019/8/10
*/
@Data
public class SourceVO implements VO{

  private static final long serialVersionUID = 4371601572344695957L;

  /**
   * 业务方接入凭证
   */
  private String openId;

  /**
   * 业务方备注
   */
  private String remark;

  /**
   * 业务调用方ip
   */
  private String clientIp;

  /**
   * 操作人ID
   */
  private Long operatorId;

  /**
   *导致当前当作的来源故事
   */
  private String targetStory;

}
