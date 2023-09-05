package com.teaspoon.teamall.domain.member.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MemberDTO {
    private int memberNo;
    private String email;
    private String password;
    private String nickname;
    private String gender;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birth;
    private String phone;
    private Timestamp createDate;
    private Timestamp updateDate;
}