package com.example.greenfram3.feed;

import com.example.greenfram3.common.Resvo;
import com.example.greenfram3.feed.model.FeedInsDto;
import com.example.greenfram3.feed.model.FeedSelProcDto;
import com.example.greenfram3.feed.model.FeedSelvo;
import com.example.greenfram3.feed.model.FeedinsProcDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.greenfram3.common.Const.FEED_COUNT_PER_PAGE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/feed")
@Tag(name="피드 API", description = "피드 관련 처리")
public class FeedController {
    private final FeedService service;

    @Operation(summary = "피드 등록", description = "피드 등록 처리")
    @PostMapping
    public Resvo postFeed(@RequestBody FeedInsDto dto){
        return service.postFeed(dto);

    }
    @GetMapping
    @Operation(summary = "피드 리스트", description = "전체 피드 리스트, 특정 사용자 프로필 화면에서 사용할 피드 리스트, 한 페이지 30개 피드 가져옴")
    @Parameters(value = {
            @Parameter(name = "page",description = "page값")
            ,@Parameter(name="loginedIuser",description ="로그인 유저 pk")
            ,@Parameter(name="targetIuser",description = "(생략가능) 특정 사용자 프로필 화면의 주인 유저 pk")
    })
    public List<FeedSelvo> feedSelvos(int page){
        // 보내는 용도 Feed Sel Dto
        //세트했으니 겟해서 가져와서 new 새로운 객체생성 메서드 호출 페이지 값넣어줌

        FeedSelProcDto procDto = FeedSelProcDto.builder()
                .startIdx((page-1)*FEED_COUNT_PER_PAGE)
                .rowCount(FEED_COUNT_PER_PAGE)
                .build();
        return  service.feedSelVos(procDto);
    }

}
