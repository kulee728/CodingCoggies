package coddingcoggies.dto;

import coddingcoggies.object.CalendarDay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyCalanderInfo {
	private int member_no;
	private String mainHeaderText;
	private CalendarDay[] days;
}
