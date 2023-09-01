package com.teaspoon.teamall.domain.member.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private int member_no;
    private String email;
    private String nickname;
}
