package coddingcoggies.object;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CalendarDay {
	private String dd;
	private String dayNum;
	private boolean diaryYN;
	private boolean specialDateYN;
	private int diary_id;
	private int specialDate_id;
	
	public CalendarDay() {
		this.dd = "";
		this.dayNum="";
		this.diaryYN=false;
		this.diary_id=-1;
		this.specialDate_id=-1;
		this.specialDateYN=false;
	}
}

