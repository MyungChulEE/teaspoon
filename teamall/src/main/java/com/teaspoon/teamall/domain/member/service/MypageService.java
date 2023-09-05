package com.teaspoon.teamall.domain.member.service;

import com.teaspoon.teamall.domain.member.dto.*;

public interface MypageService {

    /* 회원정보 조회 */
    MemberDTO selectMember(Long member_no);

    /* 회원정보 수정 */
    int updateMember(MemberDTO memberDTO);

    /* 회원 탈퇴 */
    int deleteMember(MemberDTO memberDTO);


}