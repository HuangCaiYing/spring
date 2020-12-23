package com.abc.dao;

import com.abc.dao.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmpDaoTest {

    @Autowired
    EmpDao empDao;
    @Test
    public void findByPage() {
        empDao.findByPage(1,2).forEach(System.out::println);
    }

    @Test
    public void findByName() {
        empDao.findByName("A").forEach(System.out::println);
    }

    @Test
    public void findById() {
        System.out.println(empDao.findById(3));
    }

    @Test
    public void delete() {
     Emp emp=new Emp();
     System.out.println(empDao.delete(emp));
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findByDept() {
        empDao.findByDept(2).forEach(System.out::println);
    }

    @Test
    public void delBatch(){
        System.out.println(empDao.delBatch((Arrays.asList(12,13,14))));
        findByPage();
    }
    @Test
    public void dynamicUpdate(){
        Emp emp=new Emp();
        emp.setEmpno(6);
        emp.setEname("WUWU");
        empDao.dynamicUpdate(emp);
    }

    @Test
    public void saveBatch(){
        List<Emp> emps=Arrays.asList(
                new Emp("empno1001",new Date(),new BigDecimal("12345")),
                new Emp("empno1002",new Date(),new BigDecimal("56123")),
                new Emp("empno1003",new Date(),new BigDecimal("20000")),
                new Emp("empno1004",new Date(),new BigDecimal("23022"))
        );
        empDao.saveBatch(emps);
    }

    @Test
    public void findByCon() throws ParseException {
        Date hiredate=new SimpleDateFormat("yyyy-MM-dd").parse("1998-01-01");
        empDao.findByCon("U",hiredate,new BigDecimal("3000")).forEach(System.out::println);
        empDao.findByCon(null,hiredate,new BigDecimal("3000")).forEach(System.out::println);
        empDao.findByCon(null,null,new BigDecimal("3000")).forEach(System.out::println);
        empDao.findByCon(null,null,null).forEach(System.out::println);
    }
}