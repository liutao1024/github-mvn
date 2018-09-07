package cn.spring.mvn.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author LiuTao @date 2018年5月26日 上午11:50:45
 * @ClassName: SysUserRole 
 * @Description: 柜员角色表
 */
@Entity
@Table(name = "sys_user_role")
public class SysUserRole implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 4160905093796800576L;

	@Id
	@Column(name = "regist_cd")
	private String regist_cd;  //注册机构号
	@Id
	@Column(name = "auth_type")
	private String auth_type;  //权限类型
	@Id
	@Column(name = "role_cd")
	private String role_cd;  //角色号
	@Id
	@Column(name = "user_cd")
	private String user_cd;  //操作员号

	public SysUserRole(){
		
	}
	
	public SysUserRole(String regist_cd, String auth_type, String role_cd, String user_cd){
		this.regist_cd = regist_cd;
		this.auth_type = auth_type;
		this.role_cd = role_cd;
		this.user_cd = user_cd;
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

	public String getUser_cd() {
		return user_cd;
	}

	public void setUser_cd(String user_cd) {
		this.user_cd = user_cd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auth_type == null) ? 0 : auth_type.hashCode());
		result = prime * result + ((regist_cd == null) ? 0 : regist_cd.hashCode());
		result = prime * result + ((role_cd == null) ? 0 : role_cd.hashCode());
		result = prime * result + ((user_cd == null) ? 0 : user_cd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysUserRole other = (SysUserRole) obj;
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
		if (role_cd == null) {
			if (other.role_cd != null)
				return false;
		} else if (!role_cd.equals(other.role_cd))
			return false;
		if (user_cd == null) {
			if (other.user_cd != null)
				return false;
		} else if (!user_cd.equals(other.user_cd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SysUserRole [regist_cd=" + regist_cd + ", auth_type=" + auth_type + ", role_cd=" + role_cd + ", user_cd=" + user_cd + "]";
	}
	
	
}
