package com.bs.spring.common;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringToArrayTypeHandler implements TypeHandler<String[]> {

    @Override
    public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
        if (parameter != null) {
            ps.setString(i, String.join(",", parameter));
        }else {
            ps.setString(i, null);
        }
    }

    @Override
    public String[] getResult(ResultSet rs, String columnName) throws SQLException {
        // TODO Auto-generated method stub

        return rs.getString(columnName)!=null?rs.getString(columnName).split(","):null;
    }

    @Override
    public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return rs.getString(columnIndex)!=null?rs.getString(columnIndex).split(","):null;
    }

    @Override
    public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
