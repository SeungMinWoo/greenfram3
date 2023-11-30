package com.example.greenfram3.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Schema(title = "회원가입 데이터")
public class UserSignupDto {
    //박스 갈이 하는 이유
    //스웨거 문서 깔끔하게 하기위해
    @Schema(title = "유저 아이디", example = "mic")
    private String uid;
    @Schema(title = "유저 비밀번호")
    private String upw;
    private String nm;
    private String pic;

}
