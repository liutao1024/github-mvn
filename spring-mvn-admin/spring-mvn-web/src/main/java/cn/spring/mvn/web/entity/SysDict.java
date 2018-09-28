package cn.spring.mvn.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_dict")
public class SysDict implements Serializable {
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = -6512862255514009306L;

	@Id
	@Column(name = "dict_type", length = 19)
	private String dictType;
	
	@Id
	@Column(name = "dict_id", length = 19)
	private String dictId;

	@Column(name = "dict_name", length = 19)
	private String dictName;
	
	@Column(name = "parent_dict_type", length = 19)
	private String parentDictType;
	
	@Column(name = "parent_dict_id", length = 19)
	private String parentDictId;
	
	@Column(name = "status", length = 19)
	private String status;
	
	@Column(name = "sort_no", length = 19)
	private int sortNo;

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getParentDictType() {
		return parentDictType;
	}

	public void setParentDictType(String parentDictType) {
		this.parentDictType = parentDictType;
	}

	public String getParentDictId() {
		return parentDictId;
	}

	public void setParentDictId(String parentDictId) {
		this.parentDictId = parentDictId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dictId == null) ? 0 : dictId.hashCode());
		result = prime * result
				+ ((dictName == null) ? 0 : dictName.hashCode());
		result = prime * result
				+ ((dictType == null) ? 0 : dictType.hashCode());
		result = prime * result
				+ ((parentDictId == null) ? 0 : parentDictId.hashCode());
		result = prime * result
				+ ((parentDictType == null) ? 0 : parentDictType.hashCode());
		result = prime * result + sortNo;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		SysDict other = (SysDict) obj;
		if (dictId == null) {
			if (other.dictId != null)
				return false;
		} else if (!dictId.equals(other.dictId))
			return false;
		if (dictName == null) {
			if (other.dictName != null)
				return false;
		} else if (!dictName.equals(other.dictName))
			return false;
		if (dictType == null) {
			if (other.dictType != null)
				return false;
		} else if (!dictType.equals(other.dictType))
			return false;
		if (parentDictId == null) {
			if (other.parentDictId != null)
				return false;
		} else if (!parentDictId.equals(other.parentDictId))
			return false;
		if (parentDictType == null) {
			if (other.parentDictType != null)
				return false;
		} else if (!parentDictType.equals(other.parentDictType))
			return false;
		if (sortNo != other.sortNo)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SysDict [dictType=" + dictType + ", dictId=" + dictId
				+ ", dictName=" + dictName + ", parentDictType="
				+ parentDictType + ", parentDictId=" + parentDictId
				+ ", status=" + status + ", sortNo=" + sortNo + "]";
	}

	
	
}
