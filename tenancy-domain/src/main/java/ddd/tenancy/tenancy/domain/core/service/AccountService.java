package ddd.tenancy.tenancy.domain.core.service;

/**
 * 账号系统的 服务接口
 * 和下游解耦的 service，方法可以任意多，我们尽量把和账户领域相关的方法都写在这个 service 里面
 * author  wenhe
 * date 2019/7/31
 */
public interface AccountService {

  /**
   * 校验账户信息
   */
  boolean checkAccountLegal(Long accountId);

}
