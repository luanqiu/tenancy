package ddd.tenancy.tenancy.infrastructure.housingresources.dal;

import org.apache.ibatis.annotations.Param;

import ddd.tenancy.tenancy.infrastructure.housingresources.dal.dataobject.HousingResourcesDO;

/**
* HousingResourcesDAO
*author  wenhe
*date 2019/6/18
*/
public interface HousingResourcesDAO {

  HousingResourcesDO queryByHousingId(
      @Param("housingId") String housingId);

  int insert(@Param("insertDO") HousingResourcesDO insertDO);
}
