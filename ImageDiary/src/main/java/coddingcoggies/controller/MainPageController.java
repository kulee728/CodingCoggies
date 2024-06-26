package coddingcoggies.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import coddingcoggies.dto.DiaryLogin;
import coddingcoggies.dto.SpecialDate;
import coddingcoggies.object.CalanderDay;
import coddingcoggies.service.MainPageService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainPageController {

	@Autowired
	private MainPageService mainPageService;
	
	
	
	@GetMapping("/diaryMain")
	public String showMainContents(Model model, HttpSession session) {
		
		DiaryLogin diaryLogin = (DiaryLogin)session.getAttribute("loginSession");
		if(diaryLogin==null) {
			return "redirect:/";
		}
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR); 
		int month=cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		
		//헤더
		String todayHeader = year+"년 "+month+"월";
		model.addAttribute("todayHeader",todayHeader);
		model.addAttribute("todayInfo",
				"오늘은 "+year+"-"+String.format("%02d",month)+"-"+String.format("0%2d",day));
		//헤더 끝
		
		//달력 그리기
		String [] dayNameList = {"일","월","화","수","목","금","토"};
		model.addAttribute("dayNameList",dayNameList);
		
		mainCalandarDayDrawer(model,session,year,month);//이달의 날짜,model,session 넘기고 조회
		
		
		//달력 그리기 끝
		

		getAllSpecialDate(model);
		//mainCalandar.specialDateAdded(model);
		return "diaryMain";
	}
	
	private void mainCalandarDayDrawer(Model model, HttpSession session, int year, int month ) {
		
		CalanderDay [] days = new CalanderDay[31]; //나중에 사이즈로 바꿔주자
		
		model.addAttribute(days)
		
		//if()
	}

	/*
	 기념일 영역
	 1) 기념일 select * from specialDate > 목록 표시
	 2) 기념일.displayText 에 대한 값 계산 (D-95, 혹은 2015-07-30)
	 */
	private void getAllSpecialDate(Model model) {
		List<SpecialDate> specialDateList = mainPageService.getAllSpecialDate();
		
		for(SpecialDate sd : specialDateList) {
			if(sd.getSpecialDate_type()==1){{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
				LocalDate dDay_date = LocalDate.parse(sd.getSpecialDate_date(), formatter);
				LocalDate today_date = LocalDate.now();
				sd.setDateDisplayText("D"+DAYS.between(dDay_date, today_date));
			}	
			}
			else if(sd.getSpecialDate_type()==2) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
				sd.setDateDisplayText(LocalDate.parse(sd.getSpecialDate_date(), formatter).toString());
			}
		}
		
		model.addAttribute("specialDateList",specialDateList);
	}
	
	
	
	
	
	
}
