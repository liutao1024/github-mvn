package cn.spring.mvn.basic.util;

import org.hibernate.type.Type;

/**
 * @author LiuTao @date 2018年5月25日 下午12:56:01
 * @ClassName: CommUtilNullValue 
 * @Description: 公共枚举类
 */
public enum BasicUtilNullValue {
	;
	
	private Type type;
	
	private BasicUtilNullValue(Type t) {
		this.type = t;
	}

	public Type getType() {
	    return this.type;
	}
}
