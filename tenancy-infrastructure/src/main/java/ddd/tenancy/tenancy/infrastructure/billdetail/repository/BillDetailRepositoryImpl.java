package ddd.tenancy.tenancy.infrastructure.billdetail.repository;

import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.common.billdetail.entity.BillDetailEntity;
import ddd.tenancy.tenancy.domain.common.billdetail.repository.BillDetailRepository;
import org.springframework.stereotype.Repository;

/**
* BillDetailRepositoryImpl
*date Jun 4, 2019 12:44:25 PM
*/
@Repository
public class BillDetailRepositoryImpl implements BillDetailRepository {

  @Override
  public Boolean createBillDetail(VO vo) {
    return null;
  }

  @Override
  public void insert(BillDetailEntity billDetailEntity) {

  }

  @Override
  public BillDetailEntity getByBillDetailId(String billDetailId) {
    return null;
  }

}
