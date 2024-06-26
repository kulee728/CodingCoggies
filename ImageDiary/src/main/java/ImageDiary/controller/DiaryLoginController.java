package ImageDiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ImageDiary.dto.DiaryLogin;
import ImageDiary.service.DiaryLoginService;
import jakarta.servlet.http.HttpSession;

@Controller
public class DiaryLoginController {

	@Autowired
	private DiaryLoginService diaryLoginService;
	
	@GetMapping("/")
	public String showLoginForm(Model model) {
		model.addAttribute("m", new DiaryLogin());
		return "index";
	}
	
	@PostMapping("/login-form")
	public String getLogin(Model model,
						@RequestParam("member_id") String member_id,
						@RequestParam("member_pw") String member_pw,
						HttpSession session ) {
		DiaryLogin diaryLogin = diaryLoginService.getLogin(member_id, member_pw);
		System.out.println("login info : " + diaryLogin);
		if(diaryLogin != null) {
			session.setAttribute("loginSession", diaryLogin);
			return "redirect:/diaryMain"; //성공 시 인덱스페이지로 리다이렉트 >> index가 아닌 diaryMain으로 이동 
		} else {
			model.addAttribute("error", "일치하는 계정정보가 없습니다.");
			model.addAttribute("m", new DiaryLogin());
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // 세션 무효화
	    return "redirect:/"; // 로그아웃 후 인덱스 페이지로 리다이렉트
	}
	
}
