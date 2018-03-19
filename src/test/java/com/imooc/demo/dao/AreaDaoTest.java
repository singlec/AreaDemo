package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;
    @Test
    @Ignore
    public void queryArea() {
        List<Area> areas = areaDao.queryArea();
        assertEquals(2,areas.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        Integer areaId = area.getAreaId();
        assertEquals(1,areaId.intValue());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setCreateTime(new Date());
        area.setLastUpdateTime(new Date());
        area.setPriority(2);
        int i = areaDao.insertArea(area);
        assertEquals(1,i);
    }

    @Test
    @Ignore
    public void updateArea() {
        Area area = areaDao.queryAreaById(1);
        area.setPriority(5);
        areaDao.updateArea(area);
    }

    @Test
//    @Ignore
    public void deleteArea() {
        int i = areaDao.deleteArea(1);
        assertEquals(1,i);
    }
}