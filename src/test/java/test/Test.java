package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;

import day1231.MemberDTO;
import day1231.SelectDAO5;

public class Test {

	@org.junit.Test
	@DisplayName("select 테스트")
	public void test() {
//		SelectService ss = SelectService.getInstance();
//		SelectDAO sDAO = SelectDAO.getInstance();
		
//		assertNotNull(ss.scsr(10));
//		assertEquals(ss.scsr(10), "ACCOUNTING");
//		assertNotNull(ss.scmr(20));
		
//		EmpDTO eDTO = sDAO.mcsr(7788);
//		List<EmpDTO> list = sDAO.mcmr(10);
//		System.out.println(list);
//		assertEquals(list.size(), 3);
		
//		day1226.EmpDTO eDTO = new day1226.EmpDTO();
//		eDTO.setEmpno(7521);
//		eDTO.setDeptno(30);
		
//		SelectDAO3 sDAO = SelectDAO3.getInstance();
		
//		BoardDAO bDAO = BoardDAO.getInstance();
		SelectDAO5 sDAO = SelectDAO5.getInstance();
		
//		EmpDomain ed = sDAO.useDomain(eDTO);
		
//		assertNotNull(ed);
//		try {
//			assertNotNull(sDAO.join());
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		int[] empno = {7521, 7566, 7654, 7698};
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("empnoArr", empno);
		
//		EmpDTO e = new EmpDTO();
//		
//		e.setEmpno(7521);
//		e.setEname("ward");
		
//		MemberDTO m = new MemberDTO();
//		
//		m.setNum(43);
//		m.setName("렌고쿠");
//		m.setAge(35);
//		m.setGender("남성");
//		m.setTel("010-5555-3333");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
//		map.put("num", 42);
		
		sDAO.selectAllMember(map);
		
		List<Map<String, Object>> data = (List<Map<String, Object>>) map.get("searchAllMember");
		
		System.out.println(data);
		System.out.println(data.get(0).get("NAME"));
		
		assertNotNull(data);
	}
	
	
}
