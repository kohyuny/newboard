package com.example.newboard.service;

import com.example.newboard.DTO.ReplyDTO;

import java.util.List;

public interface ReplyService {
    List<ReplyDTO> selectAll(int id);
    int insert(ReplyDTO replyDTO);

    int delete(int rid);


}
