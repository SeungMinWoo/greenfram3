package com.example.greenfram3.feed.model;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class FeedSelProcDto {
    private int startIdx;
    private int rowCount;

    // 생성자 구현  들어오면 바로드렁온다
    // 페이지처리 (page-1)*rowCount;
}
