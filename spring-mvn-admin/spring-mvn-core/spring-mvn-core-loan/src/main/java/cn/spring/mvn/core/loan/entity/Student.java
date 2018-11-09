package cn.spring.mvn.core.loan.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Table(name = "student")//
public class Student implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 2160476662517089396L;
	
	@Id
	@GeneratedValue(generator = "JDBC")//自增长,MYSQL
	private Long id;

	private String no;
	
	private String name;
	
	private Integer age;
	
	private Character sex;//F,M
	
//	private String IDNUMBER;
//	@Transient
	private String birth;
	
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

//	public String getIdentityCarNo() {
//		return identityCarNo;
//	}
//
//	public void setIdentityCarNo(String identityCarNo) {
//		this.identityCarNo = identityCarNo;
//	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", no=" + no + ", name=" + name + ", age="
				+ age + ", sex=" + sex + ", birth=" + birth + ", phone="
				+ phone + "]";
	}
	
	
	
}
