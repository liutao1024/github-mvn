package cn.spring.mvn.web.test;

import cn.spring.mvn.basic.ibatis.IBatisTParam;
import cn.spring.mvn.core.loan.entity.Student;

//import org.junit.Test;
//
//import cn.spring.mvn.core.loan.Loan;
public class WebTest {
	

//	@Test
//	public void Test001(){
//		Loan.print();
//	}

	public static void main(String[] args) {
		Test002();
	}
	
	private static void Test002() {
		Student s = new Student();
		s.setName("liutao");
		IBatisTParam<Student> i = new IBatisTParam<Student>(s, 1, 2, "", "");
		System.out.println(i);
	}
}
