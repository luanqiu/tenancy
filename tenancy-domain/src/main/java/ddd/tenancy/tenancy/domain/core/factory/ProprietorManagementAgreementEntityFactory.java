package ddd.tenancy.tenancy.domain.core.factory;

import ddd.base.domain.DomainFactory;
import ddd.tenancy.tenancy.domain.core.entity.ProprietorManagementAgreementEntity;
import ddd.tenancy.tenancy.domain.core.vo.ProprietorManagementAgreementBuildVO;
import org.springframework.stereotype.Component;

/**
 * ProprietorManagementAgreementFactory
 * perfect 简单的构造示范
 * date 2019/4/6
 */
@Component
public class ProprietorManagementAgreementEntityFactory implements DomainFactory<ProprietorManagementAgreementBuildVO, ProprietorManagementAgreementEntity> {

  @Override
  public ProprietorManagementAgreementEntity perfect(ProprietorManagementAgreementBuildVO vo) {
    ProprietorManagementAgreementEntity entity = ProprietorManagementAgreementEntity.get();
    entity.setProprietorManagementAgreementId("");
    return entity;
  }
}
