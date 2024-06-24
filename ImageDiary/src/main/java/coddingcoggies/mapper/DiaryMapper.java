package coddingcoggies.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import coddingcoggies.dto.Diary;

@Mapper
public interface DiaryMapper {
	void insertDiary(Diary diary);
	
	List<Diary> getAllDiary();
}
