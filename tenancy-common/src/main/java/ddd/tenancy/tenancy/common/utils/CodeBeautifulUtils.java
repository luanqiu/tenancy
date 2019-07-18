package ddd.tenancy.tenancy.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 帮助代码更好看
 * author  wenhe
 * date 2019/7/18
 */
public class CodeBeautifulUtils {

  /**
   * 如果是 null ，返回 ""
   */
  public static final String ifNullThenEmpty(Object sourceStr) {
    return null == sourceStr ? "" : StringUtils.isBlank(sourceStr.toString()) ? "" :
                                    sourceStr.toString();
  }

}
