package com.example.newboard.mapper;

import com.example.newboard.DTO.PageRequestDTO;
import com.example.newboard.DTO.PageResponseDTO;
import com.example.newboard.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ArticleMapperTest {
    @Autowired
    ArticleMapper articleMapper;
    @Test
    void selectAllForPaging() {

//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//
//                .build();
//
//        List<Article> articleList =articleMapper.selectAllForPaging(pageRequestDTO);
//        articleList.forEach(article -> log.info(String.valueOf(article)));

        int end = (int) (Math.ceil(1 / 10.0)) * 10;


//        int last = (int) (Math.ceil(total/ (double)size));
//
//        this.end = end > last ? last : end;

//        log.info(String.valueOf(start));
        log.info(String.valueOf(end));
    }


    @Test
    void getCount() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        int i =articleMapper.getCount(pageRequestDTO);
        log.info(String.valueOf(i));
    }
}