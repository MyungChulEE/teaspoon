package com.teaspoon.teamall.domain.member.mapper;

import com.teaspoon.teamall.domain.member.dto.LoginDTO;
import com.teaspoon.teamall.domain.member.dto.LoginResponseDTO;
import com.teaspoon.teamall.domain.member.dto.MemberDTO;
import com.teaspoon.teamall.domain.member.dto.MemberProfileDTO;
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

    /**
     * 로그인
     * @param loginDTO - 로그인 요청 DTO (email, password)
     * @return - 로그인 응답 DTO (member_no, email, nickname)
     */
    LoginResponseDTO login(LoginDTO loginDTO);
    //  boolean login(MemberDTO memberDTO);


    /*내 정보 조회*/
//    MemberDTO selectMember(HttpServletRequest HSreq, Model model);


    /*아이디찾기*/
//    MemberVO findID(MemberDTO memberDTO);

    /*비밀번호찾기*/
//    MemberVO findPW(MemberDTO memberDTO);

    MemberProfileDTO findByProfile(String email);
}