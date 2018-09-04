package cn.spring.mvn.base.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "sys_transaction")
public class SystemTransaction implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 2728752695162080006L;
	
	@Id
	@Column(name = "transactionCode", nullable = false, length = 24)
	private String corecd;
	
//	private 
}
