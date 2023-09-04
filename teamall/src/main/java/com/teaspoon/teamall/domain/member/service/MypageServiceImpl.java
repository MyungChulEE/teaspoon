package com.teaspoon.teamall.domain.member.service;

import com.teaspoon.teamall.domain.member.dto.*;
import com.teaspoon.teamall.domain.member.mapper.MemberMapper;
import com.teaspoon.teamall.domain.member.mapper.MypageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {

    private final MypageMapper mypageMapper;

    public MemberDTO selectMember(String email) {
        return mypageMapper.selectMember(email);
    }

    /* 회원수정 */
    public int updateMember(MemberDTO memberDTO) {
        return mypageMapper.updateMember(memberDTO);
    }

    /* 회원삭제 */
    public int deleteMember(MemberDTO memberDTO) {
        return mypageMapper.deleteMember(memberDTO);
    }



}