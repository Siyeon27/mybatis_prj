package kr.co.sist.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RangeDTO {
	private int startNum,endNum;//시작번호,끝번호
	private String field, keyword;//검색필드 1,2,3 , 검색 값
	private String fieldStr;//검색필드값에 대응되는 컬럼명의 문자열
	private String url;//이동할 URL
	private int currentPage=1;// 현재페이지
	private int totalPage=0;// 총페이지
	
	public String getFieldStr() {
		String[] fieldTitle= {"title","content","id"};
		int tempField=Integer.parseInt(field);
		if( !(tempField > 0 && tempField < 4) ) {//1~3사이가 아닌 경우
			tempField=1;
		}//end if
		fieldStr=fieldTitle[ tempField-1 ];
		return fieldStr;
	}

}
