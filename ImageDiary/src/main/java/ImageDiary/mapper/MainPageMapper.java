package ImageDiary.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ImageDiary.dto.Diary;
import ImageDiary.dto.SpecialDate;

@Mapper
public interface MainPageMapper {

	List<SpecialDate> getAllSpecialDate();
	List <Diary> getAllDiaryByMemberNo(int member_no);
}
