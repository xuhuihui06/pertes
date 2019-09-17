package com.kingduns.pertes.common.mapper;

import com.kingduns.pertes.common.bean.Record;
import org.apache.ibatis.jdbc.SQL;

public class RecordSqlProvider {

    public String insertSelective(Record record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("record");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperation() != null) {
            sql.VALUES("operation", "#{operation,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Record record) {
        SQL sql = new SQL();
        sql.UPDATE("record");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperation() != null) {
            sql.SET("operation = #{operation,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}