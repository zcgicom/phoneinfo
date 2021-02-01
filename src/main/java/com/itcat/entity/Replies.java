package com.itcat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Replies {
    private int id;
    private String content;
    private Date replyTime;
    private int infold;
}
