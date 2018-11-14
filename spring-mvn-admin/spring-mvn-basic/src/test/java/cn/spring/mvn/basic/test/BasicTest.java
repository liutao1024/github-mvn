package cn.spring.mvn.basic.test;

import java.util.Map;

import javax.persistence.Id;

import cn.spring.mvn.basic.entity.SystemDate;
import cn.spring.mvn.basic.tools.BasicReflection;

//import javax.persistence.Table;

//import cn.spring.mvn.basic.util.BasicUtil;

public class BasicTest {
	public static void main(String[] args) {
		test003();
	}
	
	public static void test001() {
		String str = "";
		StringBuilder result = new StringBuilder();
	    if(str != null && str.length() > 0) {
	        // 将第一个字符处理成大写
	        result.append(str.substring(0,1)/*.toLowerCase()*/);
	        // 循环处理其余字符
	        for(int i = 1; i < str.length(); i++) {
	            String s = str.substring(i, i + 1);
	            // 在大写字母前添加下划线除首字母大写外
	            if(s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
	                result.append("_");
	            }
	            // 其他字符直接转成大写
	            result.append(s/*.toLowerCase()*/);
	        }
	    }
	    System.out.println(result.toString().toLowerCase());
	}
	public static void test002() {
		String s = "M";
		Character c = s.charAt(0);
		System.out.println(c);
//		Class<?> clazz = Table.class;
//		Table annotation = (Table) BasicUtil.getClassAnnotationByReflectAnnotationClass(this.entity, clazz);
	}
	
	public static void test003(){
		SystemDate date = new SystemDate();
		date.setDateType("1213");
		date.setToday("20181114");
		Map<String, Object> map = BasicReflection.getMapByReflectAttributeAnnotationClassObejct(date, Id.class);
		System.out.println(map);
	}
}
