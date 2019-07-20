package ddd.tenancy.tenancy.common.exception;


import com.alibaba.fastjson.JSON;
import java.util.concurrent.Callable;

import ddd.tenancy.tenancy.api.common.OutErrorEnum;
import ddd.tenancy.tenancy.api.common.dto.BaseRequestDTO;
import ddd.tenancy.tenancy.api.common.dto.BaseResponseDTO;
import lombok.extern.slf4j.Slf4j;

/**
* ExceptionCatcher
*author  wenhe
*date 2019/7/18
*/
@Slf4j
public class ExceptionCatcher {

  /**
   * 退款创建 + 退款操作的聚合处理
   */
  public static <R extends BaseResponseDTO> R process(Class returnClazz,Object service, BaseRequestDTO request, Callable<?> callable) {

    String serviceName = service.getClass().getSimpleName();
    String requestJson = JSON.toJSONString(request);
    log.info("request is {},serviceName is {}", requestJson, serviceName);

    try {
      R result = (R) callable.call();
      log.info("result is {}",JSON.toJSONString(result));
      return result;
    }
    catch (TenancyPassException e) {// 是可以返回成功的错误类型
      log.info("TimeoutException, request is {},serviceName is {}", requestJson, serviceName,e);
      return buildFailResult(returnClazz,request,e);
    }
    catch (Exception e) {// 可以根据 common 下的异常类型进行细分
      log.error("Exception, request is {},serviceName is {}", requestJson, serviceName,e);
      return buildFailResult(returnClazz,request,e);
    }
    catch (Throwable e) {
      log.error("Throwable, request is {},serviceName is {}", requestJson, serviceName,e);
      return buildFailResult(returnClazz,request);
    }
  }

  public static <R extends BaseResponseDTO> R buildFailResult(Class returnClazz,
                                                              BaseRequestDTO request) {
    R response;
    try {
      response = (R) returnClazz.newInstance();
    } catch (Exception ex) {
      log.error("Object construct failed. class={}", returnClazz.getCanonicalName());
      return null;
    }
    response.setRequestId(request.getRequestId());
    response.setCode(OutErrorEnum.COMMON_ERROR.getCode().toString());
    response.setMessage(OutErrorEnum.COMMON_ERROR.getMessage());
    return response;
  }


  public static <R extends BaseResponseDTO> R buildFailResult(Class returnClazz,BaseRequestDTO request, Exception e) {
    R response;
    try {
      response = (R) returnClazz.newInstance();
    } catch (Exception ex) {
      log.error( "Object construct failed. class={}", returnClazz.getCanonicalName());
      return null;
    }
    response.setRequestId(request.getRequestId());
    try {
      if (e instanceof TenancyException) {
        TenancyException tenancyException = (TenancyException) e;
        response.setCode(
            tenancyException.getCode() >=0  ?  Errors.findByCode(tenancyException.getCode()).getOutErrorEnum().getCode():
            OutErrorEnum.COMMON_ERROR.getCode());
        response.setMessage(tenancyException.getCode() >=0  ?  Errors.findByCode(tenancyException.getCode()).getOutErrorEnum().getMessage():
                            OutErrorEnum.COMMON_ERROR.getMessage());
      } else {
        response.setCode(OutErrorEnum.COMMON_ERROR.getCode().toString());
        response.setMessage(OutErrorEnum.COMMON_ERROR.getMessage());
      }
      return response;
    } catch (Exception ex) {
      log.error("buildFailResult equest is {}",JSON.toJSONString(request),ex,e);
      return response;
    }
  }

}
