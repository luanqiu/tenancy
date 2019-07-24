package ddd.tenancy.tenancy.domain.core.vo.moment;

import java.io.Serializable;

import lombok.Data;

/**
 * 通用地址
 * author  wenhe
 * date 2019/7/18
 */
@Data
public class AddressMomentVO implements Serializable {

  private static final long serialVersionUID = 9169898796611461770L;

  /**
   * 国家
   */
  private String country;

  /**
   * 省
   */
  private String province;

  /**
   * 市
   */
  private String city;

  /**
   * 县/区
   */
  private String county;

  /**
   * 详细地址
   */
  private String detailedAddress;

  /**
   * 得到完整的地址
   */
  public String buildAddress() {
    return new StringBuffer().append(country)
        .append(province).append(city).append(country)
        .append(detailedAddress).toString();
  }

}
