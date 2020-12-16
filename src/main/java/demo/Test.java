package demo;

import com.abc.dao.util.DBUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;

//JAVA 调用存储过程
public class Test {
    public static void main(String[] args) throws Exception {
        Connection con= DBUtil.getConnection();
        String sql="call proc_transfer_money(?,?,?)";
        CallableStatement cs=con.prepareCall(sql);
        cs.setString(1,"SCOTT");
        cs.setString(2,"KING");
        cs.setBigDecimal(3,new BigDecimal("200"));
        cs.executeUpdate();
        DBUtil.close(null,cs,con);
    }
}
