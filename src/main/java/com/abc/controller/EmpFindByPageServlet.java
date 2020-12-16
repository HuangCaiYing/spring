package com.abc.controller;

import com.abc.common.Comm;
import com.abc.dao.entity.Emp;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/EmpFindByPageServlet", urlPatterns = {"/empbypage"})
public class EmpFindByPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute(Comm.CURRENT_USER) == null){
            session.setAttribute("errMsg","请先登录");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
        int page = 1;
        int size = 10;
        String pageParam = request.getParameter("page");
        String sizeParam = request.getParameter("size");
        //如果pageParam满足不等于空值，并且去掉空格也不等于空的情况下执行语句
        if (pageParam != null && !"".equals(pageParam.trim())) {
            page = Integer.parseInt(pageParam);
        }
        if (sizeParam != null && !"".equals(sizeParam.trim())) {
            size = Integer.parseInt(sizeParam);
        }
        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        List<Emp> emps = empService.findByPage(page, size);
        //反馈--JAVA模板引擎 因为运行的是jsp页面，所以反馈要用JAVA模板引擎（直接传参，直接处理）
        //如果emps不等于空，并且emps.size()>0，说明集合里面有数据
        if (emps != null && emps.size() > 0) {
            request.setAttribute("empsFromServer", emps);
            request.getRequestDispatcher("/emps.jsp").forward(request, response);
        } else {
            session.setAttribute("errMsg", "分页查询失败");
            //request.getContextPath()代表localhost:8080
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

}
