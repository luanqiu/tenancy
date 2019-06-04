package ddd.tenancy.tenancy.common.specification;

/**
* NotSpecification
*date 2019/4/6
*/
public class NotSpecification<T> extends CompositeSpecification<T>{

  private ISpecification<T> leftSpecification;
  private ISpecification<T> rightSpecification;

  public NotSpecification(ISpecification<T> leftSpecification, ISpecification<T> rightSpecification){
    this.leftSpecification=leftSpecification;
    this.rightSpecification =rightSpecification;
  }

  @Override
  public boolean isSatisfied(T candidate) {
    return !leftSpecification.isSatisfied(candidate) && !rightSpecification.isSatisfied(candidate);
  }
}
