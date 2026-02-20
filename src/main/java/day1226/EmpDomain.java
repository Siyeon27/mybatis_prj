package day1226;

import java.sql.Date;

/**
 * MyBatis Framework에서 조회되는 레코드가 있을 때
 *  1. 기본 생성자로 생성해주고
 *  2. 조회되는 컬럼명과 일치하는 setter method를 호출하여 값을 설정
 *  3. JSP EL에서 ${getter명} 으로 사용된다
 */
public class EmpDomain {
	private String ename;
	private int empno, sal, comm;
	private Date hiredate;
	
	public EmpDomain() {
		System.out.println("MyBatis에 의해 EmpDomain 생성");
	}

	public String getEname() {
		System.out.println("JSP EL에서 ${ename} 사용");
		return ename;
	}

	public void setEname(String ename) {
		System.out.println("MyBatis에서 조회결과가 있을 때 setEname 사용");
		this.ename = ename;
	}

	public int getSal() {
		System.out.println("JSP EL에서 ${sal} 사용");
		return sal;
	}

	public void setSal(int sal) {
		System.out.println("MyBatis에서 조회결과가 있을 때 setSal 사용");
		this.sal = sal;
	}

	public int getComm() {
		System.out.println("JSP EL에서 ${comm} 사용");
		return comm;
	}

	public void setComm(int comm) {
		System.out.println("MyBatis에서 조회결과가 있을 때 setComm 사용");
		this.comm = comm;
	}

	public Date getHiredate() {
		System.out.println("JSP EL에서 ${hiredate} 사용");
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		System.out.println("MyBatis에서 조회결과가 있을 때 setHiredate 사용");
		this.hiredate = hiredate;
	}
	
	
}
