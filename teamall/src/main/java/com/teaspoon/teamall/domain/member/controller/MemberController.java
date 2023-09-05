package com.teaspoon.teamall.domain.member.controller;

import com.teaspoon.teamall.domain.member.dto.*;
import com.teaspoon.teamall.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String getJoin(){
        return "/member/join";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "/member/login";
    }

    @GetMapping("/findID")
    public String getFindID(){
        return "/member/findID";
    }

    @GetMapping("/findPW")
    public String getFindPW(){
        return "/member/findPW";
    }

    /* 회원가입 */
    @PostMapping("/join")
    public String join(@ModelAttribute MemberDTO memberDTO) {
        System.out.println(memberDTO);
        int joinCheck = memberService.join(memberDTO);
        if (joinCheck > 0){
            return "redirect:/";
        }else{
            return "/member/join";
        }
    }

    /* 회원 로그인 */
    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpSession httpSession) {

        LoginResponseDTO loginResponseDTO = memberService.login(loginDTO);

        if (loginResponseDTO != null) {
            httpSession.setAttribute("loginSuccess", loginResponseDTO);
            httpSession.setMaxInactiveInterval(60 * 60);
            return "redirect:/"; // 로그인 후 이동할 페이지
        } else {
            return "/common/inputFailed";
        }
    }


    /* 아이디 찾기 */
    @PostMapping("/findID")
    public String findID(@ModelAttribute FindInfoDTO findInfoDTO) {
        // 클라이언트에서 입력받은 birth 정보를 findInfoDTO(요청DTO)에 설정
        LocalDate birth = findInfoDTO.getBirth();

        // memberService를 통해 DB에서 조회한 결과를 IDDTO(응답DTO)에 저장
        FindInfoResponseDTO IDDTO = memberService.findID(findInfoDTO);
        if (IDDTO != null) {
            return "redirect:/";
        } else {
            return "/common/inputFailed";
        }
    }

    /* 비밀번호 찾기 */
    @PostMapping("/findPW")
    public String findPW(@ModelAttribute FindInfoDTO findInfoDTO) {
        System.out.println(findInfoDTO.toString());
        // 클라이언트에서 입력받은 birth 정보를 findInfoDTO(요청DTO)에 설정
        LocalDate birth = findInfoDTO.getBirth();

        // memberService를 통해 DB에서 조회한 결과를 PWDTO(응답DTO)에 저장
        FindInfoResponseDTO PWDTO = memberService.findPW(findInfoDTO);

        if (PWDTO != null) {
            return "redirect:/";
        } else {
            return "/common/inputFailed";
        }
    }

}