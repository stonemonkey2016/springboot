package com.light.springboot;

import com.light.springboot.domain.Department;
import com.light.springboot.mapper.MongodbDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @descrption:
 * @author: bubbles
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbDaoTest {

    @Autowired
    private MongodbDao mongodbDao;

    @Test
    public void testInsert() {
        for (int i = 2; i < 7; i++) {
            Department department = new Department();
            department.setId(i);
            department.setName("测试部门" + i);
            department.setDescr("java web 测试 " + i);
            this.mongodbDao.insert(department);
        }
    }

    @Test
    public void testUpdate() {
        Department department = new Department();
        department.setId(1);
        department.setName("测试部门");
        department.setDescr("java web 测试 update");
        this.mongodbDao.update(department);
    }

    @Test
    public void getAll() {
        List<Department> list = this.mongodbDao.getAll();
        System.out.println(list.size());
        for (Department d : list) {
            System.out.println(d.getId() + "-->" + d.getName() + "-->" + d.getDescr());
        }
    }

}
