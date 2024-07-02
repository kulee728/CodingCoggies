package coddingcoggies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import coddingcoggies.dto.Diary;
import coddingcoggies.service.DiaryService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/diary")
public class DiaryController {
	@Autowired
	private DiaryService diaryService;
	
	/* ************************** 해당 날짜 받아오기->왜 안되니 또?******************************** */
<<<<<<< Updated upstream
	@GetMapping("/diary/diaryView/{diary_id}/{dayNum}")
    public String viewDiary(@PathVariable int diary_id, @PathVariable String dayNum, Model model) {
=======
	@GetMapping("/diaryView/{diary_id}/{today}")
    public String viewDiary(@PathVariable int diary_id, @PathVariable String today, Model model) {
>>>>>>> Stashed changes
        model.addAttribute("diary_id", diary_id);
        model.addAttribute("today", today);
        return "diaryView";
    }

<<<<<<< Updated upstream
    @GetMapping("/diary/diaryWrite/{member_no}/{today}/{dayNum}")
    public String writeDiary(@PathVariable int member_no, @PathVariable String today, @PathVariable String dayNum, Model model) {
        model.addAttribute("member_no", member_no);
=======
	//++ String member_no -> int member_no
    @GetMapping("/diaryWrite/{member_no}/{today}")
    public String writeDiary(@PathVariable int member_no, @PathVariable String today, Model model) {
    	//log.info("today :" +today);
    	
    	model.addAttribute("diary", new Diary());
    	model.addAttribute("member_no", member_no);
>>>>>>> Stashed changes
        model.addAttribute("today", today);
        model.addAttribute("dayNum", dayNum);
        return "diaryWrite";
    }
    /* ******************************************************************************** */
    
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
	
	// ++ @RequestParam("diary_date") String diary_date, @RequestParam("member_no") int member_no
	@PostMapping("/diaryWrite")
	public String insertDiary(@RequestParam("diary_title") String diary_title,
			@RequestParam("diary_contents") String diary_contents, @RequestParam("feelingCode") int diary_feelingCode,
<<<<<<< Updated upstream
			@RequestParam("weatherCode") int diary_weatherCode, @RequestParam("diary_fileurl") MultipartFile file) {

		diaryService.insertDiary(diary_title, diary_contents, diary_feelingCode, diary_weatherCode, file);
		return "diaryView";
=======
			@RequestParam("weatherCode") int diary_weatherCode, @RequestParam("diary_fileurl") MultipartFile file, HttpSession session) {
		log.info("일기 작성 날짜 : "+cur_date);
		
		
		DiaryLogin diaryLogin = (DiaryLogin)session.getAttribute("loginSession");
		if(diaryLogin==null) {
			return "redirect:/";
		}
		log.info("타이틀" +diary_title);
		
		String diary_date = cur_date;
		int member_no = diaryLogin.getMember_no();
				
		// ++ diary_date, member_no,
		diaryService.insertDiary(diary_date, member_no, diary_title, diary_contents, diary_feelingCode, diary_weatherCode, file);
		
		return "redirect:/diaryMain";
>>>>>>> Stashed changes
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
	public String getDiaryById(@PathVariable("diary_id") int diary_id, Model model) {

		System.out.println(" **** id ****" + diary_id);

		Diary diary = diaryService.getDiaryById(diary_id);
		log.info("=== diary === : " + diary);
		if (diary != null) {
			model.addAttribute("diary", diary);
			return "diaryView"; // 조회 페이지로 이동
		} else {
			return "redirect:/diaryWrite"; // 작성 페이지로 이동
		}

	}
	//after change => HttpSession         Anonymous-customer XXX
	@GetMapping("/diaryUpdate/{diary_id}")
	public String updateDiary(@PathVariable("diary_id") int diary_id, Model model) {
		Diary diary = diaryService.getDiaryById(diary_id);
		log.info(" update diary : " + diary);
		model.addAttribute("diary", diary);
		return "diaryUpdate";
	}
	@PostMapping("/diaryUpdate")
	public String updateDiary(@RequestParam("diary_title") String diary_title,
			@RequestParam("diary_contents") String diary_contents, @RequestParam("feelingCode") int diary_feelingCode,
			@RequestParam("weatherCode") int diary_weatherCode, @RequestParam("diary_fileurl") MultipartFile file) {

		diaryService.updateDiary(diary_title, diary_contents, diary_feelingCode, diary_weatherCode, file);
	    return "redirect:/diaryView";
	    }
	
	/*
	@GetMapping("/diaryView/{diary_id}")
	public String deleteDiary(diary_id)
	*/
}
