package com.ssg.memberservicetest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class MemberDTO {
     @NotBlank
     private String userId;

     @NotBlank
     private String userPwd;

     @NotBlank
     private String userName;

     @Email
     private String userEmail;

     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
     private LocalDate joinDate;
}
