package ddd.tenancy.tenancy.api.common.dto;

import java.io.Serializable;

import ddd.tenancy.tenancy.api.common.OutErrorEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * common response
 * author  likongpeng
 * date 2019/4/7
 */
@Slf4j
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
    return null != code && code.equals(OutErrorEnum.COMMON_SUCCESS.getCode());
  }

  public static final <T extends BaseResponseDTO> T buildBaseSuccess(Class<T> clazz)
      throws RuntimeException {
    T response = null;
    try {
      response = clazz.newInstance();
      response.setCode(OutErrorEnum.COMMON_SUCCESS.getCode());
      response.setMessage(OutErrorEnum.COMMON_SUCCESS.getMessage());
      return response;
    } catch (Exception e) {
      throw new RuntimeException(clazz.getName()+"初始化失败");
    }
  }

  public static final <T extends BaseResponseDTO> T  buildBaseFail(Class<T> clazz){
    T response = null;
    try {
      response = clazz.newInstance();
      response.setCode(OutErrorEnum.COMMON_ERROR.getCode());
      response.setMessage(OutErrorEnum.COMMON_ERROR.getMessage());
      return response;
    } catch (Exception e) {
      throw new RuntimeException(clazz.getName()+"初始化失败");
    }
  }

}
