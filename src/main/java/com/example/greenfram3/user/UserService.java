package com.example.greenfram3.user;

import com.example.greenfram3.common.Resvo;
import com.example.greenfram3.user.model.UserSigninDto;
import com.example.greenfram3.user.model.UserSigninVo;
import com.example.greenfram3.user.model.UserSignupDto;
import com.example.greenfram3.user.model.UserSignupProcDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public Resvo signup(UserSignupDto dto) {
        //비밀번호 암호화
        String savedPw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());

        UserSignupProcDto procDto = UserSignupProcDto
                .builder()
                .uid(dto.getUid())
                .upw(savedPw)
                .nm(dto.getNm())
                .pic(dto.getPic())
                .build();
        int result = mapper.insUser(procDto);

        if (result == 1) {
            return new Resvo(procDto.getIuser());
        }
        return new Resvo(0); //회원가입한 iuser pk값이 리턴
    }

    public UserSigninVo signin(UserSigninDto dto) {

        UserSigninVo vo = new UserSigninVo();
        String savePw = mapper.getUserUpw(dto);
        if (savePw == null) {
            vo.setResult(2);
        } else if (!BCrypt.checkpw(dto.getUpw(), savePw)) {
            //순수한 비밀호 내가치는 비밀번호  데이터에저장되어있는 비밀번호 비교1
            vo.setResult(3);
        } else {
            UserSigninVo signinVo = mapper.getUserInfo(dto);
            vo.setResult(1);
            vo.setNm(signinVo.getNm());
            vo.setPic(signinVo.getPic());
            vo.setIuser(signinVo.getIuser());
        }
        return vo;
    }
}
