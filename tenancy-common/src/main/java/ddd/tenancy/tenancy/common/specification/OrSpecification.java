package ddd.tenancy.tenancy.common.specification;

/**
* OrSpecification
*author  likongpeng
*date 2019/4/6
*/
public class OrSpecification<T> extends CompositeSpecification<T>{

  private ISpecification<T> leftSpecification;
  private ISpecification<T> rightSpecification;

  public OrSpecification(ISpecification<T> leftSpecification, ISpecification<T> rightSpecification){
    this.leftSpecification=leftSpecification;
    this.rightSpecification =rightSpecification;
  }

  @Override
  public boolean isSatisfied(T candidate) {
    return leftSpecification.isSatisfied(candidate) || rightSpecification.isSatisfied(candidate);
  }
}
