package day1231;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	public int num, age, cnt;
	public String name, gender, tel, errMsg;
	public Date input_date;
}
