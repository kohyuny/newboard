package com.example.newboard.service;

import com.example.newboard.DTO.ArticleDTO;
import com.example.newboard.DTO.PageRequestDTO;
import com.example.newboard.DTO.PageResponseDTO;
import com.example.newboard.entity.Article;
import com.example.newboard.mapper.ArticleMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ArticleServiceImpTest {

    @Test
    void selectAll() {
    }

    @Test
    void selectOne() {
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
@Autowired
private ArticleService articleService;

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void selectAllForPaging() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<ArticleDTO> pageResponseDTO = articleService.selectAllForPaging(pageRequestDTO);

        log.info(String.valueOf(pageResponseDTO));
        pageResponseDTO.toString();
//        int count = articleMapper.getCount(pageRequestDTO);
//        System.out.println("count = " + count);
    }
}