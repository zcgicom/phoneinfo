package com.itcat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information {
    private int id;
    private String title;
    private String content;
    private int replyCount;
    private int viewCount;
    private Date reportTime;
    private Date lastPostTime;
}
