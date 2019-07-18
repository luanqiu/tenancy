package ddd.tenancy.tenancy.common.utils;


import net.sf.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 数据模型转换工具
 *
 * @author hupp create date: 17/5/4
 */
public class BeanCopierUtils {

  /**
   * 缓存转换过的bean
   */
  private final static Map<String, BeanCopier> beanCopierMap = new HashMap<>();

  /**
   * bean属性转换
   * @param source
   * @param target
   */
  public static void copyProperties(Object source,Object target) {
    String beanKey = generateKey(source.getClass(), target.getClass());
    BeanCopier copier;
    if (!beanCopierMap.containsKey(beanKey)) {
      copier = BeanCopier.create(source.getClass(), target.getClass(), false);
      beanCopierMap.put(beanKey, copier);
    } else {
      copier = beanCopierMap.get(beanKey);
    }
    copier.copy(source, target, null);
  }

  /**
   * Assume the parameterized type has a non-arg constructor.
   * Otherwise, {@link InstantiationException} will be thrown.
   */
  public static <T> void copyList(List<T> sourceList, List<T> targetList, Class<T> tClass) {
    for (T source : sourceList) {
      T target;
      try {
        target = tClass.newInstance();
      } catch (ReflectiveOperationException e) {
        throw new RuntimeException(e);
      }
      copyProperties(source, target);
      targetList.add(target);
    }
  }

  private static String generateKey(Class<?>class1, Class<?>class2){
    return class1.toString() + class2.toString();
  }
}
