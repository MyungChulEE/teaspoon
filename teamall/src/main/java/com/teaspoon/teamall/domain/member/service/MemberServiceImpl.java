package com.teaspoon.teamall.domain.member.service;

import com.teaspoon.teamall.domain.member.dto.*;
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
    
    /* 아이디찾기 */
    public FindInfoResponseDTO findID(FindInfoDTO findInfoDTO) {

        System.out.println(findInfoDTO.toString());
        System.out.println(findInfoDTO.toString());
        FindInfoResponseDTO IDDTO = memberMapper.findID(findInfoDTO);
        System.out.println(IDDTO.toString());
        if (IDDTO != null){

            return IDDTO;
        }
        return null;
    }

    /* 비밀번호찾기 */
    public FindInfoResponseDTO findPW(FindInfoDTO findInfoDTO) {

        System.out.println(findInfoDTO.toString());
        FindInfoResponseDTO PWDTO = memberMapper.findPW(findInfoDTO);
        if (PWDTO != null){

            return PWDTO;
        }
        return null;
    }

        /* 내 정보 조회 -> 회원 CRUD 연습용. UnusedAPI*/
//    public String selectMember( MemberDTO memberDTO) {
//
//        memberMapper.selectMember(memberDTO);
//
//        return MemberDTO;
//    }
    
}