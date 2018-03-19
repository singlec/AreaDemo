package com.imooc.demo.service.impl;

import com.imooc.demo.dao.AreaDao;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    public List<Area> queryArea() {
        List<Area> areas = areaDao.queryArea();
        return areas;
    }

    public Area queryAreaById(int id) {
        Area area = areaDao.queryAreaById(id);
        Integer areaId = area.getAreaId();
        return area;
    }

    @Transactional
    public boolean insertArea(Area area) {
        if (!StringUtils.isEmpty(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastUpdateTime(new Date());
            try {
                int effectiveNum = areaDao.insertArea(area);
                if (effectiveNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空");
        }
    }

    public boolean updateArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            try {
                int effectiveNum = areaDao.updateArea(area);
                if (effectiveNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息异常:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不全");
        }
    }

    public boolean deleteArea(int id) {
        if (id > 0) {
            try {
                int effectiveNum = areaDao.deleteArea(id);
                if (effectiveNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息异常:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不全");
        }
    }
}
