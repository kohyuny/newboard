package com.example.newboard.service;

import com.example.newboard.DTO.ArticleDTO;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> selectAll();
    ArticleDTO selectOne(int id);
    int insert(ArticleDTO articleDTO);
    int update(ArticleDTO articleDTO);
    int delete(int id);

}
