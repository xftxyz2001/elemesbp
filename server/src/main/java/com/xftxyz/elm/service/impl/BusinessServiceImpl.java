package com.xftxyz.elm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Business;
import com.xftxyz.elm.mapper.BusinessMapper;
import com.xftxyz.elm.service.BusinessService;

/**
 * @author 25810
 * @description 针对表【business】的数据库操作Service实现
 * @createDate 2023-06-15 16:16:07
 */
@Service
@Transactional
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business>
        implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<Business> findBusinessByOrdertypeid(Integer ordertypeid) {
        return businessMapper.selectAllByOrdertypeid(ordertypeid);
    }

    @Override
    public List<Business> findBusinessByBusinessname(String businessname) {
        return businessMapper.selectAllByBusinessnameLike(businessname);
    }

    @Override
    public List<Business> findBusinessByBusinesaddress(String businessaddress) {
        return businessMapper.selectAllByBusinessaddressLike(businessaddress);
    }
}
