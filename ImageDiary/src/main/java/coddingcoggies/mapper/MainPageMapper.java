package coddingcoggies.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import coddingcoggies.dto.SpecialDate;
@Mapper
public interface MainPageMapper {

<<<<<<< Updated upstream
	List<SpecialDate> getAllSpecialDate();
=======
	List<SpecialDate> getAllSpecialDateByMemberNo(int member_no);
	List <Diary> getAllDiaryByMemberNo(int member_no);
>>>>>>> Stashed changes
}
