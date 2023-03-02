package com.example.newboard.service;

import com.example.newboard.DTO.ArticleDTO;
import com.example.newboard.entity.Article;
import com.example.newboard.mapper.ArticleMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImp implements ArticleService{
    @Autowired
    ArticleMapper articleMapper;
    ModelMapper modelMappeer = new ModelMapper();
    @Override
    public List<ArticleDTO> selectAll() {
        List<Article> list = articleMapper.selectAll();
        List<ArticleDTO> list1 = list.stream()
                .map(article-> modelMappeer.map(article, ArticleDTO.class))
                .collect(Collectors.toList());
        list1.forEach(articleDTO-> log.info(String.valueOf(list1)));

        return list1;
    }

    @Override
    public ArticleDTO selectOne(int id) {
        return modelMappeer.map(articleMapper.selectOne(id), ArticleDTO.class);
    }

    @Override
    public int insert(ArticleDTO articleDTO) {

        int result = articleMapper.insert(modelMappeer.map(articleDTO, Article.class));


        return !(result>0)? 0 : 1;
    }

    @Override
    public int update(ArticleDTO articleDTO) {
        int result = articleMapper.update(modelMappeer.map(articleDTO, Article.class));
        return !(result>0)? 0 : 1;
    }

    @Override
    public int delete(int id) {

        int result = articleMapper.delete(id);
        return !(result>0)? 0 : 1;
    }
}
