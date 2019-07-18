package ddd.tenancy.tenancy.domain.core.vo.moment;

import ddd.base.domain.VO;
import lombok.Data;

/**
 * 一次会话之后就会消亡的vo，不会落库，除了日志不会有任何痕迹
 * 主要用于中间计算，转化等等
 * author  wenhe
 * date 2019/7/18
 */
@Data
public class HoursingAddRequestMomentVO implements VO {

  private static final long serialVersionUID = 7682791246841957572L;

  /**
   * 房屋地址
   */
  private HoursingAddressMomentVO hoursingAddressMomentVO;

  /**
   * 业主id
   */
  private String proprietorId;

  /**
   * 业主名称
   */
  private String proprietorName;

  /**
   * 物业名称
   */
  private String propertyName;

  /**
   * 物业费
   */
  private String propertyFee;

  /**
   * 操作人id
   */
  private String operatorId;

  /**
   * 来源
   */
  private String source;

}
