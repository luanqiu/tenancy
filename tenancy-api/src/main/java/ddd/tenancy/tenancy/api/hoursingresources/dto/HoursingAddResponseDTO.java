package ddd.tenancy.tenancy.api.hoursingresources.dto;

import ddd.tenancy.tenancy.api.common.dto.BaseResponseDTO;
import lombok.Data;

/**
 * 房源添加出参
 * author  wenhe
 * date 2019/7/18
 */
@Data
public class HoursingAddResponseDTO extends BaseResponseDTO {

  private static final long serialVersionUID = -7479191486825022455L;

  /**
   * 房源唯一标识
   * 空、null 添加不成功
   * 具体状态看 code
   */
  private String housingId;

}
