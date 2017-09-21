package com.common.system.service.impl;

import com.common.system.entity.RcMenu;
import com.common.system.entity.TSDepart;
import com.common.system.entity.ZTreeNode;
import com.common.system.service.MenuService;
import com.common.system.service.TSDepartService;
import com.common.system.service.ZTreeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/8/7.
 * Time:14:04
 * ProjectName:Common-admin
 */
@Service
public class ZTreeServiceImpl implements ZTreeService {

    private static final Log LOG = LogFactory.getLog(ZTreeServiceImpl.class);

    @Autowired
    private MenuService menuService;

    @Autowired
    private TSDepartService tsDepartService;

    @Override
    public List<ZTreeNode> getMenuZTreeNodes() {
        List<RcMenu> list = menuService.getMenu();
        List<ZTreeNode> zTreeNodeList = new ArrayList();
        for (RcMenu menu:list
                ) {
            ZTreeNode node = new ZTreeNode();
            node.setId(menu.getId());
            node.setName(menu.getName());
            node.setpId(menu.getpId());
            node.setCode(menu.getCode());
            node.setLevel(menu.getLevel());
            if (menu.getLevel()==2){
                node.setOpen(false);
            }
            zTreeNodeList.add(node);
        }
        return zTreeNodeList;
    }

    @Override
    public String buildZTree(List<ZTreeNode> zTreeNodeList) {
        ObjectMapper objectMapper = new ObjectMapper();
        String str = null;
        try {
            str = objectMapper.writeValueAsString(zTreeNodeList);
            LOG.info(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public List<ZTreeNode> getRegionZTreeNodes() {
        List<TSDepart> list = tsDepartService.getMenu();
        List<ZTreeNode> zTreeNodeList = new ArrayList();
        for (TSDepart tsDepart:list
                ) {
            ZTreeNode node = new ZTreeNode();
            node.setId(tsDepart.getId());
            node.setName(tsDepart.getDepartname());
            node.setpId(tsDepart.getParentdepartid());
//            node.setCode(tsDepart.getCode());
            node.setLevel(Integer.parseInt(tsDepart.getOrgType()));
            if (Integer.parseInt(tsDepart.getOrgType())==6){
                node.setOpen(false);
            }
            zTreeNodeList.add(node);
        }
        return zTreeNodeList;
    }
}
