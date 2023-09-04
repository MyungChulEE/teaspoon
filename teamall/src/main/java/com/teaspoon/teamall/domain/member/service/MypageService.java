package com.teaspoon.teamall.domain.member.service;

import com.teaspoon.teamall.domain.member.dto.*;

public interface MypageService {




    int updateMember(MemberDTO memberDTO);

    int deleteMember(MemberDTO memberDTO);

    MemberDTO selectMember(FindInfoResponseDTO pwdto);
}