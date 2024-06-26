package coddingcoggies.object;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CalanderDay {
	private String yyyyMMdd;
	private boolean diaryYN;
	private boolean specialDayYN;
}
