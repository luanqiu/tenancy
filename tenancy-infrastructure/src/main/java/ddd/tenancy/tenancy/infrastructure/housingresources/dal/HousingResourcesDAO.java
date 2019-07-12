package ddd.tenancy.tenancy.infrastructure.housingresources.dal;

import ddd.tenancy.tenancy.infrastructure.housingresources.dal.dataobject.HousingResourcesDO;

/**
* HousingResourcesDAO
*author  wenhe
*date 2019/6/18
*/
public interface HousingResourcesDAO {

  HousingResourcesDO queryByHousingId(String housingId);
}
