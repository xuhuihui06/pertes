package com.kingduns.pertes.common.mapper;

import com.kingduns.pertes.common.bean.Iteration;
import org.apache.ibatis.jdbc.SQL;

public class IterationSqlProvider {

    public String insertSelective(Iteration record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iteration");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPid() != null) {
            sql.VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iteration record) {
        SQL sql = new SQL();
        sql.UPDATE("iteration");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{pid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}