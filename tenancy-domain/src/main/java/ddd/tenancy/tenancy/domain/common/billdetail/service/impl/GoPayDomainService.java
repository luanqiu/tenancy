package ddd.tenancy.tenancy.domain.common.billdetail.service.impl;

import ddd.base.domain.DomainFactory;
import ddd.base.domain.DomainService;
import ddd.tenancy.tenancy.domain.common.billdetail.entity.BillDetailEntity;
import ddd.tenancy.tenancy.domain.common.billdetail.service.PayBillService;
import ddd.tenancy.tenancy.domain.common.billdetail.vo.BillDetailBuildVO;
import ddd.tenancy.tenancy.domain.common.billdetail.vo.PayResponseVO;
import ddd.tenancy.tenancy.domain.common.billdetail.vo.PayStatusEnum;
import ddd.tenancy.tenancy.domain.common.billdetail.vo.PayVO;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 去支付
 * date Jun 4, 2019 12:44:25 PM
 */
@Service
public class GoPayDomainService implements DomainService {

  @Resource
  private PayBillService payBillService;

  @Resource
  private DomainFactory<BillDetailBuildVO, BillDetailEntity> billDetailEntityFactory;

  public void goPay(PayVO payVO) {
    BillDetailEntity
        billDetailEntity =
        billDetailEntityFactory
            .perfect(new BillDetailBuildVO.Builder().billId(payVO.getBillId()).build());
    PayResponseVO payResponseVO = payBillService.payBill(payVO);
    switch (PayStatusEnum.valueOf(payResponseVO.getPayStatus())) {
      case SUCCESS:
        billDetailEntity.successBillDetail();
        break;
      case FAIL:
        billDetailEntity.failBillDetail();
        break;
      case UNKNOWN:
        billDetailEntity.retryBillDetail();
        break;
      default:
        throw new RuntimeException("未知支付状态");
    }
  }
}
