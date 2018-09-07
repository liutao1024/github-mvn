package cn.spring.mvn.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author LiuTao @date 2018年5月13日 下午6:08:01
 * @ClassName: SysUser 
 * @Description: TODO(web系统登录柜员Entity)
 */
@Entity
@Table(name = "sys_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SysUser implements Serializable {
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 5190064355449202067L;
	
	/**详细介绍:https://blog.csdn.net/ARYBD/article/details/52065030
	 * 说明:1.@Id注解 表示实例该变量前在数据库表中该字段为主键,若某个表(实例)是联合主键(多个字段组成的主键),
	 * 	   	那么就在这些列(实例对应变量)加上@Id注解
	 * 	   2.@Column(name = "registCd", unique = true, nullable = false, length = 36)注解
	 * 		 name:表示在hibernate创建实例对象表时将name对应的值作为该列的列名
	 * 		 unique:true--该列是表的唯一索引且会创建该唯一索引,false--则不会
	 * 		 nullable:是否可为空true--可以,
	 * 		 length:该字段的长度,当该值未设置时hibernate会根据变量类型设置一个默认长度
	 * 	   3.@Transient注解:暂时没用过不知道?????????????
	 * 一般实例多是有多个字段组成的唯一索引,所以感觉unique基本不设置,因为只要有@Id注解时
	 * 想要重复插入就不行了,而nullable感觉当该字段有@Id注解时,最好还是设置为false,长度就随意了
	 * 关于这些注解可以加在变量上也可以加在变量对应的get方法上
	 * 在定义entity时,一般都会重写他们的hashCode,equals,toString方法
	 */
	@Id
	@Column(name = "regist_cd", nullable = false, length = 36)
	private String registCd;//机构代码
	@Id
	@Column(name = "userid", nullable = false, length = 36)
	private String userid ;//用户ID
	
	@Column(name = "userna", nullable = false, length = 36)
	private String userna;//用户名称
	@Column(name = "passwd", nullable = false)
	private String passwd;//密码
	@Column(name = "brchno", length = 36)
	private String brchno;//所属部门
	@Column(name = "errort")
	private int errort;//密码错误次数   密码输错最多错误5次
	@Column(name = "maxert")
	private int maxert;//密码最大错误次数
	@Column(name = "userst", length = 1)
	private String userst;//登录状态  0--未登录,1--已登录
	@Column(name = "status", length = 1)
	private String status;//状态  0--未启用,1--已启用
	@Column(name = "userlv", length = 24)
	private String userlv;//柜员等级
	
	public SysUser(){
		
	}
	
	public SysUser(String registCd, String userid){
		this.registCd = registCd;
		this.userid = userid;
	}

	public String getRegistCd() {
		return registCd;
	}

	public void setRegistCd(String registCd) {
		this.registCd = registCd;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserna() {
		return userna;
	}

	public void setUserna(String userna) {
		this.userna = userna;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getBrchno() {
		return brchno;
	}

	public void setBrchno(String brchno) {
		this.brchno = brchno;
	}

	public int getErrort() {
		return errort;
	}

	public void setErrort(int errort) {
		this.errort = errort;
	}

	public int getMaxert() {
		return maxert;
	}

	public void setMaxert(int maxert) {
		this.maxert = maxert;
	}

	public String getUserst() {
		return userst;
	}

	public void setUserst(String userst) {
		this.userst = userst;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserlv() {
		return userlv;
	}

	public void setUserlv(String userlv) {
		this.userlv = userlv;
	}

	/**
	 * 重写hashCode
	 */
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registCd == null) ? 0 : registCd.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	} 
	/**
	 * 重写equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysUser other = (SysUser) obj;
		if (registCd == null) {
			if (other.registCd != null){
				return false;
			}
		} else if (!registCd.equals(other.registCd)){
			return false;
		}
		if (userid == null) {
			if (other.userid != null){
				return false;
			}
		} else if (!userid.equals(other.userid)){
			return false;
		}
		return true;
	}
	/**
	 * 重写toString
	 */
	@Override
	public String toString(){
		return "SysUser [registCd = " + registCd + ", userid = " + userid + ", userna = " + userna + ", passwd = " + passwd + ", errort = " + errort + ", userst = " + userst + "]";
	}
}