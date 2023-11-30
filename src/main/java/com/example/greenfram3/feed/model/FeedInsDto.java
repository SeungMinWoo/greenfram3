package com.example.greenfram3.feed.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class FeedInsDto {

    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;

}
