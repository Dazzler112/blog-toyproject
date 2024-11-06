package com.toyblog.blog_toyproject.basic;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.type.*;

@MappedTypes(List.class)
public class StringListTypeHandler extends BaseTypeHandler<List<String>>{

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
    	ps.setString(i, String.join(",", parameter)); // List<String>을 콤마로 연결해 String으로 저장
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String result = rs.getString(columnName);
        return result != null ? Arrays.asList(result.split(",")) : Collections.emptyList(); // String을 List<String>으로 변환
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = rs.getString(columnIndex);
        return result != null ? Arrays.asList(result.split(",")) : Collections.emptyList();
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        return result != null ? Arrays.asList(result.split(",")) : Collections.emptyList();
    }
}
