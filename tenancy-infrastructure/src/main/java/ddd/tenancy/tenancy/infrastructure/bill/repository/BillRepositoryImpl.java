package ddd.tenancy.tenancy.infrastructure.bill.repository;

import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;
import ddd.tenancy.tenancy.domain.common.bill.repository.BillRepository;
import org.springframework.stereotype.Repository;

/**
* BillRepositoryImpl
*date Jun 4, 2019 12:44:25 PM
*/
@Repository
public class BillRepositoryImpl implements BillRepository {

  @Override
  public Boolean createBill(VO vo) {
    return null;
  }

  @Override
  public void insert(BillEntity billEntity) {

  }

  @Override
  public BillEntity getByBillId(String billId) {
    return null;
  }

}
