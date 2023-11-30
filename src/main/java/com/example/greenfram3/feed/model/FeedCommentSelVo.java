package com.example.greenfram3.feed.model;

import lombok.Data;

import java.util.List;

@Data
public class FeedCommentSelVo {
    private int ifeedComment;
    private String comment;
    private int writerIuser;
    private String createdAt;
    private String writerNm;
    private String writerPic;
    private List<String> pics;

}
