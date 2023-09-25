package com.teaspoon.teamall.domain.member.mapper;

import com.teaspoon.teamall.domain.member.dto.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    /**
     * 회원가입
     * @param memberDTO - 멤버의 DTO
     * @return - int
     */
    int join(MemberDTO memberDTO);

    /**
     * 로그인
     * @param loginDTO - 로그인 요청 DTO (email, password)
     * @return - 로그인 응답 DTO (member_no, email, nickname)
     */
    LoginResponseDTO login(LoginDTO loginDTO);

    /**
     * 아이디 찾기
     * @param findInfoDTO - (phone, birth)
     * @return - 멤버정보 응답 DTO - (email)
     */
    FindInfoResponseDTO findID(FindInfoDTO findInfoDTO);

    /**
     * 비밀번호 찾기
     * @param findInfoDTO - (phone, birth, email)
     * @return - 멤버정보 응답 DTO - (password)
     */
    FindInfoResponseDTO findPW(FindInfoDTO findInfoDTO);



}