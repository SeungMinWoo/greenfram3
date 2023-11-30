package com.example.greenfram3.feed;

import com.example.greenfram3.feed.model.FeedInsDto;
import com.example.greenfram3.feed.model.FeedSelProcDto;
import com.example.greenfram3.feed.model.FeedSelvo;
import com.example.greenfram3.feed.model.FeedinsProcDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedinsProcDto dto);
    List<FeedSelvo> selFeed(FeedSelProcDto dto);
    //리스트 피드 셀vo 한거 가져오기
}
