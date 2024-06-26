package coddingcoggies.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

<<<<<<< Updated upstream
import coddingcoggies.dto.SpecialDate;
=======
import coddingcoggies.dto.Diary;
import coddingcoggies.dto.DiaryLogin;
import coddingcoggies.dto.SpecialDate;
import coddingcoggies.object.CalendarDay;
>>>>>>> Stashed changes
import coddingcoggies.service.MainPageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainPageController {

	@Autowired
	private MainPageService mainPageService;
<<<<<<< Updated upstream
	
	
	
	@GetMapping("/TeachersGift")
	public String showMainContents(Model model) {
=======
		
	@GetMapping("/diaryMain")
	public String showMainContents(Model model, HttpSession session) {
>>>>>>> Stashed changes
		
		//List<SpecialDate> specialDateList = mainPageService.getAllSpecialDate();
		//log.info(specialDateList.toString());
		//model.addAttribute("specialDateList",specialDateList);
		
<<<<<<< Updated upstream
		//model.addAttribute("mainHeaderText",dd)
		//나중에는 세션으로 받아서 뿌려야 함
		
		
		getAllSpecialDate(model);
=======
		//헤더
		String todayHeader = year+"년 "+month+"월";
		model.addAttribute("todayHeader",todayHeader);
		model.addAttribute("todayInfo",
				"오늘은 "+year+"-"+String.format("%02d",month)+"-"+String.format("%02d",day));
		//헤더 끝
		

		//member_no에 일치하는 diaryList, specialDateList 가져오기
		List<Diary> diaryList = mainPageService.getAllDiaryByMemberNo(diaryLogin.getMember_no());
		List<SpecialDate> specialDateList = mainPageService.getAllSpecialDateByMemberNo(diaryLogin.getMember_no());
				
		//달력 그리기
		String [] dayNameList = {"일","월","화","수","목","금","토"};
		model.addAttribute("dayNameList",dayNameList);
		mainCalandarDayDrawer(model,session,year,month,diaryList,specialDateList);//이달의 날짜,model,session 넘기고 조회
		
		
		//달력 그리기 끝
		

		mainPageGetAllSpecialDate(model,diaryLogin.getMember_no());
>>>>>>> Stashed changes
		//mainCalandar.specialDateAdded(model);
		return "TeachersGift";
	}
	
<<<<<<< Updated upstream
=======
	private void mainCalandarDayDrawer(Model model, HttpSession session, int year, int month
			, List<Diary> diaryList,List<SpecialDate> specialList ) {
		
		
		Calendar cal = Calendar.getInstance(); //이번달 첫 날 구하기
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);  //추후 날짜가 바뀔 것을 대비..
		
		//cal.set(Calendar.DAY_OF_MONTH,1);
		int dateStartPos = cal.get(Calendar.DAY_OF_WEEK);
		CalendarDay [] days = new CalendarDay[42]; //나중에 사이즈로 바꿔주자
		int dayNum=1; //1부터 최대 31까지 할당되는 값
		for(int i=0;i<days.length;i++) {
			days[i] = new CalendarDay();
			//첫 날의 요일위치.토요일은 6이다. log.info("dateStartPos : "+dateStartPos);
			if(i>=dateStartPos && dayNum<cal.getActualMaximum(Calendar.DAY_OF_MONTH)) { //0이면 일요일부터 시작하는 달, days[0]일요일 days[6]금요일 고정
				String yyyyMMdd = String.valueOf(year) 
						+ String.format("%02d",month)+String.format("%02d",dayNum);
				for(Diary d : diaryList) {
					if((d.getDiary_date()).equals(yyyyMMdd)) {
						days[i].setDiaryYN(true);
						days[i].setDiary_id(d.getDiary_id());
						log.info("다이어리 true : "+d.toString());
						log.info("days true : "+days[i].toString());
						 log.info("*****diaryYN  date: " + yyyyMMdd);
						break;
					}
				}
				for(SpecialDate sd : specialList) {
					if((sd.getSpecialDate_date()).equals(yyyyMMdd)) {
						days[i].setSpecialDateYN(true);
						days[i].setSpecialDate_id(sd.getSpecialDate_id());
						break;
					}
				}				
				//20240623 등 날짜에 대한 다이어리,기념일을 검색한다.
				days[i].setDayNum(Integer.toString(dayNum++));
			}
		}
		//첫날의 요일과 해당 달의 날수를 계산한다.
		//첫날의 요일에 해당되는 index
		
		
		model.addAttribute("mainCalendardays",days);
		

	}

>>>>>>> Stashed changes
	/*
	 기념일 영역
	 1) 기념일 select * from specialDate > 목록 표시
	 2) 기념일.displayText 에 대한 값 계산 (D-95, 혹은 2015-07-30)
	 */
<<<<<<< Updated upstream
	public void getAllSpecialDate(Model model) {
		List<SpecialDate> specialDateList = mainPageService.getAllSpecialDate();
=======
	private void mainPageGetAllSpecialDate(Model model,int member_no) {
		List<SpecialDate> specialDateList = mainPageService.getAllSpecialDateByMemberNo(member_no);
>>>>>>> Stashed changes
		
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
