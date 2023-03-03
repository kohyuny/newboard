package com.example.newboard.controller;

import com.example.newboard.DTO.ReplyDTO;
import com.example.newboard.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ReplyController {
    @Autowired
    ReplyService replyService;
    @PostMapping("/replyregister")
    public String insert(ReplyDTO replyDTO){
        replyService.insert(replyDTO);
        return "redirect:/detail/"+replyDTO.getId();
    }
    @GetMapping ("/{id}/replydelete/{rid}")
    public String delete(@PathVariable("id") int id, @PathVariable("rid") int rid){
        replyService.delete(rid);
        return "redirect:/detail/"+id;
    }
}
