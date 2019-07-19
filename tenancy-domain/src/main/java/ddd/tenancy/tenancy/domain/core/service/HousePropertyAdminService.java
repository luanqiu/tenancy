package  ddd.tenancy.tenancy.domain.core.service;

/**
 * HousePropertyAdminService
 * date Jun 4, 2019 12:44:25 PM
 */
public interface HousePropertyAdminService {

  /**
   * 房产局
   */
  Boolean checkHousingOwn(String proprietorId,String address);

  Boolean checkHouseLegality();
}
