package ddd.tenancy.tenancy.api.common.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * common response
 * author  likongpeng
 * date 2019/4/7
 */
@Data
public class BaseResponseDTO implements Serializable {

  private static final long serialVersionUID = -1L;

  /**
   * 请求幂等字段
   */
  private String requestId;

  /**
   * 返回码
   */
  private String code;

  /**
   * 返回信息
   */
  private String message;

  public Boolean success() {
    return true;
  }
}
