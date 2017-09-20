package com.common.system.service.impl;

import com.common.system.entity.RcMenu;
import com.common.system.entity.RcMenuExample;
import com.common.system.entity.TSDepart;
import com.common.system.entity.TSDepartExample;
import com.common.system.mapper.TSDepartMapper;
import com.common.system.service.TSDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yeqing on 2017/9/19.
 */
@Service
public class TSDepartServiceImpl implements TSDepartService {

    @Autowired
    private TSDepartMapper tsDepartMapper;

    @Override
    public TSDepart selectByPrimaryKey(String id) {
        return tsDepartMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<TSDepart> getByparentdepartid(String parentdepartid) {
        TSDepartExample example = new TSDepartExample();
        TSDepartExample.Criteria criteria = example.createCriteria();
        criteria.andParentdepartidEqualTo(parentdepartid);
        return tsDepartMapper.selectByExample(example);
    }

    @Override
    public List<TSDepart> getMenu() {
        List<TSDepart> list = tsDepartMapper.selectByExample(new TSDepartExample());
        return list;
    }
}
