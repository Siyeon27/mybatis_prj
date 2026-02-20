package day1230;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import day1224.EmpDTO;
import day1226.CarModelDomain;
import day1226.EmpAllDomain;
import kr.co.sist.dao.MyBatisHandler;

public class SelectDAO4 {
	private static SelectDAO4 sDAO;
	
	private SelectDAO4() {}
	
	public static SelectDAO4 getInstance() {
		if(sDAO == null) {
			sDAO = new SelectDAO4();
		}//end if
		
		return sDAO;
	}//getInstance
	
	public List<EmpAllDomain> dynamicChoose(int deptno) throws PersistenceException {
		List<EmpAllDomain> empList = null;
		
		//select는 트랜지션 대상 쿼리가 아니므로 false/true 상관없음
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		empList = ss.selectList("day1230.dynamicChoose", deptno);
		
		if(ss != null) {
			ss.close();
		}
		
		return empList;
	}//dynamicChoose
	
	public List<Integer> selectAllEmpno() throws PersistenceException {
		List<Integer> empList = null;
		
		//select는 트랜지션 대상 쿼리가 아니므로 false/true 상관없음
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		empList = ss.selectList("day1230.selectAllEmpno");
		
		if(ss != null) {
			ss.close();
		}
		
		return empList;
	}//selectAllEmpno
	
	public List<EmpAllDomain> dynamicForEach(Map<String, Object> empMap) throws PersistenceException {
		List<EmpAllDomain> empList = null;
		
		//select는 트랜지션 대상 쿼리가 아니므로 false/true 상관없음
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		empList = ss.selectList("day1230.dynamicForEach", empMap);
		
		if(ss != null) {
			ss.close();
		}
		
		return empList;
	}//dynamicForEach
	
	public int dynamicSet(EmpDTO eDTO) throws PersistenceException {
		int cnt = 0;
		
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(true);
		
		cnt = ss.update("day1230.dynamicSet", eDTO);
		
		if(ss != null) { ss.close(); }
		
		return cnt;
	}//dynamicSet
	
	public int transaction(TransactionDTO tDTO) throws PersistenceException {
		int cnt = 0;
		
		//autocommit을 해제한 상태로 MyBatisHandler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		//transaction 관련 쿼리를 한 번에 실행
		cnt = ss.insert("day1230.trans1", tDTO);
		cnt += ss.insert("day1230.trans2", tDTO);
		
		//각각 실행한 행 수가 목표로 한 행수라면
		if(cnt == 2) {
			System.out.println("insert commit");
			ss.commit();
		} else {
			System.out.println("insert rollback");
			ss.rollback();
		}
		
		if(ss != null) { ss.close(); }
		
		return cnt;
	}//transaction
	
	public int transaction2(TransactionDTO tDTO) throws PersistenceException {
		int cnt = 0;
		
		//autocommit을 해제한 상태로 MyBatisHandler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		//transaction 관련 쿼리를 한 번에 실행
		cnt = ss.update("day1230.upTrans1", tDTO);
		cnt += ss.update("day1230.upTrans2", tDTO);
		
		//각각 실행한 행 수가 목표로 한 행수라면
		if(cnt == 2) {
			System.out.println("update commit");
			ss.commit();
		} else {
			System.out.println("update rollback");
			ss.rollback();
		}
		
		if(ss != null) { ss.close(); }
		
		return cnt;
	}//transaction2
}


