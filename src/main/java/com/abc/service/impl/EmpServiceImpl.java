package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;

import com.abc.dao.EmpDao;
import com.abc.service.iservice.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("empService")
public class EmpServiceImpl implements IEmpService {
    @Autowired
    EmpDao empDeo;
    @Override
    public List<Emp> findByPage(int page, int size) {
        List<Emp> emps=null;
        try {
            emps=empDeo.findByPage((page-1)*size,size);
        }catch (Exception e){
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public List<Emp> findByName(String ename) {
        List<Emp> emps = null;
        try {
            emps =empDeo.findByName(ename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public Emp findById(Integer empno) {
        Emp emp = null;
        try {
            emp =empDeo.findById(empno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public String delete(Emp emp) {
        String msg=Comm.ERROR;
        try {
            empDeo.delete(emp);
            msg=Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String save(Emp emp) {
        String msg=Comm.ERROR;
        try {
            empDeo.save(emp);
            msg=Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String update(Emp emp) {
        String msg=Comm.ERROR;
        try {
            empDeo.update(emp);
            msg=Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public Res<List<Emp>> findByDept(int deptno) {
        List<Emp> emps = null;
        try {
            emps =empDeo.findByDept(deptno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (emps != null&& emps.size()>0)?Res.success(ResEnum.SUCCESS,emps):Res.error();
    }

    @Override
    public Res delBatch(List<DelVO> delVOList) {
        if (delVOList==null||delVOList.size()==0){
            return  Res.error(ResEnum.ERROR_PARAMS_IN_DELBATCH);
        }
        try{
            empDeo.delBatch(delVOList);
            return Res.success(ResEnum.SUCCESS_DEL_BATCH);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Res.error();
    }
}



