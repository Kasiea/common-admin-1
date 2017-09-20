package com.common.system.mapper;

import com.common.system.entity.TSDepart;
import com.common.system.entity.TSDepartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSDepartMapper {
    int deleteByExample(TSDepartExample example);

    int deleteByPrimaryKey(String id);

    int insert(TSDepart record);

    int insertSelective(TSDepart record);

    List<TSDepart> selectByExampleWithBLOBs(TSDepartExample example);

    List<TSDepart> selectByExample(TSDepartExample example);

    TSDepart selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TSDepart record, @Param("example") TSDepartExample example);

    int updateByExampleWithBLOBs(@Param("record") TSDepart record, @Param("example") TSDepartExample example);

    int updateByExample(@Param("record") TSDepart record, @Param("example") TSDepartExample example);

    int updateByPrimaryKeySelective(TSDepart record);

    int updateByPrimaryKeyWithBLOBs(TSDepart record);

    int updateByPrimaryKey(TSDepart record);
}