package ImageDiary.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ImageDiary.dto.SpecialDate;
@Mapper
public interface SpecialDateMapper {

	List<SpecialDate> getAllSpecialDate();
}
