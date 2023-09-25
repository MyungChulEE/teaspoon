package com.teaspoon.teamall.domain.member.mapper;

import com.teaspoon.teamall.domain.member.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MypageMapper {

    /**
     * 회원정보 조회
     * @param memberNo - 세션에 저장된 멤버 PK넘버
     * @return - MemberDTO
     */
    MemberDTO selectMember(@Param("memberNo") int memberNo,@Param("password") String password);

    MemberDTO findByMemberNo(@Param("memberNo") int memberNo);

    /**
     * 회원정보 수정
     * @param memberDTO - 멤버의 DTO
     * @return - int
     */
    int updateMember(MemberDTO memberDTO);

    /**
     * 회원 탈퇴
     * @param memberDTO - 멤버의 DTO
     * @return - int
     */
    int deleteMember(MemberDTO memberDTO);

}