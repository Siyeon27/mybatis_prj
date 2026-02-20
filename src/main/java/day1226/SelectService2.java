package day1226;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class SelectService2 {
	private static SelectService2 ss;
	
	private SelectService2() {}
	
	public static SelectService2 getInstance() {
		if(ss == null) {
			ss = new SelectService2();
		}//end if
		
		return ss;
	}//getInstance
	
	/**
	 * 부서 번호와 사원 번호를 입력받아 사원 정보를 검색
	 * @param empno
	 * @return
	 */
	public EmpDomain useDomain(EmpDTO empDTO) {
		EmpDomain empDomain = null;
		
		SelectDAO2 sDAO = SelectDAO2.getInstance();
		
		try {
			empDomain = sDAO.useDomain(empDTO);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return empDomain;
	}
	
	public List<ZipcodeDomain> useLike(String dong) {
		List<ZipcodeDomain> zipDomain = null;
		
		SelectDAO2 sDAO = SelectDAO2.getInstance();
		
		try {
			zipDomain = sDAO.useLike(dong);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return zipDomain;
	}
	
	public List<EmpDomain> lessThan(int sal) {
		List<EmpDomain> empList = null;
		
		SelectDAO2 sDAO = SelectDAO2.getInstance();
		
		try {
			empList = sDAO.lessThan(sal);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return empList;
	}
	
	public List<EmpDomain> greaterThan(int sal) {
		List<EmpDomain> empList = null;
		
		SelectDAO2 sDAO = SelectDAO2.getInstance();
		
		try {
			empList = sDAO.greaterThan(sal);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return empList;
	}
	
	public List<EmpDomain> subquery() {
		List<EmpDomain> empList = null;
		
		SelectDAO2 sDAO = SelectDAO2.getInstance();
		
		try {
			empList = sDAO.subquery();
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return empList;
	}
	
	public List<EmpAllDomain> union() {
		List<EmpAllDomain> empList = null;
		
		SelectDAO2 sDAO = SelectDAO2.getInstance();
		
		try {
			empList = sDAO.union();
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return empList;
	}
	
	public List<CarModelDomain> join() {
		List<CarModelDomain> carList = null;
		
		SelectDAO2 sDAO = SelectDAO2.getInstance();
		
		try {
			carList = sDAO.join();
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return carList;
	}
	
}
