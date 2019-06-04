package ddd.tenancy.tenancy.domain.common.bill.repository;

import ddd.base.domain.Repository;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;

/**
 * BillRepository
 * author  likongpeng
 * date 2019/4/6
 */
public interface BillRepository extends Repository {

  /**
   * 账单创建
   */
  Boolean createBill(VO vo);

  /**
   *
   * @param billEntity
   * @return
   */
  void insert(BillEntity billEntity) throws TenancySpiException;

  /**
   *
   * @param billId
   * @return
   */
  BillEntity getByBillId(String billId);

}
