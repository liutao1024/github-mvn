package cn.spring.mvn.base.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LiuTao @date 2018年6月9日 下午3:05:05
 * @ClassName: SystemSequence 
 * @Description: 编号
 */
@Entity
@Table(name = "sys_sequence")
public class SystemSequence implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = -3107167409975735365L;
	//80100200002     客户号
	//60100001000005    电子帐号
	//800010000010000001负债帐号
	@Id
	@Column(name = "sequencetype", nullable = false, length = 24)
	private String sequenceType;//序列号类型
	@Column(name = "sequencebegin")
	private String sequenceBegin;//序列号头部
	@Column(name = "sequencemiddle")
	private String sequenceMiddle;//序列号中部
	@Column(name = "sequenceend")
	private String sequenceEnd;//序列号尾部
	@Column(name = "sequencestep")
	private int sequenceStep;//序列号增涨步长
	
	public String getSequenceType() {
		return sequenceType;
	}
	public void setSequenceType(String sequenceType) {
		this.sequenceType = sequenceType;
	}
	public String getSequenceBegin() {
		return sequenceBegin;
	}
	public void setSequenceBegin(String sequenceBegin) {
		this.sequenceBegin = sequenceBegin;
	}
	public String getSequenceMiddle() {
		return sequenceMiddle;
	}
	public void setSequenceMiddle(String sequenceMiddle) {
		this.sequenceMiddle = sequenceMiddle;
	}
	public String getSequenceEnd() {
		return sequenceEnd;
	}
	public void setSequenceEnd(String sequenceEnd) {
		this.sequenceEnd = sequenceEnd;
	}
	public int getSequenceStep() {
		return sequenceStep;
	}
	public void setSequenceStep(int sequenceStep) {
		this.sequenceStep = sequenceStep;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sequenceBegin == null) ? 0 : sequenceBegin.hashCode());
		result = prime * result
				+ ((sequenceEnd == null) ? 0 : sequenceEnd.hashCode());
		result = prime * result
				+ ((sequenceMiddle == null) ? 0 : sequenceMiddle.hashCode());
		result = prime * result + sequenceStep;
		result = prime * result
				+ ((sequenceType == null) ? 0 : sequenceType.hashCode());
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
		SystemSequence other = (SystemSequence) obj;
		if (sequenceBegin == null) {
			if (other.sequenceBegin != null)
				return false;
		} else if (!sequenceBegin.equals(other.sequenceBegin))
			return false;
		if (sequenceEnd == null) {
			if (other.sequenceEnd != null)
				return false;
		} else if (!sequenceEnd.equals(other.sequenceEnd))
			return false;
		if (sequenceMiddle == null) {
			if (other.sequenceMiddle != null)
				return false;
		} else if (!sequenceMiddle.equals(other.sequenceMiddle))
			return false;
		if (sequenceStep != other.sequenceStep)
			return false;
		if (sequenceType == null) {
			if (other.sequenceType != null)
				return false;
		} else if (!sequenceType.equals(other.sequenceType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SystemSequence [sequenceType=" + sequenceType
				+ ", sequenceBegin=" + sequenceBegin + ", sequenceMiddle="
				+ sequenceMiddle + ", sequenceEnd=" + sequenceEnd
				+ ", sequenceStep=" + sequenceStep + "]";
	}
	
}
