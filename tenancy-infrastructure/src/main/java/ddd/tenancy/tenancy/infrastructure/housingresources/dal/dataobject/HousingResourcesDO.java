package ddd.tenancy.tenancy.infrastructure.housingresources.dal.dataobject;

import com.alibaba.fastjson.JSON;

import ddd.tenancy.tenancy.common.utils.CodeBeautifulUtils;
import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import ddd.tenancy.tenancy.domain.core.vo.PropertyInformationVO;
import ddd.tenancy.tenancy.domain.core.vo.ProprietorInfoVO;
import lombok.Data;

/**
* HousingResourcesDO
*author  wenhe
*date 2019/6/18
*/
@Data
public class HousingResourcesDO {

  /**
   *  房源id
   */
  private String housingId;

  /**
   * 房源地址
   */
  private String address;

  /**
   * 业主信息
   */
  private String proprietorInfo;

  /**
   * 物业信息
   */
  private String propertyInfo;

  /**
   * 状态
   */
  private String status;

  /**
   * 标
   */
  private Long tags;

  public HousingResourcesEntity buildEntity() {
    HousingResourcesEntity entity = HousingResourcesEntity.get();
    entity.setHousingId(getHousingId());
    entity.setAddress(getAddress());
    entity.setProprietorInfo(JSON.parseObject(getProprietorInfo(), ProprietorInfoVO.class));
    entity.setProprietorId(entity.getProprietorInfo().getProprietorId());
    entity.setPropertyInformation(JSON.parseObject(getPropertyInfo(), PropertyInformationVO.class));
    // int tags 二进制转化成看得懂 map 标
    entity.setTags(CodeBeautifulUtils.convertTagsIntToMap(getTags()));
    return entity;
  }


  public static final HousingResourcesDO buildDO(HousingResourcesEntity entity) {
    HousingResourcesDO DO =  new HousingResourcesDO();
    DO.setAddress(entity.getAddress());
    DO.setHousingId(entity.getHousingId());
    DO.setPropertyInfo(JSON.toJSONString(entity.getProprietorInfo()));
    DO.setPropertyInfo(JSON.toJSONString(entity.getPropertyInformation()));
    DO.setAddress(entity.getAddress());
    DO.setTags(CodeBeautifulUtils.convertTagsMapToInt(entity.getTags()));
    return DO;
  }





























}
