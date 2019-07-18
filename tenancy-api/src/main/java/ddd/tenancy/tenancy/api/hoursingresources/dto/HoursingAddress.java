package ddd.tenancy.tenancy.api.hoursingresources.dto;

import ddd.tenancy.tenancy.api.common.dto.Address;
import lombok.Data;

/**
 * 房屋地址
 * author  wenhe
 * date 2019/7/18
 */
@Data
public class HoursingAddress extends Address {

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
