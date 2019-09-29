package com.kingduns.pertes.common.mapper;

import com.kingduns.pertes.common.bean.Iteration;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface IterationMapper {
    @Delete({
        "delete from iteration",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into iteration (id, name, ",
        "pid)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{pid,jdbcType=INTEGER})"
    })
    int insert(Iteration record);

    @InsertProvider(type=IterationSqlProvider.class, method="insertSelective")
    int insertSelective(Iteration record);

    @Select({
        "select",
        "id, name, pid",
        "from iteration",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER)
    })
    Iteration selectByPrimaryKey(Integer id);

    @UpdateProvider(type=IterationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iteration record);

    @Update({
        "update iteration",
        "set name = #{name,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Iteration record);
    
    @Select({
    	"select i1.name, i2.name as pname",
    	"from iteration as i1",
    	"left join iteration as i2",
    	"on i1.pid = i2.id",
    })
    @Results({
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="pname", property="pName", jdbcType=JdbcType.VARCHAR)
    })
    List<Iteration> queryIterationList();
}