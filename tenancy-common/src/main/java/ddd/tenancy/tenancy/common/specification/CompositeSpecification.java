package ddd.tenancy.tenancy.common.specification;

/**
* CompositeSpecification
*date 2019/4/6
*/
public abstract class CompositeSpecification<T> implements ISpecification<T>{

  @Override
  public ISpecification and(ISpecification specification) {
    return new AndSpecification<>(this,specification);
  }

  @Override
  public ISpecification or(ISpecification specification) {
    return new OrSpecification<>(this,specification);
  }

  @Override
  public ISpecification not(ISpecification specification) {
    return new NotSpecification<>(this,specification);
  }

}
