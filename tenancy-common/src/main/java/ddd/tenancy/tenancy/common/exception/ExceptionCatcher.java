package ddd.tenancy.tenancy.common.exception;


import com.alibaba.fastjson.JSON;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
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
  public static <T> T process(Object service, Object request, Callable<?> callable) {

    String serviceName = service.getClass().getSimpleName();
    String requestJson = JSON.toJSONString(request);
    log.info("request is {},serviceName is {}", requestJson, serviceName);

    try {
      T plainResult = (T) callable.call();
      log.info("plainResult is {}",JSON.toJSONString(plainResult));
      return plainResult;
    }
    catch (TenancyPassException e) {// 是可以返回成功的错误类型
      log.info("TimeoutException, request is {},serviceName is {}", requestJson, serviceName,e);
      return null;
    }
    catch (Exception e) {// 可以根据 common 下的异常类型进行细分
      log.error("Exception, request is {},serviceName is {}", requestJson, serviceName,e);
      return null;
    }
    catch (Throwable e) {
      log.error("Throwable, request is {},serviceName is {}", requestJson, serviceName,e);
      return null;
    }
  }

}
