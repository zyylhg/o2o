package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.AreaDao;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
//	@Autowired
//	private JedisUtil.Strings jedisStrings;
//	@Autowired
//	private JedisUtil.Keys jedisKeys;
	@Autowired
	private AreaDao areaDao;

	private static String AREALISTKEY = "arealist";

	@Override
	public List<Area> getAreaList() {
		List<Area> areaList = areaDao.queryArea();
		return areaList;
	}


}
