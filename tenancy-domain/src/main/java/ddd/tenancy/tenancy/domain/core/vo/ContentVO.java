package ddd.tenancy.tenancy.domain.core.vo;

import com.alibaba.fastjson.JSON;

import ddd.base.domain.VO;
import lombok.Data;

/**
 * 操作记录内容
 * 方案1. 针对不同的场景，可能会有不同的内容 vo
 * 方案2. 当然不同场景的操作记录内容可以通用，使用 ContentVO 即可
 * author  wenhe
 * date 2019/8/10
 */
@Data
public class ContentVO implements VO {

  private static final long serialVersionUID = 4371601572344695957L;

  /*
    方案2 begin
     */
  // 场景可以通用，使用 ContentVO
    /*
    方案2 end
     */

  /*
 方案1 begin
  */
  // 如果场景都不能通用，用多个 VO
  private ContentVO content;

  @Data
  public class HousingContentVO extends ContentVO {
    private static final long serialVersionUID = -8946549279690778833L;
  }

  public  void buildVO(String content, String action) {
    switch (action) {
      case "HousingContent":
        setContent(JSON.parseObject(content, HousingContentVO.class));
        break;
      default:
        break;
    }
  }

  public  <T> T getSpecificContent(){
    return (T) content;
  }
   /*
    方案1 end
     */

}
