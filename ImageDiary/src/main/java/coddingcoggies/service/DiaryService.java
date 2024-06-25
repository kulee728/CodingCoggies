package coddingcoggies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import coddingcoggies.dto.Diary;
import coddingcoggies.mapper.DiaryMapper;

public class DiaryService {
	@Autowired
	private DiaryMapper diaryMapper;
	
	public void insertDiary(Diary diary) {
		diaryMapper.insertDiary(diary);	
	}
	
	public List<Diary> getAllDiary(){
		return diaryMapper.getAllDiary();
	}

}
