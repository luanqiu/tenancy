package ddd.tenancy.tenancy.domain.common.billdetail.vo;

import ddd.base.domain.VO;

import lombok.Getter;

/**
 * BillDetailBuildVO
 * date 2019/4/6
 */
@Getter
public class BillDetailBuildVO implements VO {

  private static final long serialVersionUID = -1L;

  private String billId;

  /**
   * 账单明细唯一标识
   */
  private String billDetailId;

  public static class Builder {

    private String billId;

    public Builder billId(String billId) {
      this.billId = billId;
      return this;
    }

    public BillDetailBuildVO build() {
      return new BillDetailBuildVO(this);
    }
  }

  private BillDetailBuildVO() {
  }

  public BillDetailBuildVO(Builder builder) {
    this.billId = builder.billId;
  }
}
