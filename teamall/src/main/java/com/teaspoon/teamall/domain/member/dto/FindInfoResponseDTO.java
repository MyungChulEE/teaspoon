package com.teaspoon.teamall.domain.member.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindInfoResponseDTO {
    private String email;
    private String password;
}
