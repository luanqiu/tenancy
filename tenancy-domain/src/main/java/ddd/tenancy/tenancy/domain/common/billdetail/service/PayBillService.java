package ddd.tenancy.tenancy.domain.common.billdetail.service;

import ddd.tenancy.tenancy.domain.common.billdetail.vo.PayResponseVO;
import ddd.tenancy.tenancy.domain.common.billdetail.vo.PayVO;

/**
 * PayBillService
 * date Jun 4, 2019 12:44:25 PM
 */
public interface PayBillService {

  /**
   * 支付
   */
  PayResponseVO payBill(PayVO payVO);

}
