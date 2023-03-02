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
public class Article {
    private int id;
    private String userid;
    private String title;
    private String content;
    private LocalDate regdate;
    private LocalDate moddate;
    private int cnt;
}
