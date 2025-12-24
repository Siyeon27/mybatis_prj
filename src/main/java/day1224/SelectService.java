package day1224;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class SelectService {
	private static SelectService ss;
	
	private SelectService() {}
	
	public static SelectService getInstance() {
		if(ss == null) {
			ss = new SelectService();
		}//end if
		
		return ss;
	}//getInstance
	
	/**
	 * 부서 번호를 입력하면 부서명을 검색
	 * @param deptno 부서번호
	 * @return 부서명
	 */
	public String scsr(int deptno) {
		String dname = "";
		
		SelectDAO sDAO = SelectDAO.getInstance();
		
		try {
			dname = sDAO.scsr(deptno);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return dname;
	}
	
	/**
	 * 부서번호를 입력하여 사원명 검색
	 * @param deptno
	 * @return
	 */
	public List<String> scmr(int deptno){
		List<String> list = null;
		
		SelectDAO sDAO = SelectDAO.getInstance();
		
		list = sDAO.scmr(deptno);
		
		return list;
	}
	
	/**
	 * 사원 번호를 입력받아 사원 정보를 검색
	 * @param empno
	 * @return
	 */
	public EmpDTO mcsr(int empno) {
		EmpDTO eDTO = null;
		
		SelectDAO sDAO = SelectDAO.getInstance();
		
		try {
			eDTO = sDAO.mcsr(empno);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return eDTO;
	}
	
	public List<EmpDTO> mcmr(int deptno){
		List<EmpDTO> list = null;
		
		SelectDAO sDAO = SelectDAO.getInstance();
		
		list = sDAO.mcmr(deptno);
		
		return list;
	}
}
