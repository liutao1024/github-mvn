package cn.spring.mvn.base.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_param")
public class SystemParam implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = -7729013150037680909L;
	
	@Id
	@Column(name = "paramcd", nullable = false, length = 24)
	private String paramCd;
	@Column(name = "paramKey1")
	private String paramKey1;
	@Column(name = "paramKey2")
	private String paramKey2;
	@Column(name = "paramKey3")
	private String paramKey3;
	@Column(name = "paramValue1")
	private String paramValue1;
	@Column(name = "paramValue2")
	private String paramValue2;
	@Column(name = "paramValue3")
	private String paramValue3;
	
	public String getParamCd() {
		return paramCd;
	}
	public void setParamCd(String paramCd) {
		this.paramCd = paramCd;
	}
	public String getParamKey1() {
		return paramKey1;
	}
	public void setParamKey1(String paramKey1) {
		this.paramKey1 = paramKey1;
	}
	public String getParamKey2() {
		return paramKey2;
	}
	public void setParamKey2(String paramKey2) {
		this.paramKey2 = paramKey2;
	}
	public String getParamKey3() {
		return paramKey3;
	}
	public void setParamKey3(String paramKey3) {
		this.paramKey3 = paramKey3;
	}
	public String getParamValue1() {
		return paramValue1;
	}
	public void setParamValue1(String paramValue1) {
		this.paramValue1 = paramValue1;
	}
	public String getParamValue2() {
		return paramValue2;
	}
	public void setParamValue2(String paramValue2) {
		this.paramValue2 = paramValue2;
	}
	public String getParamValue3() {
		return paramValue3;
	}
	public void setParamValue3(String paramValue3) {
		this.paramValue3 = paramValue3;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paramCd == null) ? 0 : paramCd.hashCode());
		result = prime * result
				+ ((paramKey1 == null) ? 0 : paramKey1.hashCode());
		result = prime * result
				+ ((paramKey2 == null) ? 0 : paramKey2.hashCode());
		result = prime * result
				+ ((paramKey3 == null) ? 0 : paramKey3.hashCode());
		result = prime * result
				+ ((paramValue1 == null) ? 0 : paramValue1.hashCode());
		result = prime * result
				+ ((paramValue2 == null) ? 0 : paramValue2.hashCode());
		result = prime * result
				+ ((paramValue3 == null) ? 0 : paramValue3.hashCode());
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
		SystemParam other = (SystemParam) obj;
		if (paramCd == null) {
			if (other.paramCd != null)
				return false;
		} else if (!paramCd.equals(other.paramCd))
			return false;
		if (paramKey1 == null) {
			if (other.paramKey1 != null)
				return false;
		} else if (!paramKey1.equals(other.paramKey1))
			return false;
		if (paramKey2 == null) {
			if (other.paramKey2 != null)
				return false;
		} else if (!paramKey2.equals(other.paramKey2))
			return false;
		if (paramKey3 == null) {
			if (other.paramKey3 != null)
				return false;
		} else if (!paramKey3.equals(other.paramKey3))
			return false;
		if (paramValue1 == null) {
			if (other.paramValue1 != null)
				return false;
		} else if (!paramValue1.equals(other.paramValue1))
			return false;
		if (paramValue2 == null) {
			if (other.paramValue2 != null)
				return false;
		} else if (!paramValue2.equals(other.paramValue2))
			return false;
		if (paramValue3 == null) {
			if (other.paramValue3 != null)
				return false;
		} else if (!paramValue3.equals(other.paramValue3))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SystemParam [paramCd=" + paramCd + ", paramKey1=" + paramKey1
				+ ", paramKey2=" + paramKey2 + ", paramKey3=" + paramKey3
				+ ", paramValue1=" + paramValue1 + ", paramValue2="
				+ paramValue2 + ", paramValue3=" + paramValue3 + "]";
	}
}
