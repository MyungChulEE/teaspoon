package com.teaspoon.teamall.domain.member.controller;

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
        return "redirect:/";
    }

    /* 회원정보 조회 */
    @GetMapping("/select")
    public String selectMember(HttpSession httpSession, Model model) {
        Long member_no = (Long) httpSession.getAttribute("member_no");

        if (member_no != null) {
            MemberDTO memberDTO = mypageService.selectMember(member_no);

            if (memberDTO != null) {
                model.addAttribute("memberDTO", memberDTO);
                return "redirect:/";
            } else {
                model.addAttribute("error", "멤버 정보를 찾을 수 없습니다.");
                return "/common/inputFailed";
            }
        } else {
            // 세션이 아예 만료되었거나 로그인이 안 된 상태에서 이상하게 접근할 시
            model.addAttribute("error", "로그인이 필요합니다.");
            return "/member/login";
        }
    }

    /* 회원정보 수정 */
    @PostMapping("/update")
    public String updateMember(@ModelAttribute MemberDTO memberDTO) {

        int updateCheck = mypageService.updateMember(memberDTO);
        if (updateCheck > 0){
            return "redirect:/";
        }else{
            return "/mypage/update";
        }
    }

    /* 회원 탈퇴 */
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