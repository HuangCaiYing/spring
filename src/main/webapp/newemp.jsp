
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增员工信息</title>
</head>
<body>
     <form action="${pageContext.request.contextPath}/empsave"  method="post" >
         <table>
             <tr>
                 <td>员工姓名</td>
                 <td><input type="text" name="ename" value="emp1001"></td>
             </tr>
             <tr>
                 <td>入职日期</td>
                 <td><input type="text" name="hiredate" value="2020-01-01"></td>
             </tr>
             <tr>
                 <td>薪资</td>
                 <td><input type="text" name="sal" value="5658"></td>
             </tr>
             <tr>
                 <td><input type="submit" value="新增"></td>
                 <td><input type="reset" value="重置"></td>
             </tr>
         </table>
     </form>
</body>
</html>
