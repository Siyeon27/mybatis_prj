package day1230;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import day1224.EmpDTO;
import day1226.CarModelDomain;
import day1226.EmpAllDomain;
import kr.co.sist.dao.MyBatisHandler;

public class SelectService4 {
	private static SelectService4 ss;
	
	private SelectService4() {}
	
	public static SelectService4 getInstance() {
		if(ss == null) {
			ss = new SelectService4();
		}//end if
		
		return ss;
	}//getInstance
	
	public List<EmpAllDomain> dynamicChoose(int deptno) throws PersistenceException {
		List<EmpAllDomain> empList = null;
		
		SelectDAO4 sDAO = SelectDAO4.getInstance();
		
		try {
			empList = sDAO.dynamicChoose(deptno);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return empList;
	}//dynamicChoose
	
	public List<Integer> searchAllEmpno() throws PersistenceException {
		List<Integer> empList = null;
		
		SelectDAO4 sDAO = SelectDAO4.getInstance();
		
		try {
			empList = sDAO.selectAllEmpno();
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return empList;
	}//searchAllEmpno
	
	public List<EmpAllDomain> dynamicForEach(String[] empnoArr) throws PersistenceException {
		List<EmpAllDomain> empList = null;
		
		SelectDAO4 sDAO = SelectDAO4.getInstance();
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("empnoArr", empnoArr);
			
			empList = sDAO.dynamicForEach(map);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return empList;
	}//dynamicChoose
	
	public int dynamicSet(EmpDTO eDTO) {
		int cnt = 0;
		
		SelectDAO4 sDAO = SelectDAO4.getInstance();
		
		try {
			cnt = sDAO.dynamicSet(eDTO);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return cnt;
	}
	
	public boolean transaction(TransactionDTO tDTO) {
		int cnt = 0;
		
		SelectDAO4 sDAO = SelectDAO4.getInstance();
		
		try {
			cnt = sDAO.transaction(tDTO);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return cnt == 2;
	}
	
}
