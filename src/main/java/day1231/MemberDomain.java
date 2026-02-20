package day1231;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDomain {
	public int num, age;
	public String name, gender, tel;
	public Date input_date;
	private Timestamp inputDate;
}
