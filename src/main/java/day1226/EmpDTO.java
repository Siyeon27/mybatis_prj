package day1226;

/**
 * insert에 추가되는 값, update의 변경값, where절에서 사용하는 값, delete의 기준값
 * select where절에서 사용하는 값
 * 
 * <jsp:useBean> : 기본 생성자를 사용하여 객체화를 하고
 * <jsp:setProperty>: setter method를 통해 입력값이 저장
 * MyBatis에서는 parameterType="EmpDTO" 입력받아서 #{getter}로 사용
 */
public class EmpDTO {
	private int deptno, empno;

	public EmpDTO() {
		System.out.println("<jsp:useBean>에 의해 객체화");
	}

	public int getDeptno() {
		System.out.println("MyBatis에서 #{deptno}로 사용됨");
		return deptno;
	}

	public void setDeptno(int deptno) {
		System.out.println("<jsp:setProperty>에서 사용");
		this.deptno = deptno;
	}

	public int getEmpno() {
		System.out.println("MyBatis에서 #{empno}로 사용됨");
		return empno;
	}

	public void setEmpno(int empno) {
		System.out.println("<jsp:setProperty>에서 사용");
		this.empno = empno;
	}
	
	
}
