package com.example.newboard.service;

import com.example.newboard.DTO.ReplyDTO;
import com.example.newboard.entity.Reply;
import com.example.newboard.mapper.ReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReplyServiceImp implements ReplyService{
    @Autowired
    ReplyMapper replyMapper;
    ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<ReplyDTO> selectAll(int id) {

        List<Reply> list = replyMapper.selectAll(id);
        List<ReplyDTO> listDTO = list.stream()
                .map(reply -> modelMapper.map(reply, ReplyDTO.class))
                .collect(Collectors.toList());

        return listDTO;
    }

    @Override
    public int insert(ReplyDTO replyDTO) {
        replyDTO.setRegdate(LocalDate.now());
        int result = replyMapper.insert(modelMapper.map(replyDTO, Reply.class));

        return !(result>0)? 0 : 1;
    }

    @Override
    public int delete(int rid) {
        int result = replyMapper.delete(rid);
        return !(result>0)? 0 : 1;
    }
}
