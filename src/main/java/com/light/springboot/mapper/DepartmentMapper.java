package com.light.springboot.mapper;

import com.light.springboot.domain.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * @descrption:
 * @author: bubbles
 */
@Mapper
public interface DepartmentMapper {

    public void insert(Department department);

    public Department getById(Integer id);

    public void update(Department department);

    public void deleteById(Integer id);
}
