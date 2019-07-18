package ddd.tenancy.tenancy.api.hoursingresources;

import ddd.tenancy.tenancy.api.hoursingresources.dto.HoursingAddRequestDTO;
import ddd.tenancy.tenancy.api.hoursingresources.dto.HoursingAddResponseDTO;

/**
 * 房源添加接口
 * author  wenhe
 * date 2019/7/18
 */
public interface HoursingAddService {

  /**
   * 添加房源
   */
  HoursingAddResponseDTO addHoursing(HoursingAddRequestDTO hourseAddRequest);

}
