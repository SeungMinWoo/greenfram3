package com.example.greenfram3.user;

import com.example.greenfram3.common.Resvo;
import com.example.greenfram3.user.model.UserSigninDto;
import com.example.greenfram3.user.model.UserSigninVo;
import com.example.greenfram3.user.model.UserSignupDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping("/signup")
    @Operation(summary ="회원가입",description = "회원가입 처리")
    public Resvo postSignup(@RequestBody UserSignupDto dto){
       log.info("dto: {}", dto);
        return service.signup(dto);
    }
    //pk, 이름, 프로필사진
    @PostMapping("/signin")
    public UserSigninVo postSignin(@RequestBody UserSigninDto dto){
        return service.signin(dto);
    }
}
