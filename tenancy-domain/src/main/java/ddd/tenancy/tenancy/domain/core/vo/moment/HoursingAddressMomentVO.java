package ddd.tenancy.tenancy.domain.core.vo.moment;

import lombok.Data;

/**
 * 房屋地址
 * author  wenhe
 * date 2019/7/18
 */
@Data
public class HoursingAddressMomentVO extends AddressMomentVO {

  private static final long serialVersionUID = 7033311863931467034L;

  /**
   * 洲
   */
  private String continent;

  /**
   * 中国地址
   */
  public String buildChinaAddress() {
    return super.buildAddress();
  }

  /**
   * 美国地址
   */
  public String buildUSAAddress() {
    return null;
  }

}
