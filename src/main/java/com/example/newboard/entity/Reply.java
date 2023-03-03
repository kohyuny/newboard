package com.example.newboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {
    private int rid;
    private int id;
    private String content;
    private String userid;
    private LocalDate regdate;


}
