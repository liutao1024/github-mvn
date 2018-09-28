package cn.spring.mvn.web.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sys_auth")
public class SysAuth implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = -4544022173756029292L;
	
	@Id
	@Column(name = "regist_cd")
	private String regist_cd;
	
	@Id
	@Column(name = "auth_type")
	private String auth_type;
	
	@Id
	@Column(name = "auth_cd")
	private String auth_cd;
	
	@Column(name = "menu_name")
	private String menu_name;
	@Column(name = "auth_url")
	private String auth_url;
	
	@Column(name = "parent_auth_cd")
	private String parent_auth_cd;
	
	
	@Column(name = "rank")
	private int rank;
	@Column(name = "sortno")
	private String sortno;
	@Column(name = "iconfg")
	private String iconfg;
	@Column(name = "target_flag")
	private String target_flag;
	
	@Transient
	private List<SysAuth> children;
	@Transient
	private String haschild;
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
	public String getAuth_cd() {
		return auth_cd;
	}
	public void setAuth_cd(String auth_cd) {
		this.auth_cd = auth_cd;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getAuth_url() {
		return auth_url;
	}
	public void setAuth_url(String auth_url) {
		this.auth_url = auth_url;
	}
	public String getParent_auth_cd() {
		return parent_auth_cd;
	}
	public void setParent_auth_cd(String parent_auth_cd) {
		this.parent_auth_cd = parent_auth_cd;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getSortno() {
		return sortno;
	}
	public void setSortno(String sortno) {
		this.sortno = sortno;
	}
	public String getIconfg() {
		return iconfg;
	}
	public void setIconfg(String iconfg) {
		this.iconfg = iconfg;
	}
	public List<SysAuth> getChildren() {
		return children;
	}
	public void setChildren(List<SysAuth> children) {
		this.children = children;
	}
	public String getHaschild() {
		return haschild;
	}
	public void setHaschild(String haschild) {
		this.haschild = haschild;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auth_cd == null) ? 0 : auth_cd.hashCode());
		result = prime * result
				+ ((auth_type == null) ? 0 : auth_type.hashCode());
		result = prime * result
				+ ((auth_url == null) ? 0 : auth_url.hashCode());
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result
				+ ((haschild == null) ? 0 : haschild.hashCode());
		result = prime * result + ((iconfg == null) ? 0 : iconfg.hashCode());
		result = prime * result
				+ ((menu_name == null) ? 0 : menu_name.hashCode());
		result = prime * result
				+ ((parent_auth_cd == null) ? 0 : parent_auth_cd.hashCode());
		result = prime * result + rank;
		result = prime * result
				+ ((regist_cd == null) ? 0 : regist_cd.hashCode());
		result = prime * result + ((sortno == null) ? 0 : sortno.hashCode());
		result = prime * result
				+ ((target_flag == null) ? 0 : target_flag.hashCode());
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
		SysAuth other = (SysAuth) obj;
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
		if (auth_url == null) {
			if (other.auth_url != null)
				return false;
		} else if (!auth_url.equals(other.auth_url))
			return false;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (haschild == null) {
			if (other.haschild != null)
				return false;
		} else if (!haschild.equals(other.haschild))
			return false;
		if (iconfg == null) {
			if (other.iconfg != null)
				return false;
		} else if (!iconfg.equals(other.iconfg))
			return false;
		if (menu_name == null) {
			if (other.menu_name != null)
				return false;
		} else if (!menu_name.equals(other.menu_name))
			return false;
		if (parent_auth_cd == null) {
			if (other.parent_auth_cd != null)
				return false;
		} else if (!parent_auth_cd.equals(other.parent_auth_cd))
			return false;
		if (rank != other.rank)
			return false;
		if (regist_cd == null) {
			if (other.regist_cd != null)
				return false;
		} else if (!regist_cd.equals(other.regist_cd))
			return false;
		if (sortno == null) {
			if (other.sortno != null)
				return false;
		} else if (!sortno.equals(other.sortno))
			return false;
		if (target_flag == null) {
			if (other.target_flag != null)
				return false;
		} else if (!target_flag.equals(other.target_flag))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SysAuth [regist_cd=" + regist_cd + ", auth_type=" + auth_type
				+ ", auth_cd=" + auth_cd + ", menu_name=" + menu_name
				+ ", auth_url=" + auth_url + ", parent_auth_cd="
				+ parent_auth_cd + ", rank=" + rank + ", sortno=" + sortno
				+ ", iconfg=" + iconfg + ", target_flag=" + target_flag
				+ ", children=" + children + ", haschild=" + haschild + "]";
	}
}
