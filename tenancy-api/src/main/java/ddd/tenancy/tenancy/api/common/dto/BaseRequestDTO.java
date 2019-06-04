package ddd.tenancy.tenancy.api.common.dto;

import java.io.Serializable;
import java.util.Date;

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

  @Override
  public String toString() {
    return "BaseRequestDTO{" +
           "requestId='" + requestId + '\'' +
           ", bizDate=" + bizDate +
           '}';
  }
}
