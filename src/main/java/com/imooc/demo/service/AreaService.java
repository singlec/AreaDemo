package com.imooc.demo.service;

import com.imooc.demo.entity.Area;

import java.util.List;

public interface AreaService {
    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area> queryArea();

    /**
     * 根据areaId获取Area
     * @return area
     */
    Area queryAreaById(int id);

    /**
     * 插入一条区域信息
     * @param area
     * @return 成功条数
     */
    boolean insertArea(Area area);

    /**
     * 更新一条区域信息
     * @param area
     * @return 更新条数
     */
    boolean updateArea(Area area);

    /**
     * 删除区域信息
     * @return area
     */
    boolean deleteArea(int id);
}
