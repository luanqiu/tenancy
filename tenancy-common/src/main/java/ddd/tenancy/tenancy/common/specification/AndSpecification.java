package ddd.tenancy.tenancy.common.specification;

/**
* AndSpecification
*date Jun 4, 2019 12:44:25 PM
*/
public class AndSpecification<T> extends CompositeSpecification<T>{

  private ISpecification<T> leftSpecification;
  private ISpecification<T> rightSpecification;

  public AndSpecification(ISpecification<T> leftSpecification,ISpecification<T> rightSpecification){
    this.leftSpecification=leftSpecification;
    this.rightSpecification =rightSpecification;
  }

  @Override
  public boolean isSatisfied(T candidate) {
    return leftSpecification.isSatisfied(candidate) && rightSpecification.isSatisfied(candidate);
  }
}
