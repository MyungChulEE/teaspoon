package com.teaspoon.teamall.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberProfileDTO {

    private int memberNo;
    private String phone;
}
