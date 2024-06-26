package ImageDiary.object;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CalanderDay {
	private String yyyyMMdd;
	private int dayNum;
	private boolean diaryYN;
	private boolean specialDateYN;
}
