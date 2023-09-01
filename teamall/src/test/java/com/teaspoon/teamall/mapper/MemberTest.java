package com.teaspoon.teamall.mapper;

import com.teaspoon.teamall.domain.member.dto.LoginDTO;
import com.teaspoon.teamall.domain.member.dto.LoginResponseDTO;
import com.teaspoon.teamall.domain.member.dto.MemberDTO;
import com.teaspoon.teamall.domain.member.mapper.MemberMapper;
import com.teaspoon.teamall.domain.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class MemberTest {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    MemberService memberService;

    @Test
    void testJoin() {

        MemberDTO dto = MemberDTO.builder()
            .email("email@gaag.com")
            .password("1234")
            .nickname("한글도되니?")
            .gender("M")
            .birth(LocalDate.now())
            .phone("0000-0000-0000")
            .build();
        memberService.join(dto);

    }

    @Test
    void testUpdateMember() {

        MemberDTO dto = MemberDTO.builder()
            .password("13579")
            .nickname("qwerty")
            .gender("M")
            .birth(LocalDate.now())
            .phone("01234567890")
            .email("lmc1025@naver.com")
            .build();
        memberService.updateMember(dto);

    }

    @Test
    void testDeleteMember() {

        MemberDTO dto = MemberDTO.builder()
            .email("email@gaag.com")
            .password("1234")
            .build();
        memberService.deleteMember(dto);

    }

    @Test
    void testLogin() {
        LoginDTO loginDTO = LoginDTO.builder()
            .email("lmc1025@naver.com")
            .password("13579")
            .build();
        LoginResponseDTO loginResponseDTO = memberService.login(loginDTO);
        System.out.println(loginDTO + "요청값");
        System.out.println(loginResponseDTO + "응답값");
    }

//    @Test
//    void testSelectMember() {
//
//        MemberDTO dto = MemberDTO.builder()
//            .email("email@gaag.com")
//            .password("13579")
//            .build();
//        memberService.selectMember(dto);
//        System.out.println(dto);
//        System.out.println("================================================================================");
//    }
//    @Test
//    void testLogin() {
//        memberMapper.login();
//    }

}