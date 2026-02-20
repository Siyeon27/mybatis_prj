package day1231;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectService5 {
	private static SelectService5 ss;
	
	private SelectService5() {}
	
	public static SelectService5 getInstance() {
		if(ss == null) {
			ss = new SelectService5();
		}//end if
		
		return ss;
	}//getInstance
	
	public void addMember(MemberDTO mDTO) {
		SelectDAO5 sDAO = SelectDAO5.getInstance();
		
		sDAO.insertMember(mDTO);
	}//addMember
	
	public void modifyMember(MemberDTO mDTO) {
		SelectDAO5 sDAO = SelectDAO5.getInstance();
		
		sDAO.updateMember(mDTO);
	}//modifyMember
	
	public void removeMember(MemberDTO mDTO) {
		SelectDAO5 sDAO = SelectDAO5.getInstance();
		
		sDAO.deleteMember(mDTO);
	}//removeMember
	
	public MemberDomain searchOneMember(int num) {
		MemberDomain md = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("num", num);
		
		SelectDAO5 sDAO = SelectDAO5.getInstance();
		
		sDAO.selectOneMember(map);
		
		//숫자: BigDecimal, 문자열: String, 날짜: Timestamp
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("searchMember");
		
		//검색 결과가 있다면 list 방에 값이 들어있고,
		//검색 결과가 없다면 list는 생성되지만 방에 값이 들어있지 않다
		if(!list.isEmpty()) {
			Map<String, Object> resultMap = list.get(0);
			md = new MemberDomain();
			
			md.setName((String) resultMap.get("NAME"));
			BigDecimal bdAge = (BigDecimal)resultMap.get("AGE");
			int age = 0;
			
			if(bdAge != null) {
				age = bdAge.intValue();
			}
			
			md.setAge(age);
			md.setGender((String)resultMap.get("GENDER"));
			md.setTel((String)resultMap.get("TEL"));
			md.setInputDate((Timestamp)resultMap.get("INPUT_DATE"));
		}
		
		return md;
	}//searchOneMember
	
	public List<MemberDomain> searchAllMember(){
		List<MemberDomain> list = new ArrayList<MemberDomain>();
		
		SelectDAO5 sDAO = SelectDAO5.getInstance();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		sDAO.selectAllMember(map);
		
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) map.get("searchAllMember");
		
		BigDecimal bdAge = null;
		MemberDomain md = null;
		int age = 0;
		Timestamp ts = null;
		
		for(Map<String, Object> dataMap : dataList) {
			md = new MemberDomain();
			
			md.setNum(((BigDecimal)dataMap.get("NUM")).intValue());
			md.setName((String) dataMap.get("NAME"));
			bdAge = (BigDecimal)dataMap.get("AGE");
			
			if(bdAge != null) {
				age = bdAge.intValue();
			}
			
			md.setAge(age);
			md.setGender((String)dataMap.get("GENDER"));
			md.setTel((String)dataMap.get("TEL"));
			
			ts = (Timestamp)dataMap.get("INPUT_DATE");
			
			md.setInputDate(ts);
			
			if(ts != null) {
				//java.sql.Date 객체 할당
				md.setInput_date(new Date(ts.getTime()));
			}
			
			list.add(md);
		}
		
		return list;
	}//searchAllMember
	
	public static void main(String[] args) {
		SelectService5 ss = new SelectService5();
		
		System.out.println(ss.searchAllMember());
	}
}
