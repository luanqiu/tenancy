package ddd.tenancy.tenancy.spi.paybill;

import ddd.tenancy.tenancy.domain.common.billdetail.service.PayBillService;
import ddd.tenancy.tenancy.domain.common.billdetail.vo.PayResponseVO;
import ddd.tenancy.tenancy.domain.common.billdetail.vo.PayVO;

import org.springframework.stereotype.Service;

/**
 * 支付账单
 * date Jun 4, 2019 12:44:25 PM
 */
@Service
public class PayBillServiceImpl implements PayBillService {

  @Override
  public PayResponseVO payBill(PayVO payVO) {
    //对接三方渠道
    return null;
  }
}
