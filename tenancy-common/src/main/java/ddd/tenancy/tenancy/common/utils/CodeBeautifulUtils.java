package ddd.tenancy.tenancy.common.utils;

import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

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

  /**
   * tags 可以设置成 20 位的二进制，前 0～5 位是业务1专用，5～10 是业务2专用等等
   * 二进制是看不懂的，方便保存落库。
   * 转化的 Map 是看得懂的，方便业务逻辑计算。
   * @param tags
   * @return
   */
  public static Map<String,Boolean> convertTagsIntToMap(Long tags) {
    Map map =  Maps.newHashMap();
    map.put("房源有安全隐患",true);
    return map;
  }

  public static Long convertTagsMapToInt(Map<String, Boolean> tags) {
    return 1890893443L;
  }
}
