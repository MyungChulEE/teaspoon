package com.teaspoon.teamall.domain.member.service;

import com.teaspoon.teamall.domain.member.dto.LoginDTO;
import com.teaspoon.teamall.domain.member.dto.LoginResponseDTO;
import com.teaspoon.teamall.domain.member.dto.MemberDTO;

public interface MemberService {

    int join(MemberDTO memberDTO);

    int updateMember(MemberDTO memberDTO);

    int deleteMember(MemberDTO memberDTO);

    LoginResponseDTO login(LoginDTO loginDTO);

//    boolean login(MemberDTO memberDTO);



//    String selectMember(MemberDTO memberDTO);
}