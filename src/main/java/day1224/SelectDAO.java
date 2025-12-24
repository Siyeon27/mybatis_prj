package day1224;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;

public class SelectDAO {
	private static SelectDAO sDAO;
	
	private SelectDAO() {}
	
	public static SelectDAO getInstance() {
		if(sDAO == null) {
			sDAO = new SelectDAO();
		}//end if
		
		return sDAO;
	}//getInstance
	
	/**
	 * 컬럼 하나에 한 행 조회
	 * @param deptno 부서번호
	 * @return 부서명
	 */
	public String scsr(int deptno) throws PersistenceException {
		String dname = "";
		
		//select는 트랜지션 대상 쿼리가 아니므로 false/true 상관없음
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		dname = ss.selectOne("day1224.scsr", deptno);
		
		if(ss != null) {
			ss.close();
		}
		
		return dname;
	}
	
	/**
	 * 부서번호르 ㄹ입력받아서 해다 ㅇ무서에 속한 모든 사원병을 검색
	 * @param dept
	 * @return
	 * @throws PersistenceException
	 */
	public List<String> scmr(int dept) throws PersistenceException{
		List<String> list = null;
		
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		list = ss.selectList("day1224.scmr", dept);
		
		if(ss != null) {
			ss.close();
		}
		
		
		return list;
	}
	
	/**
	 * 사원 번호에 대한 사원정보 조회
	 * @param empno
	 * @return
	 * @throws PersistenceException
	 */
	public EmpDTO mcsr(int empno) throws PersistenceException {
		EmpDTO eDTO = null;
		
		//select는 트랜지션 대상 쿼리가 아니므로 false/true 상관없음
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		eDTO = ss.selectOne("day1224.mcsr", empno);
		
		if(ss != null) {
			ss.close();
		}
		
		return eDTO;
	}
	
	public List<EmpDTO> mcmr(int dept) throws PersistenceException{
		List<EmpDTO> list = null;
		
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		list = ss.selectList("day1224.mcmr", dept);
		
		if(ss != null) {
			ss.close();
		}
		
		
		return list;
	}
}
