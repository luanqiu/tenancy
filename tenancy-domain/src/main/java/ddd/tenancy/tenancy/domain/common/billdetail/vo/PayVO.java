package ddd.tenancy.tenancy.domain.common.billdetail.vo;

import ddd.base.domain.VO;
import lombok.Getter;

/**
 * PayVO
 * author  wenhe
 * date 2019/6/5
 */
@Getter
public class PayVO implements VO {

  private static final long serialVersionUID = 3241806233455483161L;

  private String billId;

  public static class Builder {

    private String billId;

    public PayVO.Builder billId(String billId) {
      this.billId = billId;
      return this;
    }

    public PayVO build() {
      return new PayVO(this);
    }
  }

  private PayVO() {
  }

  public PayVO(PayVO.Builder builder) {
    this.billId = builder.billId;
  }
}
