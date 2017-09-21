package com.common.system.service;

import com.common.system.entity.RcUserRegion;
import java.util.List;

/**
 * Created by yeqing on 2017/9/21.
 */
public interface RcUserRegionService {
    int add(RcUserRegion rcUserRegion);
    int deleteByPrimaryKey(Integer id);
    int updateByUserId(RcUserRegion record,Integer userId);
    int updateByPrimaryKey(RcUserRegion record);
    int deleteByUserId(Integer userId);
    List<RcUserRegion> getByUserId(Integer userId);
}
