package ImageDiary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ImageDiary.dto.Diary;
import ImageDiary.mapper.DiaryMapper;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DiaryService {
	
	@Autowired
	private DiaryMapper diaryMapper;
	
	/*
	public Diary getDiary(String diary_title, int diary_feelingCode,
				   		  int diary_weaterCode, String diary_contents, 
				   		  String diary_fileurl) {
		return diaryMapper.getDiary(diary_title, diary_feelingCode, diary_weaterCode, diary_contents, diary_fileurl);
	}
	*/
	
	//일기 작성
	
	public void insertDiary(Diary diary) {
		diaryMapper.insertDiary(diary);	
	}
	
	public void insertDiary(String diary_title, String diary_contents, int diary_feelingCode, int diary_weatherCode) {
		Diary diary = new Diary();
		diary.setDiary_title(diary_title);
		diary.setDiary_contents(diary_contents);
		diary.setDiary_feelingCode(diary_feelingCode);
		diary.setDiary_weatherCode(diary_weatherCode);
		diaryMapper.insertDiary(diary);
		log.info(diary.toString());
	}
	
	//일기 수정
	public void updateDiary(Diary diary) {
		diaryMapper.updateDiary(diary);
	}
	
	//일기 삭제
	public void deleteDiary(int diary_id) {
		diaryMapper.deleteDiary(diary_id);
	}
	
	public List<Diary> getAllDiary(){
		return diaryMapper.getAllDiary();
	}

}
