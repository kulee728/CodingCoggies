package coddingcoggies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import coddingcoggies.dto.Diary;
import coddingcoggies.service.DiaryService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/diary")
public class DiaryController {
	@Autowired
	private DiaryService diaryService;

	@GetMapping("/diaryWrite")
	public String toDiaryWrite(Model model) {
		model.addAttribute("diary", new Diary()); // get = 가져오다. 다이어리 객체에 작성된 빈 공간을
		return "diaryWrite";
	}

	/*
	 * @PostMapping("/diaryWrite") //diary/diaryWrite public String
	 * insertDiary(Diary diary, Model model) { log.info(diary.toString());
	 * diaryService.insertDiary(diary); model.addAttribute("msg",
	 * "오늘의 일기가 등록되었습니다."); return "diaryView"; }
	 */
	@PostMapping("/diaryWrite")
	public String insertDiary(@RequestParam("diary_title") String diary_title,
			@RequestParam("diary_contents") String diary_contents, @RequestParam("feelingCode") int diary_feelingCode,
			@RequestParam("weatherCode") int diary_weatherCode, @RequestParam("diary_fileurl") MultipartFile file) {

		diaryService.insertDiary(diary_title, diary_contents, diary_feelingCode, diary_weatherCode, file);
		return "diaryView";
	}

	/*
	 * @GetMapping("/diaryView/{diary_id}") public String getAllDiary(Model model) {
	 * List<Diary> diaryView = diaryService.getAllDiary();
	 * model.addAttribute("diaryView", diaryView); // List<Diary>를 추가 return
	 * "diaryView"; }
	 */
	/********************
	 * http://localhost:9099/diary/diaryView/null
	 *************************************************************************/
	@GetMapping("/diaryView/{diary_id}")
	public String getDiaryById(@PathVariable("diary_id") int diary_id, Model model, HttpSession session) {
		
		DiaryLogin diaryLogin = (DiaryLogin)session.getAttribute("loginSession");
		if(diaryLogin==null) {
			return "redirect:/";
		} //로그인 세션 확인
		
		
		System.out.println(" **** id ****" + diary_id);

		Diary diary = diaryService.getDiaryById(diary_id);
		log.info("=== diary === : " + diary);
		if (diary != null) {
			if(diaryLogin.getMember_no() != diary.getMember_no()) {
				return "redirect:/";
			} //만약 사용자가 다른 사용자의 다이어리에 접근하지 않도록 세션과 비교(id로만 접근하기 때문에)
			
			model.addAttribute("diary", diary);
			return "diaryView"; // 조회 페이지로 이동
		} else {
			return "redirect:/diaryWrite"; // 작성 페이지로 이동
		}

	}

}
