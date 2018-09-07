package cn.spring.mvn.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author LiuTao @date 2018年5月26日 上午11:51:16
 * @ClassName: SysRole 
 * @Description: 规则表
 */
@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "regist_cd")
	private String regist_cd;  //注册机构号
	@Id
	@Column(name = "auth_type")
	private String auth_type;  //权限类型
	@Id
	@Column(name = "role_cd")
	private String role_cd;  //角色编号
	
	@Column(name = "auth_cd")
	private String auth_cd;  //权限编号
	@Column(name = "role_name")
	private String role_name;  //角色名称

	public SysRole(){
		
	}
	
	public SysRole(String regist_cd, String auth_type, String role_cd){
		this.regist_cd = regist_cd;
		this.auth_type = auth_type;
		this.role_cd = role_cd;
	}
	
	
	public String getRegist_cd() {
		return regist_cd;
	}

	public void setRegist_cd(String regist_cd) {
		this.regist_cd = regist_cd;
	}

	public String getAuth_type() {
		return auth_type;
	}

	public void setAuth_type(String auth_type) {
		this.auth_type = auth_type;
	}

	public String getRole_cd() {
		return role_cd;
	}

	public void setRole_cd(String role_cd) {
		this.role_cd = role_cd;
	}

	public String getAuth_cd() {
		return auth_cd;
	}

	public void setAuth_cd(String auth_cd) {
		this.auth_cd = auth_cd;
	}
	
	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role_cd == null) ? 0 : role_cd.hashCode());
		result = prime * result + ((role_name == null) ? 0 : role_name.hashCode());
		result = prime * result + ((auth_cd == null) ? 0 : auth_cd.hashCode());
		result = prime * result + ((regist_cd == null) ? 0 : regist_cd.hashCode());
		result = prime * result + ((auth_type == null) ? 0 : auth_type.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysRole other = (SysRole) obj;
		if (auth_cd == null) {
			if (other.auth_cd != null)
				return false;
		} else if (!auth_cd.equals(other.auth_cd))
			return false;
		if (auth_type == null) {
			if (other.auth_type != null)
				return false;
		} else if (!auth_type.equals(other.auth_type))
			return false;
		if (regist_cd == null) {
			if (other.regist_cd != null)
				return false;
		} else if (!regist_cd.equals(other.regist_cd))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SysRole [regist_cd=" + regist_cd + ", auth_type=" + auth_type + ", auth_cd=" + auth_cd + ", role_cd=" + role_cd + ", role_name=" + role_name + "]";
	}
}
