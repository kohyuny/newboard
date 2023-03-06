package com.example.newboard.controller;

import com.example.newboard.DTO.ArticleDTO;
import com.example.newboard.DTO.PageRequestDTO;
import com.example.newboard.DTO.PageResponseDTO;
import com.example.newboard.entity.Article;
import com.example.newboard.service.ArticleService;
import com.example.newboard.service.ReplyService;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    ReplyService replyService;
//    @GetMapping("/list")
//    public String selectAll(Model model){
//        model.addAttribute("list", articleService.selectAll());
//        return "list";
//    }
    @GetMapping("/list")
    public String selectAll(PageRequestDTO pageRequestDTO, Model model){
        PageResponseDTO<ArticleDTO> pageResponseDTO = articleService.selectAllForPaging(pageRequestDTO);
        model.addAttribute("list", pageResponseDTO);
        return "list";
    }
    @GetMapping("/detail/{id}")
    public String selectOne(@PathVariable("id")int id, Model model){
        model.addAttribute("articleDTO", articleService.selectOne(id));
        model.addAttribute("listreply", replyService.selectAll(id));
        return "detail";

    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id")int id, Model model){
        model.addAttribute("articleDTO", articleService.selectOne(id));
        return "edit";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
        articleService.delete(id);
        return "redirect:/list";
    }
    @PostMapping("/register")
    public String register(ArticleDTO articleDTO){
        articleService.insert(articleDTO);
        return "redirect:/list";
    }
    @PostMapping("/edit")
    public String edit(ArticleDTO articleDTO){
        articleService.update(articleDTO);
        return "redirect:/detail/"+articleDTO.getId();
    }
}
