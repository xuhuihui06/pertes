package com.kingduns.pertes.common.mapper;

import com.kingduns.pertes.common.bean.Record;

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

public interface RecordMapper {
    @Delete({
        "delete from record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into record (id, create_time, ",
        "operation)",
        "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{operation,jdbcType=VARCHAR})"
    })
    int insert(Record record);

    @InsertProvider(type=RecordSqlProvider.class, method="insertSelective")
    int insertSelective(Record record);

    @Select({
        "select",
        "id, create_time, operation",
        "from record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="operation", property="operation", jdbcType=JdbcType.VARCHAR)
    })
    Record selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Record record);

    @Update({
        "update record",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "operation = #{operation,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Record record);
    
    @Select({
        "select",
        "id, create_time, operation",
        "from record",
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="operation", property="operation", jdbcType=JdbcType.VARCHAR)
    })
    List<Record> queryRecordList();
}