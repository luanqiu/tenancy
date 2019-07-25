package ddd.tenancy.tenancy.infrastructure.common.dal.dataobject;

import com.google.common.collect.Lists;

import java.util.List;

import ddd.tenancy.tenancy.domain.core.vo.OperatorLogVO;

/**
* OperatorLogDO
*author  wenhe
*date 2019/6/18
*/
public class OperatorLogDO {

  public static List<OperatorLogVO> buildVOS(List<OperatorLogDO> operatorLogDOList) {
    return Lists.newArrayList();
  }

  public static final OperatorLogDO buildDO(OperatorLogVO vo){
    return new OperatorLogDO();
  }
}
