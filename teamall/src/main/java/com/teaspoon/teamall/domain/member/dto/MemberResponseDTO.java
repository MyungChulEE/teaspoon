package com.teaspoon.teamall.domain.member.dto;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MemberResponseDTO {
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
