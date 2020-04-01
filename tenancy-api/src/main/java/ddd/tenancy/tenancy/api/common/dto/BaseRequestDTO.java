package ddd.tenancy.tenancy.api.common.dto;

import java.io.Serializable;
import java.util.Date;

import ddd.tenancy.tenancy.api.common.OutErrorEnum;
import lombok.Data;

/**
* 通用request
*author  likongpeng
*date 2019/4/7
*/
@Data
public class BaseRequestDTO implements Serializable{

  private static final long serialVersionUID = -1L;

  /**
   *请求幂等字段
   */
  private String requestId;

  /**
   * 业务发生的时间(这笔请求发起的时间)
   */
  private Date bizDate;

  /**
   * 错误码
   * @see OutErrorEnum
   */
  private String code;

  /**
   * 错误码描述
   * @see OutErrorEnum
   */
  private String msg;

  /**
   * 前端请求到后端，后端匹配的 flowId
   */
  private String flowId;

  @Override
  public String toString() {
    return "BaseRequestDTO{" +
           "requestId='" + requestId + '\'' +
           ", bizDate=" + bizDate +
           '}';
  }
}
