package com.example.greenfram3.feed.model;

import lombok.Data;

import java.util.List;

@Data
public class FeedSelvo {
    private int ifeed;
    private String contents;
    private String location;
    private String createdAt;
    private int writerIuser;
    private String writerNm;
    private String writerPic;
    private List<String> pics;

}
