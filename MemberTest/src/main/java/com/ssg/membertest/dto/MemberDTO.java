package com.ssg.membertest.dto;

import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;

    /*
    private String userId;
    private String userPwd;
    private String userName;
    private String userEmail;
    private LocalDate joinDate;
    */
}
