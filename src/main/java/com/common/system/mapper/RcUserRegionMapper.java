package com.common.system.mapper;

import com.common.system.entity.RcUserRegion;
import com.common.system.entity.RcUserRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RcUserRegionMapper {
    int deleteByExample(RcUserRegionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RcUserRegion record);

    int insertSelective(RcUserRegion record);

    List<RcUserRegion> selectByExample(RcUserRegionExample example);

    RcUserRegion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RcUserRegion record, @Param("example") RcUserRegionExample example);

    int updateByExample(@Param("record") RcUserRegion record, @Param("example") RcUserRegionExample example);

    int updateByPrimaryKeySelective(RcUserRegion record);

    int updateByPrimaryKey(RcUserRegion record);
}