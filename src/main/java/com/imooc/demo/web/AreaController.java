package com.imooc.demo.web;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 区域信息Controller层
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    /**
     * 展示区域列表
     *
     * @return 区域列表list
     */
    @GetMapping("/listarea")
    public Map<String, Object> listArea() {
        List<Area> areas = areaService.queryArea();
        HashMap<String, Object> map = new HashMap<>();
        map.put("areaList", areas);
        return map;
    }

    /**
     * 获取特定区域信息
     *
     * @param id 区域id
     * @return 区域信息
     */
    @PostMapping("getareabyid")
    public Map<String, Object> getAreaById(Integer id) {
        Area area = areaService.queryAreaById(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("area", area);
        return map;
    }

    /**
     * 移除特定区域信息(数据库直接删除)
     *
     * @param areaId
     * @return
     */
    @GetMapping("removearea")
    public Map<String, Object> removeArea(Integer areaId) {
        areaService.deleteArea(areaId);
        HashMap<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", true);
        return modelMap;
    }

    /**
     * 修改区域信息
     *
     * @param area
     * @return
     */
    @GetMapping("modifyarea")
    public Map<String, Object> modifyArea(@RequestBody Area area) {
        areaService.updateArea(area);
        HashMap<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", true);
        return modelMap;
    }

    /**
     * 添加区域信息
     *
     * @param area
     * @return
     */
    @PostMapping("addarea")
    public Map<String, Object> addArea(@RequestBody Area area) {
        areaService.insertArea(area);
        HashMap<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", true);
        return modelMap;
    }

}
