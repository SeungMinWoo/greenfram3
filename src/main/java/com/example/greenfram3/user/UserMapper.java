package com.example.greenfram3.user;

import com.example.greenfram3.user.model.UserSigninDto;
import com.example.greenfram3.user.model.UserSigninVo;
import com.example.greenfram3.user.model.UserSignupDto;
import com.example.greenfram3.user.model.UserSignupProcDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
   int insUser(UserSignupProcDto dto);
   String getUserUpw (UserSigninDto dto);
   UserSigninVo getUserInfo (UserSigninDto dto);
}
