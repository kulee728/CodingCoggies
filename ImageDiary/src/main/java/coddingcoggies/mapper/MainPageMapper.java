package coddingcoggies.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import coddingcoggies.dto.SpecialDate;
@Mapper
public interface MainPageMapper {

	List<SpecialDate> getAllSpecialDate();
}
