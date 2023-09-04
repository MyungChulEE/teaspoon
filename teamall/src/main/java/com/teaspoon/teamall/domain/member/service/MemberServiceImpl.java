package com.teaspoon.teamall.domain.member.service;

import com.teaspoon.teamall.domain.member.dto.LoginDTO;
import com.teaspoon.teamall.domain.member.dto.LoginResponseDTO;
import com.teaspoon.teamall.domain.member.dto.MemberDTO;
import com.teaspoon.teamall.domain.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    /* 회원가입 */
    public int join(MemberDTO memberDTO) {  return memberMapper.join(memberDTO);    }

    /* 회원수정 */
    public int updateMember(MemberDTO memberDTO) {
        return memberMapper.updateMember(memberDTO);
    }

    /* 회원삭제 */
    public int deleteMember(MemberDTO memberDTO) {
        return memberMapper.deleteMember(memberDTO);
    }

    /* 로그인 */
    public LoginResponseDTO login(LoginDTO loginDTO) {

        System.out.println(loginDTO.toString());
        LoginResponseDTO loginResponseDTO = memberMapper.login(loginDTO);
        if (loginResponseDTO != null){

        return loginResponseDTO;
        }
        return null;
    }

//    public boolean login(MemberDTO memberDTO) {
//        return memberMapper.login(memberDTO);
//    }

//    /* 내 정보 조회 */
//    public String selectMember( MemberDTO memberDTO) {
//
//        memberMapper.selectMember(memberDTO);
//
//        return MemberDTO;
//    }


//
//    /* 아이디찾기 */
//    public String findID(String email) {
//
//        memberDTO =null;
//
//        /* data 유효성 검증 */
//        if(email != null) {
//            memberDTO = MemberMapper.findID(email);
//        }else {
//            memberDTO = null;
//        }
//
//        return null;
//    }
//
//    /* 비밀번호찾기 */
//    public String findPW(String password) {
//
//        memberDTO = null;
//
//        /* data 유효성 검증 */
//        if(id != null) {
//            memberDTO = MemberMapper.findPW(email);
//        }else {
//            memberDTO = null;
//        }
//
//        return null;
//    }

}