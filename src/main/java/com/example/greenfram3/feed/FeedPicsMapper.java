package com.example.greenfram3.feed;

import com.example.greenfram3.feed.model.FeedSelvo;
import com.example.greenfram3.feed.model.FeedinsProcDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedPicsMapper {
    int insPic(FeedinsProcDto dto);

    //메퍼정보랑 같은 다오
    List<String>selListFeed(FeedSelvo vo);
}
