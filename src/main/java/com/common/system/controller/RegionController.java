package com.common.system.controller;

import com.common.system.entity.RcPrivilege;
import com.common.system.entity.RcUserRegion;
import com.common.system.service.PrivilegeService;
import com.common.system.service.RcUserRegionService;
import com.common.system.service.TSDepartService;
import com.common.system.util.MsgCode;
import com.common.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by yeqing on 2017/9/21.
 */

@Controller
@RequestMapping(value = "region")
public class RegionController {
    @Autowired
    private RcUserRegionService rcUserRegionService;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public @ResponseBody
    Result save(@RequestParam(required = true) Integer userId, String[] regionId){
        Result result = new Result();
        System.out.println("userId="+userId);
        System.out.println("regionId:"+regionId);
        rcUserRegionService.deleteByUserId(userId);
        if (null != regionId){
            for (String id:regionId) {
                RcUserRegion r = new RcUserRegion();
                r.setUserId(userId);
                r.setRegionId(id);
                r.setCreateTime(new Date());
                rcUserRegionService.add(r);
            }
        }
        result.setStatus(true);
        result.setMsg("操作成功");
        result.setCode(MsgCode.SUCCESS);
        return result;
    }
}
