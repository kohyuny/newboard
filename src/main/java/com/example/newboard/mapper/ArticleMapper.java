package com.example.newboard.mapper;

import com.example.newboard.DTO.PageRequestDTO;
import com.example.newboard.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Select("select * from article")
    List<Article> selectAll();
    @Select("select * from article where id = #{id}")
    Article selectOne(int id);
    @Insert("insert into article (userid, title, content, regdate, cnt) values(#{article.userid}, #{article.title}," +
            "#{article.content},#{article.regdate},#{article.cnt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("article")Article article);
    @Update("update article set userid = #{article.userid}, title = #{article.title}, " +
            "content= #{article.content}, moddate = #{article.moddate}, cnt = #{article.cnt} where id = #{article.id}")
    int update(@Param("article")Article article);
    @Delete("delete from article where id = #{id}")
    int delete(int id);

    List<Article> selectAllForPaging(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);

}
