package com.teaspoon.teamall.domain.member.vo;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MemberVO {
    private int member_no;
    private String email;
    private String password;
    private String nickname;
    private String gender;
    private LocalDate birth;
    private String phone;
    private Timestamp create_date;
    private Timestamp update_date;
}