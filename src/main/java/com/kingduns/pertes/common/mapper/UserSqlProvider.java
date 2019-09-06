package com.kingduns.pertes.common.mapper;

import com.kingduns.pertes.common.bean.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountNum() != null) {
            sql.VALUES("account_num", "#{accountNum,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMail() != null) {
            sql.VALUES("mail", "#{mail,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkUnit() != null) {
            sql.VALUES("work_unit", "#{workUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getIsMember() != null) {
            sql.VALUES("is_member", "#{isMember,jdbcType=INTEGER}");
        }
        
        if (record.getMaxManageNum() != null) {
            sql.VALUES("max_manage_num", "#{maxManageNum,jdbcType=INTEGER}");
        }
        
        if (record.getDelflg() != null) {
            sql.VALUES("delflg", "#{delflg,jdbcType=INTEGER}");
        }
        
        if (record.getCreTime() != null) {
            sql.VALUES("cre_time", "#{creTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getAccountNum() != null) {
            sql.SET("account_num = #{accountNum,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMail() != null) {
            sql.SET("mail = #{mail,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkUnit() != null) {
            sql.SET("work_unit = #{workUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getIsMember() != null) {
            sql.SET("is_member = #{isMember,jdbcType=INTEGER}");
        }
        
        if (record.getMaxManageNum() != null) {
            sql.SET("max_manage_num = #{maxManageNum,jdbcType=INTEGER}");
        }
        
        if (record.getDelflg() != null) {
            sql.SET("delflg = #{delflg,jdbcType=INTEGER}");
        }
        
        if (record.getCreTime() != null) {
            sql.SET("cre_time = #{creTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}