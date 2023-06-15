package com.xftxyz.elm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Business;
import com.xftxyz.elm.service.BusinessService;
import com.xftxyz.elm.mapper.BusinessMapper;
import org.springframework.stereotype.Service;

/**
* @author 25810
* @description 针对表【business】的数据库操作Service实现
* @createDate 2023-06-15 16:16:07
*/
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business>
    implements BusinessService{

}




