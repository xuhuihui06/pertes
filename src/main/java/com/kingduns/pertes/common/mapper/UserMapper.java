package com.kingduns.pertes.common.mapper;

import com.kingduns.pertes.common.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into user (id, account_num, ",
        "password, user_name, ",
        "phone, mail, work_unit, ",
        "is_member, max_manage_num, ",
        "delflg, cre_time)",
        "values (#{id,jdbcType=VARCHAR}, #{accountNum,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{mail,jdbcType=VARCHAR}, #{workUnit,jdbcType=VARCHAR}, ",
        "#{isMember,jdbcType=INTEGER}, #{maxManageNum,jdbcType=INTEGER}, ",
        "#{delflg,jdbcType=INTEGER}, #{creTime,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertSelective(User record);

    @Select({
        "select",
        "id, account_num, password, user_name, phone, mail, work_unit, is_member, max_manage_num, ",
        "delflg, cre_time",
        "from user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="account_num", property="accountNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail", property="mail", jdbcType=JdbcType.VARCHAR),
        @Result(column="work_unit", property="workUnit", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_member", property="isMember", jdbcType=JdbcType.INTEGER),
        @Result(column="max_manage_num", property="maxManageNum", jdbcType=JdbcType.INTEGER),
        @Result(column="delflg", property="delflg", jdbcType=JdbcType.INTEGER),
        @Result(column="cre_time", property="creTime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(String id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set account_num = #{accountNum,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "mail = #{mail,jdbcType=VARCHAR},",
          "work_unit = #{workUnit,jdbcType=VARCHAR},",
          "is_member = #{isMember,jdbcType=INTEGER},",
          "max_manage_num = #{maxManageNum,jdbcType=INTEGER},",
          "delflg = #{delflg,jdbcType=INTEGER},",
          "cre_time = #{creTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
    
    /**
     *	 根据账号密码查询用户信息
     * @param accountNumber 账号
     * @param passWord 密码
     * @return 用户信息
     */
    @Select({
        "select",
        "account_num, password, user_name, phone, mail, work_unit, is_member, max_manage_num, cre_time",
        "from user",
        "where account_num = #{accountNumber} and password = #{passWord}"
    })
    @Results({
        @Result(column="account_num", property="accountNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail", property="mail", jdbcType=JdbcType.VARCHAR),
        @Result(column="work_unit", property="workUnit", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_member", property="isMember", jdbcType=JdbcType.INTEGER),
        @Result(column="max_manage_num", property="maxManageNum", jdbcType=JdbcType.INTEGER)
    })
    User queryUserByAccountNumberAndPassWord(@Param("accountNumber") String accountNumber, @Param("passWord") String passWord);
    
    /**
     *	 根据账号查询用户信息
     * @param accountNumber 账号
     * @return 用户信息
     */
    @Select({
        "select",
        "account_num, password, user_name, phone, mail, work_unit, is_member, max_manage_num, cre_time",
        "from user",
        "where account_num = #{accountNumber}"
    })
    @Results({
        @Result(column="account_num", property="accountNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail", property="mail", jdbcType=JdbcType.VARCHAR),
        @Result(column="work_unit", property="workUnit", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_member", property="isMember", jdbcType=JdbcType.INTEGER),
        @Result(column="max_manage_num", property="maxManageNum", jdbcType=JdbcType.INTEGER)
    })
    User queryUserByAccountNumber(@Param("accountNumber") String accountNumber);
}