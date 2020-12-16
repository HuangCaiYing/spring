package com.abc.dao.factory;

import com.abc.common.Comm;
import com.abc.dao.impl.DeptDaoImpl;
import com.abc.dao.impl.EmpDaoImpl;
import com.abc.dao.impl.ReportDeptEmpDaoImpl;
import com.abc.dao.impl.UserDeoImpl;

public class DaoFactory {
    public static Object getInstance(String daoName){
        switch(daoName){
            case Comm.USER:
                return new UserDeoImpl();
            case Comm.EMP:
                return new EmpDaoImpl();
            case Comm.DEPT:
                return new DeptDaoImpl();
            case Comm.DEPT_EMP_REPORT:
                return new ReportDeptEmpDaoImpl();
            default:
                return null;
        }
    }
}
//    public static Object getInstance(String deoName){
//        if (Comm.USER.equals(deoName)) {
//            return  new UserDeoImpl();
//        }
//        return null;
//    }