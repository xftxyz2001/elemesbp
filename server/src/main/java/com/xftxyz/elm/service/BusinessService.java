package com.xftxyz.elm.service;

import com.xftxyz.elm.domain.Business;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 25810
* @description 针对表【business】的数据库操作Service
* @createDate 2023-06-15 16:16:07
*/
public interface BusinessService extends IService<Business> {

    List<Business> findBusinessByOrdertypeid(Integer ordertypeid);
}
