package ddd.tenancy.tenancy.infrastructure.housingresources.repository;

import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import ddd.tenancy.tenancy.domain.core.repository.HousingResourcesRepository;
import ddd.tenancy.tenancy.domain.core.vo.OperatorLogTypeEnum;
import ddd.tenancy.tenancy.domain.core.vo.OperatorLogVO;
import ddd.tenancy.tenancy.domain.core.vo.QueryHousingParamsVO;
import ddd.tenancy.tenancy.infrastructure.common.dal.OperatorLogDAO;
import ddd.tenancy.tenancy.infrastructure.common.dal.dataobject.OperatorLogDO;
import ddd.tenancy.tenancy.infrastructure.housingresources.dal.HousingResourcesDAO;
import ddd.tenancy.tenancy.infrastructure.housingresources.dal.dataobject.HousingResourcesDO;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.annotation.Resource;

/**
* HousingResourcesRepositoryImpl
*date Jun 4, 2019 12:44:25 PM
*/
@Repository
public class HousingResourcesRepositoryImpl implements HousingResourcesRepository {

  @Resource
  private HousingResourcesDAO housingResourcesDAO;

  @Resource
  private OperatorLogDAO operatorLogDAO;

  @Override
  public HousingResourcesEntity getByHousingId(String housingId,
                                               QueryHousingParamsVO queryHousingParamsVO) {
    HousingResourcesDO housingResourcesDO = housingResourcesDAO.queryByHousingId(housingId);
    HousingResourcesEntity housingResourcesEntity = housingResourcesDO.buildEntity();

    if (queryHousingParamsVO.isQueryOperationLog()) {
      List<OperatorLogDO>
          operatorLogDOList =
          operatorLogDAO.queryByBizIdAndType(housingId, OperatorLogTypeEnum.OPERATOR_LOG.getType());
      housingResourcesEntity.setOperatorLogs(OperatorLogDO.buildVOS(operatorLogDOList));
    }

    return housingResourcesEntity;
  }

  @Override
  public void insert(HousingResourcesEntity housingResourcesEntity) {
    HousingResourcesDO insertDO = HousingResourcesDO.buildDO(housingResourcesEntity);
    int success = housingResourcesDAO.insert(insertDO);
    if(success <= 0 ){
      throw new TenancySpiException(Errors.END);
    }
  }

  @Override
  public void addOperatorLog(OperatorLogVO operatorLog) {
    int success = operatorLogDAO.insert(OperatorLogDO.buildDO(operatorLog));
    if(success <= 0 ){
      throw new TenancySpiException(Errors.END);
    }
  }

  @Override
  public HousingResourcesEntity getByHousingId(String housingId) {
    return null;
  }


}
