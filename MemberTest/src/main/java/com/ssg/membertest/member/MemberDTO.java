package com.ssg.membertest.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
//    private String mid;
//    private String mpw;
//    private String mname;
    private String userId;
    private String userPwd;
    private String userName;
    private String userEmail;
    private LocalDate joinDate;
}
