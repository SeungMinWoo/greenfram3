package com.example.greenfram3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FeedinsProcDto {
   // @JsonIgnore 박스갈이 안해도됨
   // @Schema(hidden = true) 박스갈이 안해도됨
    private int ifeed;
    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;
}
