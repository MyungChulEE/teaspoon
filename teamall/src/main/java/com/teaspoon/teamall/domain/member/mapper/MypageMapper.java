package com.teaspoon.teamall.domain.member.mapper;

import com.teaspoon.teamall.domain.member.dto.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {

    /**
     * 회원조회
     * @param email - email값
     * @return - MemberDTO
     */
    MemberDTO selectMember(String email);

    /**
     * 회원수정
     * @param memberDTO - 멤버의 DTO
     * @return - int
     */
    int updateMember(MemberDTO memberDTO);

    /**
     * 회원삭제
     * @param memberDTO - 멤버의 DTO
     * @return - int
     */
    int deleteMember(MemberDTO memberDTO);

}