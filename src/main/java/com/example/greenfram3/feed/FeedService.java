package com.example.greenfram3.feed;

import com.example.greenfram3.common.Resvo;
import com.example.greenfram3.feed.model.FeedInsDto;
import com.example.greenfram3.feed.model.FeedSelProcDto;
import com.example.greenfram3.feed.model.FeedSelvo;
import com.example.greenfram3.feed.model.FeedinsProcDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final FeedPicsMapper picsMapper;

    public Resvo postFeed(FeedInsDto dto){

        FeedinsProcDto procDto = FeedinsProcDto.builder()
                .iuser(dto.getIuser())
                .contents(dto.getContents())
                .location(dto.getLocation())
                .pics(dto.getPics())
                .build();
        //
        int insUser = mapper.insFeed(procDto);

        //리스트의 사이즈값
        int insUserRows =picsMapper.insPic(procDto);

        return new Resvo(procDto.getIfeed());
        //


    }
    public List<FeedSelvo>feedSelVos(FeedSelProcDto dto){
        List<FeedSelvo> list =  mapper.selFeed(dto);
        for (FeedSelvo vo: list) {
            List<String> pics = picsMapper.selListFeed(vo);

            vo.setPics(pics);


        }
        return list;

 //컨트롤에 있는거 구현 그겨가져오기
        // 리스트 에있는거 가져와서 리턴 리스트
    }



}
