package ddd.tenancy.tenancy.controller.http.houseadd;

import com.google.common.base.Preconditions;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import ddd.base.domain.Application;
import ddd.tenancy.tenancy.api.common.OutErrorEnum;
import ddd.tenancy.tenancy.api.hoursingresources.dto.HoursingAddRequestDTO;
import ddd.tenancy.tenancy.api.hoursingresources.dto.HoursingAddResponseDTO;
import ddd.tenancy.tenancy.common.exception.ExceptionCatcher;

/**
 * 标准 房源添加流程
 * date Jun 4, 2019 12:44:25 PM
 */
@RestController
@RequestMapping("/tenancy/housingAdd2")
public class HousingAddRestController {

  @Resource
  private Application<HoursingAddRequestDTO, HoursingAddResponseDTO> houseAddApplication;

  /**
   * 添加房源
   * @param request
   * @return
   */
  @PostMapping("add")
  public HoursingAddResponseDTO addHousing(HoursingAddRequestDTO request) {

    return ExceptionCatcher.process(HoursingAddResponseDTO.class,this, request, () -> {
      Preconditions.checkArgument(null != request, OutErrorEnum.PAYAMS_ERROR.getMessage());
      HoursingAddResponseDTO
          hoursingAddResponse = houseAddApplication.doAction(request);
      return hoursingAddResponse;
    });

  }
}
