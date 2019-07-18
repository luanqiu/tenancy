package ddd.tenancy.tenancy.api.hoursingresources.dto;


import ddd.tenancy.tenancy.api.common.dto.BaseRequestDTO;
import lombok.Data;

/**
 * 房源添加入参
 * author  wenhe
 * date 2019/7/18
 */
@Data
public class HoursingAddRequestDTO extends BaseRequestDTO {

  private static final long serialVersionUID = -7012138657836570530L;

  /**
   * 房屋地址
   */
  private HoursingAddress hoursingAddress;

  /**
   * 业主id
   */
  private String proprietorId;

  /**
   * 业主名称
   */
  private String proprietorName;

  /**
   * 物业名称
   */
  private String propertyName;

  /**
   * 物业费
   */
  private String propertyFee;

  /**
   * 操作人id
   */
  private String operatorId;

  /**
   * 来源
   */
  private String source;





}
