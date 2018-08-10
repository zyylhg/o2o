package com.imooc.o2o.web.superadmin;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.ConstantForSuperAdmin;
import com.imooc.o2o.service.AreaService;
import com.mangofactory.swagger.annotations.ApiIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listareas",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap=new HashMap<>();
        List<Area> list=new ArrayList<>();
        try {
            list=areaService.getAreaList();
            modelMap.put(ConstantForSuperAdmin.PAGE_SIZE,list);
            modelMap.put(ConstantForSuperAdmin.TOTAL,list.size());
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
        }
        return modelMap;
    }
}
