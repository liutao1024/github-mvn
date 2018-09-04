package cn.spring.mvn.base.util;

import org.hibernate.type.Type;

/**
 * @author LiuTao @date 2018年5月25日 下午12:56:01
 * @ClassName: CommUtilNullValue 
 * @Description: 公共枚举类
 */
public enum BaseUtilNullValue {
	;
	
	private Type type;
	
	private BaseUtilNullValue(Type t) {
		this.type = t;
	}

	public Type getType() {
	    return this.type;
	}
}
