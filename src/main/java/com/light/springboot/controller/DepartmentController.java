package com.light.springboot.controller;

import com.google.common.collect.Maps;
import com.light.springboot.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.light.springboot.service.DepartmentService;

import java.util.Map;

/**
 * @descrption:
 * @author: bubbles
 */
@RestController
@RequestMapping("/department/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("add")
    public Map<String, Object> add(Department department) {
        departmentService.save(department);
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", "200");
        map.put("msg", "保存成功。");
        return map;
    }

    @RequestMapping("update")
    public Map<String, Object> update(Department department) {
        departmentService.update(department);
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", "200");
        map.put("msg", "保存成功。");
        return map;
    }

    @RequestMapping("{id}/get")
    public Map<String,Object> get(@PathVariable(value="id") Integer id){
        System.out.println("controller查询1 id=" + id + " 的数据。");
        Department department = departmentService.get(id);
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", "200");
        map.put("msg", "查询成功。");
        map.put("data", department);
        System.out.println("controller查询2 id=" + id + " 的数据。");
        return map;
    }

    @RequestMapping("{id}/delete")
    public Map<String,Object> delete(@PathVariable(value = "id") Integer id){
        departmentService.delete(id);
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", "200");
        map.put("msg", "删除成功。");
        return map;
    }

}
















