package com.common.system.service;

import com.common.system.entity.RcMenu;
import com.common.system.entity.TSDepart;

import java.util.List;

/**
 * Created by yeqing on 2017/9/19.
 */
public interface TSDepartService {

    TSDepart selectByPrimaryKey(String id);
    List<TSDepart> getByparentdepartid(String parentdepartid);
    List<TSDepart> getMenu();

}
