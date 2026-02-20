package kr.co.sist.board;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;

public class BoardDAO {
	private static BoardDAO bDAO;
	
	private BoardDAO() {
	}//BoardDAO
	
	public static BoardDAO getInstance() {
		if( bDAO == null) {
			bDAO=new BoardDAO();
		}//end if
		return bDAO;
	}//getInstance
	
	public int selectBoardTotalCnt( RangeDTO rDTO ) throws SQLException{
		int totalCnt=0;
		
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		totalCnt = ss.selectOne("kr.co.sist.board.selectBoardTotalCnt", rDTO);
		
		if(ss != null) { ss.close(); }
		
		return totalCnt;
	}//selectBoardTotalCnt
	
	public List<BoardDomain> selectRangeBoard( RangeDTO rDTO) throws SQLException{
		List<BoardDomain> list = null;
		
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(false);
		
		list = ss.selectList("kr.co.sist.board.selectRangeBoard", rDTO);
		
		if(ss != null) { ss.close(); }
		
		return list;
	}//selectRangeBoard
	
	public void insertBoard( BoardDTO bDTO)throws PersistenceException{
		//1. MyBatis Handler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(true);
		
		//2. 쿼리문 수행 후 결과 얻기
		ss.insert("kr.co.sist.board.insertBoard", bDTO);
		
		//3. 결과로 작업
		//4. MyBatis Handler 닫기
		if(ss != null) { ss.close(); }
		
	}//insertBoard
	
	public BoardDomain selectBoardDetail(int num) throws SQLException{
		BoardDomain bDomain=null;
		
		//1. MyBatis Handler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(true);
				
		//2. 쿼리문 수행 후 결과 얻기
		bDomain = ss.selectOne("kr.co.sist.board.selectBoardDetail", num);
				
		//3. 결과로 작업
		//4. MyBatis Handler 닫기
		if(ss != null) { ss.close(); }
				
		return bDomain;
	}//selectBoardDetail
	
	/**
	 * 게시글 읽기했을 때 cnt 증가
	 * @param num
	 * @throws SQLException
	 */
	public void updateBoardCnt(int num) throws SQLException{
		//1. MyBatis Handler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(true);
				
		//2. 쿼리문 수행 후 결과 얻기
		ss.update("kr.co.sist.board.updateBoardCnt", num);
				
		//3. 결과로 작업
		//4. MyBatis Handler 닫기
		if(ss != null) { ss.close(); }
		
	}//updateBoardCnt
	
	public int updateBoard( BoardDTO bDTO)throws SQLException{
		int cnt=0;
		
		//1. MyBatis Handler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(true);
						
		//2. 쿼리문 수행 후 결과 얻기
		cnt = ss.update("kr.co.sist.board.updateBoard", bDTO);
						
		//3. 결과로 작업
		//4. MyBatis Handler 닫기
		if(ss != null) { ss.close(); }
		
		return cnt;
	}//updateBoard
	
	public int deleteBoard( BoardDTO bDTO )throws SQLException{
		int cnt=0;

		//1. MyBatis Handler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(true);
						
		//2. 쿼리문 수행 후 결과 얻기
		cnt = ss.delete("kr.co.sist.board.deleteBoard", bDTO);
						
		//3. 결과로 작업
		//4. MyBatis Handler 닫기
		if(ss != null) { ss.close(); }
		
		return cnt;
	}//updateBoard
	
	
}//class









