package ddd.tenancy.tenancy.domain.core.vo;

import ddd.base.domain.VO;

import ddd.tenancy.tenancy.domain.core.vo.moment.HoursingAddRequestMomentVO;
import lombok.Data;

/**
 * HousingResourcesBuildVO
 * date 2019/4/6
 */
@Data
public class HousingResourcesBuildVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
   * 房源唯一标识
   */
  private String housingId;

  /**
   * 房源地址
   */
  private String address;

  /**
   * 业主id
   */
  private String proprietorId;

  /**
   * 物业名称
   */
  private String propertyName;

  /**
   * 物业费
   */
  private String propertyFee;

  /**
   * 是否是房源的合法主人
   */
  private Boolean ownHousingLegal;

  /**
   * 从中间结果 VO 拿值，场景比较复杂的情况下，这种方法可能很多
   * 这不是一种行为，只是简单的参数转化
   */
  public static final HousingResourcesBuildVO buildFromHoursingAddRequestMomentVO(HoursingAddRequestMomentVO vo,Boolean ownHousingLegal) {
    HousingResourcesBuildVO buildVO = new HousingResourcesBuildVO();
    buildVO.setAddress(
        vo.getHoursingAddressMomentVO().buildChinaAddress());
    buildVO.setProprietorId(vo.getProprietorId());
    buildVO.setPropertyName(vo.getPropertyName());
    buildVO.setOwnHousingLegal(ownHousingLegal);
    return buildVO;
  }

}
