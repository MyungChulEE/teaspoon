package com.teaspoon.teamall.domain.member.controller;

import com.teaspoon.teamall.domain.member.dto.LoginDTO;
import com.teaspoon.teamall.domain.member.dto.MemberDTO;
import com.teaspoon.teamall.domain.member.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MypageController {

    private final MypageService mypageService;

//    @GetMapping("/select")
//    public String getSelectMember(){
//        return "/mypage/select";
//    }

    @GetMapping("/delete")
    public String getDeleteMember(){
        return "/mypage/delete";
    }

    @GetMapping("/update")
    public String getUpdateMember(){
        return "/mypage/update";
    }

    /* 회원 로그아웃 */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // or removeAttribute("loginResponseDTO");
        return "/index";
    }

    /* 회원조회 */
    @GetMapping("/select")
    public String selectMember(HttpSession httpSession, Model model) {
        String email = (String) httpSession.getAttribute("email");

        MemberDTO memberDTO = mypageService.selectMember(email);

        if (memberDTO != null) {
            model.addAttribute("memberDTO", memberDTO);
        } else {
            model.addAttribute("error", "회원 정보를 찾을 수 없습니다.");
        }
        return "mypage/select";
    }

    /* 회원수정 */
    @PostMapping("/update")
    public String updateMember(@ModelAttribute MemberDTO memberDTO) {

        int updateCheck = mypageService.updateMember(memberDTO);
        if (updateCheck > 0){
            return "redirect:/";
        }else{
            return "/mypage/update";
        }
    }

    /* 회원탈퇴 */
    @PostMapping("/delete")
    public String deleteMember(@ModelAttribute MemberDTO memberDTO) {

        int deleteCheck = mypageService.deleteMember(memberDTO);
        if (deleteCheck > 0){
            return "redirect:/";
        }else{
            return "/mypage/delete";
        }
    }

}