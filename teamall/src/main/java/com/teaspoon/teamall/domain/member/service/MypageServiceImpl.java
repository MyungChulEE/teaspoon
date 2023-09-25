package com.teaspoon.teamall.domain.member.service;

import com.teaspoon.teamall.domain.member.dto.LoginResponseDTO;
import com.teaspoon.teamall.domain.member.dto.MemberDTO;
import com.teaspoon.teamall.domain.member.mapper.MypageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {

    private final MypageMapper mypageMapper;

    /* 회원정보 조회 */
    public MemberDTO selectMember(int memberNo, String password) {
        return mypageMapper.selectMember(memberNo, password);
    }

    /* 회원정보 수정 */
    public int updateMember(MemberDTO memberDTO) {
        return mypageMapper.updateMember(memberDTO);
    }

    /* 회원 탈퇴 */
    public int deleteMember(MemberDTO memberDTO) {
        return mypageMapper.deleteMember(memberDTO);
    }

}