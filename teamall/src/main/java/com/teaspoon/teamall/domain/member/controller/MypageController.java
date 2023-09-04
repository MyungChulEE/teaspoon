//package com.teaspoon.teamall.domain.member.controller;
//
//import com.teaspoon.teamall.domain.member.dto.FindInfoResponseDTO;
//import com.teaspoon.teamall.domain.member.dto.LoginDTO;
//import com.teaspoon.teamall.domain.member.dto.MemberDTO;
//import com.teaspoon.teamall.domain.member.service.MypageService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/mypage")
//public class MypageController {
//
//    private final MypageService mypageService;
//
////    @GetMapping("/select")
////    public String selectMember(HttpServletRequest HSreq, Model model) {
////
////        String myID = HSreq.getParameter("email");
////        MemberDTO memberDTO = MypageService.selectMember(myID);
////
////        model.addAttribute("memberDTO", memberDTO);
////
////        int selectCheck = mypageService.selectMember(memberDTO);
////        if (selectCheck > 0){
////            return "redirect:/";
////        }else{
////            return "/mypage/select";
////        }
////    }
//
//    @GetMapping("/select")
//    public String selectMember(@ModelAttribute FindInfoResponseDTO PWDTO) {
//
//        // mypageService를 통해 DB에서 조회한 결과를 IDDTO(응답DTO)에 저장
//        MemberDTO memberDTO = mypageService.selectMember(PWDTO);
//
//        if (memberDTO != null) {
//            return "redirect:/";
//        } else {
//            return "/common/inputFailed";
//        }
//    }
//
//    /* 회원수정 */
//    @PostMapping("/update")
//    public String updateMember(@ModelAttribute MemberDTO memberDTO) {
//
//        int updateCheck = mypageService.updateMember(memberDTO);
//        if (updateCheck > 0){
//            return "redirect:/";
//        }else{
//            return "/mypage/update";
//        }
//    }
//
//    /* 회원탈퇴 */
//    @PostMapping("/delete")
//    public String deleteMember(@ModelAttribute MemberDTO memberDTO) {
//
//        int deleteCheck = mypageService.deleteMember(memberDTO);
//        if (deleteCheck > 0){
//            return "redirect:/";
//        }else{
//            return "/mypage/delete";
//        }
//    }
//
//    /* 회원 로그아웃 */
//    @PostMapping("/logout")
//    public String logout(@ModelAttribute LoginDTO loginDTO, HttpSession httpSession) {
//        return "/mypage/select";
//    }
//
//
//    @GetMapping("/select")
//    public String getSelectMember(){
//
//        return "/mypage/select";
//    }
//
//    @GetMapping("/delete")
//    public String getDeleteMember(){
//
//        return "/mypage/delete";
//    }
//
//    @GetMapping("/update")
//    public String getUpdateMember(){
//
//        return "/mypage/update";
//    }
//
//    @GetMapping("/logout")
//    public String getLogout(){
//
//        return "/mypage/logout";
//    }
//
//}