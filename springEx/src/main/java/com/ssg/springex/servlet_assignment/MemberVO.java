package com.ssg.springex.servlet_assignment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVO {
    private String userId;
    private String userPwd;
    private String userGender;
    private String[] userHobby;

}
