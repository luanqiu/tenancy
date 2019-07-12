package ddd.tenancy.tenancy.domain.core.vo;

import ddd.base.domain.VO;
import lombok.Getter;
import lombok.Setter;

/**
 * QueryHousingParamsVO
 * author  wenhe
 * date 2019/6/18
 */
@Getter
@Setter
public class QueryHousingParamsVO implements VO {

  private static final long serialVersionUID = -4165038975704919449L;

  /**
   * 是否查询操作记录
   * true 查询，false 不查询，默认查询
   */
  private boolean queryOperationLog = false;

}
