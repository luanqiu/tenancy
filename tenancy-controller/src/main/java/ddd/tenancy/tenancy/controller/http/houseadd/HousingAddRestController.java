package ddd.tenancy.tenancy.controller.http.houseadd;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import javax.annotation.Resource;

import ddd.base.domain.Application;
import ddd.tenancy.tenancy.api.common.OutErrorEnum;
import ddd.tenancy.tenancy.api.hoursingresources.dto.HoursingAddRequestDTO;
import ddd.tenancy.tenancy.api.hoursingresources.dto.HoursingAddResponseDTO;
import ddd.tenancy.tenancy.api.hoursingresources.dto.HoursingAddress;
import ddd.tenancy.tenancy.common.exception.ExceptionCatcher;
import ddd.tenancy.tenancy.common.utils.CodeBeautifulUtils;

/**
 * 房源添加流程
 * 我们的上游可能是前端，也可能是三方系统，所以
 * controller 层会有一些转化
 * date Jun 4, 2019 12:44:25 PM
 */
@RestController
@RequestMapping("/tenancy/housingAdd")
public class HousingAddRestController {

  @Resource
  private Application<HoursingAddRequestDTO, HoursingAddResponseDTO> houseAddApplication;

  /**
   * 比如自如和链家签订了合作 链家会把房源信息自动传给自如，但必须按照链家目前已有的协议 协议的字段大概如下：
   * {"address":{"country":"中国","province":"浙江省","city":"杭州市","detailedAddress":"武林壹号2幢1801室","county":"西湖区"},"propertyName":"绿城","proprietorId":"34253787878784****ee23","propertyFee":"7","proprietorName":"狗蛋"}
   */
  public String addHousing(String request) {

    ExceptionCatcher.process(this, request, () -> {
      Preconditions.checkArgument(StringUtils.isNotBlank(request), OutErrorEnum.PAYAMS_ERROR.getMessage());
      HoursingAddRequestDTO hoursingAddRequest = buildHoursingAddRequestByString(request);
      HoursingAddResponseDTO
          hoursingAddResponse = houseAddApplication.doAction(hoursingAddRequest);

      // 这里可能需要转化成业务方需要的成功格式
      return JSON.toJSONString(hoursingAddResponse);
    });
    // 这里可能需要转化成业务方需要的失败格式
    return null;
  }

  private HoursingAddRequestDTO buildHoursingAddRequestByString(String request) {
    Map<String,Object> requestMap = JSON.parseObject(request,Map.class);
    Map<String,String> hoursingAddressMap = Maps.newHashMap();

    HoursingAddRequestDTO requestDTO = new HoursingAddRequestDTO();
    HoursingAddress hoursingAddress = new HoursingAddress();
    hoursingAddress.setCounty(hoursingAddressMap.get("country"));
    hoursingAddress.setProvince(hoursingAddressMap.get("province"));
    hoursingAddress.setCity(hoursingAddressMap.get("city"));
    hoursingAddress.setCounty(hoursingAddressMap.get("county"));
    hoursingAddress.setDetailedAddress(hoursingAddressMap.get("detailedAddress"));

    requestDTO.setHoursingAddress(hoursingAddress);
    requestDTO.setProprietorId(
        CodeBeautifulUtils.ifNullThenEmpty(requestMap.get("proprietorId")));
    requestDTO.setProprietorName(CodeBeautifulUtils.ifNullThenEmpty(requestMap.get("proprietorName")));
    requestDTO.setPropertyName(CodeBeautifulUtils.ifNullThenEmpty(requestMap.get("propertyName")));
    requestDTO.setPropertyFee(CodeBeautifulUtils.ifNullThenEmpty(requestMap.get("propertyFee")));
    return requestDTO;
  }

}
