package coddingcoggies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("diary", new Diary()); //get = 가져오다. 다이어리 객체에 작성된 빈 공간을
		return "diaryWrite";
	}
	
	/*
	@PostMapping("/diaryWrite") //diary/diaryWrite
	public String insertDiary(Diary diary, Model model) {
		log.info(diary.toString());
		diaryService.insertDiary(diary);
		model.addAttribute("msg", "오늘의 일기가 등록되었습니다.");
		return "diaryView";
	}
		*/
	@PostMapping("/diaryWrite")
	public String insertDiary(
			@RequestParam("diary_title") String diary_title,
			@RequestParam("diary_contents") String diary_contents,
			@RequestParam("feelingCode") int diary_feelingCode, 
			@RequestParam("weatherCode") int diary_weatherCode
			) {
		
		diaryService.insertDiary(diary_title, diary_contents, diary_feelingCode, diary_weatherCode);
	    return "diaryView";
	}
	
	

	@GetMapping("/diaryView/{diary_id}") //0626 오후 5시 신우님 여기부터!
	public String getAllDiary(Model model) {
	    List<Diary> diaryView = diaryService.getAllDiary();
	    model.addAttribute("diaryView", diaryView); // List<Diary>를 추가
	    return "diaryView";
	}

}
