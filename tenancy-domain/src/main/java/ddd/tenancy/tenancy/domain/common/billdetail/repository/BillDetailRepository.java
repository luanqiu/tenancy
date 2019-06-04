package ddd.tenancy.tenancy.domain.common.billdetail.repository;

import ddd.base.domain.Repository;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.domain.common.billdetail.entity.BillDetailEntity;

/**
 * BillDetailRepository
 * author  likongpeng
 * date 2019/4/6
 */
public interface BillDetailRepository extends Repository {

  /**
   * 账单明细创建
   */
  Boolean createBillDetail(VO vo);

  /**
   *
   * @param billDetailEntity
   * @return
   */
  void insert(BillDetailEntity billDetailEntity) throws TenancySpiException;

  /**
   *
   * @param billDetailId
   * @return
   */
  BillDetailEntity getByBillDetailId(String billDetailId);

}
