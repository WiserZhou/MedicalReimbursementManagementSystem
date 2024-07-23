package edu.hitwh.homework.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DeptMapper接口实现类的测试
 *
 * write by Jerry Xin
 * 2024.4.18
 */
@SpringBootTest
class DeptMapperTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    void list() {
        List<Dept> list = deptMapper.list();
        list.forEach(System.out::println);
    }


    @Test
    void add() {
        Dept dept = new Dept();
        dept.setName("外联部");
        dept.setUpdateTime(LocalDateTime.now());
        dept.setCreateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Test
    void selectById() {
        Dept dept = deptMapper.selectById(10);
        System.out.println(dept);
    }

    @Test
    void delete() {
        deptMapper.delete(10);
    }


    @Test
    void update() {
        Dept dept = deptMapper.selectById(11);
        dept.setName("特情部");
        deptMapper.update(dept);
    }
}