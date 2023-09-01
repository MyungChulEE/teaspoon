package com.teaspoon.teamall.domain.member.controller;

import com.teaspoon.teamall.domain.member.dto.LoginDTO;
import com.teaspoon.teamall.domain.member.dto.LoginResponseDTO;
import com.teaspoon.teamall.domain.member.dto.MemberDTO;
import com.teaspoon.teamall.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    /* 회원가입 */
    @PostMapping("/join")
    public String join(@ModelAttribute MemberDTO memberDTO) {

        int joinCheck = memberService.join(memberDTO);
        if (joinCheck > 0){
            return "/";
        }else{
            return "/join";
        }
    }

    /* 회원수정 */
    @PostMapping("/updateMember")
    public String updateMember(@ModelAttribute MemberDTO memberDTO) {

        int updateCheck = memberService.updateMember(memberDTO);
        if (updateCheck > 0){
            return "/";
        }else{
            return "/updateMember";
        }
    }

    /* 회원삭제 */
    @PostMapping("/deleteMember")
    public String deleteMember(@ModelAttribute MemberDTO memberDTO) {

        int deleteCheck = memberService.deleteMember(memberDTO);
        if (deleteCheck > 0){
            return "/";

        }else{
            return "/deleteMember";
        }
    }


    @GetMapping("/get-login")
    public String getLogin(){

        return "/member/login";
    }



    /* 회원 로그인 */
    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpSession httpSession) {
        LoginResponseDTO loginResponseDTO = memberService.login(loginDTO);

        if (loginResponseDTO != null) {
            httpSession.setAttribute("loginSuccess", loginResponseDTO);
            return "redirect:/"; // 로그인 후 이동할 페이지
        } else {
            return "/"; // 로그인 실패 시 보여줄 페이지 (login 페이지로 가정)
        }
    }


//    /* 회원 로그인 숱한 오류와 로그 버전*/
//    @PostMapping("/login")
//    public String login(@RequestParam(name = "email") String email,@RequestParam(name = "password") String pw, HttpSession httpSession) {
//        System.out.println(email);
//        System.out.println(pw);
//        LoginDTO loginDTO = LoginDTO.builder()
//            .email(email)
//            .password(pw)
//            .build();
//        System.out.println(loginDTO.toString());
//        LoginResponseDTO loginResponseDTO = memberService.login(loginDTO);
//        System.out.println(loginResponseDTO.getEmail());
//        System.out.println(loginResponseDTO.getMember_no());
//
//        if (loginResponseDTO != null) {
//            httpSession.setAttribute("loginSuccess", loginResponseDTO);
//            return "redirect:/"; // 로그인 후 이동할 페이지
//        } else {
//            return "/"; // 로그인 실패 시 보여줄 페이지 (login 페이지로 가정)
//        }
//    }

    /* 내 정보 조회 */
//    @GetMapping("/selectMember")
//    public String selectMember(HttpServletRequest HSreq, Model model) {
//
//        String myID = HSreq.getParameter("email");
//        MemberDTO memberDTO = MemberService.selectMember(myID);
//
//        model.addAttribute("memberDTO", memberDTO);
//
//        int selectCheck = memberService.selectMember(memberDTO);
//        if (selectCheck > 0){
//            return "/member";
//        }else{
//            return "/selectMember";
//        }
//    }

//
//    /* 아이디찾기 */
//    @PostMapping("/findID")
//    public String findID(HttpServletRequest request, Model model) {
//
//
//        String memberID = request.getParameter("email");
//        MemberDTO memberDTO = memberService.findID(memberID);
//
//        model.addAttribute("memberDTO",memberDTO);
//        model.addAttribute("path","mybatis");
//
//        return "";
//    }
//
//    /* 비밀번호찾기 */
//    @PostMapping("/findPW")
//    public String findPW(HttpServletRequest request, Model model) {
//
//
//        String memberID = request.getParameter("email");
//        MemberDTO memberDTO = memberService.findPW(memberID);
//
//        model.addAttribute("memberDTO",memberDTO);
//        model.addAttribute("path","mybatis");
//
//        return "";
//    }
}