package com.abc.controller;


import com.abc.common.Res;


import com.abc.common.SpringIOC;
import com.abc.dao.entity.Emp;
import com.abc.service.iservice.IEmpService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmpFindByDeptServlet ",urlPatterns = {"/empbydept"})
public class EmpFindByDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int deptno=Integer.parseInt(request.getParameter("deptno"));
        IEmpService empService= (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
       Res<List<Emp>> result=empService.findByDept(deptno);
        PrintWriter out = response.getWriter();
        out.println(JSON.toJSONString(result));
        out.close();
    }

}
