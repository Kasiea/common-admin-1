package com.common.system.service.impl;

import com.common.system.entity.RcUserRegion;
import com.common.system.entity.RcUserRegionExample;
import com.common.system.mapper.RcUserRegionMapper;
import com.common.system.service.RcUserRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yeqing on 2017/9/21.
 */
@Service
public class RcUserRegionServiceImpl implements RcUserRegionService{
    @Autowired
    private RcUserRegionMapper rcUserRegionMapper;

    @Override
    public int add(RcUserRegion rcUserRegion) {
        return rcUserRegionMapper.insert(rcUserRegion);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return rcUserRegionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByUserId(RcUserRegion record,Integer userId) {
        RcUserRegionExample rcUserRegionExample = new RcUserRegionExample();
        RcUserRegionExample.Criteria criteria = rcUserRegionExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return rcUserRegionMapper.updateByExample(record,rcUserRegionExample);
    }

    @Override
    public int updateByPrimaryKey(RcUserRegion record) {
        return rcUserRegionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByUserId(Integer userId) {
        RcUserRegionExample rcUserRegionExample = new RcUserRegionExample();
        RcUserRegionExample.Criteria criteria = rcUserRegionExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return rcUserRegionMapper.deleteByExample(rcUserRegionExample);
    }

    @Override
    public List<RcUserRegion> getByUserId(Integer userId) {
        RcUserRegionExample rcUserRegionExample = new RcUserRegionExample();
        RcUserRegionExample.Criteria criteria = rcUserRegionExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return rcUserRegionMapper.selectByExample(rcUserRegionExample);
    }
}
