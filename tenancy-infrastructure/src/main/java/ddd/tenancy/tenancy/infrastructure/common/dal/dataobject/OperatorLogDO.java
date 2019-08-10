package ddd.tenancy.tenancy.infrastructure.common.dal.dataobject;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

import ddd.tenancy.tenancy.domain.core.vo.ContentVO;
import ddd.tenancy.tenancy.domain.core.vo.OperatorLogVO;
import ddd.tenancy.tenancy.domain.core.vo.SourceVO;
import lombok.Data;

/**
* OperatorLogDO
*author  wenhe
*date 2019/6/18
*/
@Data
public class OperatorLogDO {

  private Long id;

  /**
   * 业务id
   */
  private String bizId;

  /**
   * 操作人id
   */
  private String operatorId;

  /**
   * 操作类型
   */
  private String action;

  private Date created;

  private Date updated;

  /**
   * 操作内容
   */
  private String content;

  public static List<OperatorLogVO> buildVOS(List<OperatorLogDO> operatorLogDOList) {
    if(CollectionUtils.isEmpty(operatorLogDOList)){
      return Lists.newArrayList();
    }
    List<OperatorLogVO> result = Lists.newArrayListWithCapacity
        (Math.max((int) (operatorLogDOList.size() / .75f) + 1, 16));
    for (OperatorLogDO DO : operatorLogDOList) {
      OperatorLogVO vo = new OperatorLogVO();
      SourceVO source = new SourceVO();
      source.setOperatorId(Long.valueOf(DO.getOperatorId()));
      vo.setSource(source);
      vo.setType(DO.getAction());
      vo.setBizId(DO.getBizId());
      vo.setBizTime(DO.getCreated());
      ContentVO content = new ContentVO();
      content.buildVO(DO.getContent(),DO.getAction());
      vo.setContent(content);
      result.add(vo);
    }
    return result;
  }

  public static final OperatorLogDO buildDO(OperatorLogVO vo){
    OperatorLogDO DO = new OperatorLogDO();
    DO.setBizId(vo.getBizId());
    DO.setOperatorId(vo.getSource().getOperatorId()+"");
    DO.setAction(vo.getType());
    DO.setCreated(vo.getBizTime());
    DO.setUpdated(new Date());
    DO.setContent(JSON.toJSONString(vo.getContent()));
    return DO;
  }





















}
