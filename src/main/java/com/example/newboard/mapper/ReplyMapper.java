package com.example.newboard.mapper;

import com.example.newboard.entity.Reply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyMapper {
    @Select("select * from reply where id = #{id}")
    List<Reply> selectAll(int id);
    @Insert("insert into reply (id, userid, content, regdate) values(#{reply.id}, #{reply.userid}, #{reply.content}, #{reply.regdate})")
    int insert(@Param("reply")Reply reply);
    @Delete("delete from reply where rid =#{rid}")
    int delete(int rid);


}
