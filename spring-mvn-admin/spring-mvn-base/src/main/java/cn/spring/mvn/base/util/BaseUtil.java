package cn.spring.mvn.base.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseUtil {
	
	/**
	 * @author LiuTao @date 2018年6月9日 下午1:01:49 
	 * @Title: toGetDateStrByDateStr 
	 * @Description: TODO(Describe) 
	 * @param srcDateStr
	 * @param num
	 * @return
	 */
	public static String toGetDateStrByDateStr(String srcDateStr, int num){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = sdf.parse(srcDateStr);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, num);
			date = calendar.getTime();
			return sdf.format(date);
		} catch (Exception e) {
			System.out.println("日期:"+ srcDateStr +",格式不对");
		}
		return null;
	}
	/**
	 * @author LiuTao @date 2018年6月6日 下午1:37:25 
	 * @Title: getHqlByEntityNameAndParamMap 
	 * @Description: TODO(Describe) 
	 * @param entityName
	 * @param paramMap
	 * @return
	 */
	public static String getHqlByEntityNameAndParamMap(String entityName, Map<String, Object> paramMap){
		String rstSqlStr = "";
		if(isNotNull(entityName)){
			rstSqlStr = "from " + entityName;//from tableName 
			if(isNotNull(paramMap) && paramMap.size() > 0){
				String str =  " where";
				String appendStr  = "";
				for(Entry<String, Object> entry : paramMap.entrySet()){
					String keyStr = entry.getKey();
					Object value = entry.getValue();
					appendStr = appendStr + "and " + keyStr + " = '" + value + "' ";
				}
				//处理appendStr
				appendStr = dealWith("and", appendStr);
				rstSqlStr = rstSqlStr + str + appendStr; 
			}
		}
		return rstSqlStr;
	}
	/**
	 * @author LiuTao @date 2018年5月26日 下午9:25:32 
	 * @Title: getSqlStrByEntityNameAndParamMap 
	 * @Description: 根据传入的 EntityName和ParamMap组装一条hql
	 * @param entityName
	 * @param paramMap
	 * @return
	 */
	public static String getSqlStrByEntityNameAndParamMap(String entityName, Map<String, Object> paramMap){
		String rstSqlStr = "";
		if(isNotNull(entityName)){
			rstSqlStr = "from " + entityName;//from tableName 
			if(isNotNull(paramMap) && paramMap.size() > 0){//传入的是一个new出来的空对象时需要排除
				String str =  " where";
				String appendStr  = "";
				for(Entry<String, Object> entry : paramMap.entrySet()){
					String keyStr = entry.getKey();
					appendStr = appendStr + "and " + keyStr + " = :" + keyStr + " ";
				}
				//处理appendStr
				appendStr = dealWith("and", appendStr);
				rstSqlStr = rstSqlStr + str + appendStr; 
			}
		}
		return rstSqlStr;
	}
	/**
	 * @author LiuTao @date 2018年5月31日 下午1:27:55 
	 * @Title: getParamMapByReflectObjectWithOutNullValue 
	 * @Description: 通过反射一个类对象获取没有空值的paramMap对象 
	 * @param object
	 * @return
	 */
	public static Map<String, Object> getParamMapWithOutNullValueByReflectObject(Object object){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		Map<String, Object> columnNameAndValueMap = new HashMap<String, Object>();
		//获取类属性(变量)的Column注解的 name属性值
		Map<String, Object> columnNameMap = getAttributeAnnotationByReflectColumn(object);
		//获取对象的所有属性
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			//将属性设置为可读的
			field.setAccessible(true);
			try {
				//得到属性对应的值
				Object fieldValue = field.get(object);
				if(isNotNull(fieldValue)){
					//属性名称
					String fieldName = field.getName();
					//属性名称存在于
					Object column = columnNameMap.get(fieldName);
					if(isNotNull(column)){
						columnNameAndValueMap.put(column.toString(), fieldValue);
					}
				}
			} catch (Exception e) {
				System.out.println("类转换成map时遇到:" + e.getMessage());
			} 
		}
		rstMap.putAll(columnNameAndValueMap);
		return rstMap;
	}
	
	/**
	 * @author LiuTao @date 2018年6月13日 上午11:46:44 
	 * @Title: getParamMapByReflectObject 
	 * @Description:  通过反射一个类对象获取该对象的paramMap对象 
	 * @param object
	 * @return
	 */
	public static Map<String, Object> getObjectMapByReflectObject(Object object){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		//获取对象的所有属性
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			//将属性设置为可读的
			field.setAccessible(true);
			try {
				//得到属性对应的值
				String fieldName = field.getName();
				Object fieldValue = field.get(object);
				rstMap.put(fieldName, isNull(fieldValue) ? "" : fieldValue);
			} catch (Exception e) {
				System.out.println("类转换成map时遇到:" + e.getMessage());
			} 
		}
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年5月31日 下午1:07:47 
	 * @Title: getAttributeAnnotationByReflectColumn 
	 * @Description: 通过反射获取类属性的javax.persistence.Column注解 
	 * @param object
	 * @return
	 */
	public static Map<String, Object> getAttributeAnnotationByReflectColumn(Object object){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		//获取Object所有的属性
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			// 获取类属性上的javax.persistence.Column注解
			Annotation annotation = field.getAnnotation(Column.class);
			// 有该类型的注解存在
			if (annotation != null) {
				// 强制转化为相应的注解
				Column column = (Column) annotation;
				//获取field的属性名称
				String fieldName = field.getName();
				//获取属性上Column注解的name方法
				String name = column.name();
				//将注解Column注解的name属性和field的属性名称fieldName 组成一个键值对放在rstMap中
				rstMap.put(fieldName, name);
//				System.out.println(fieldName +"["+column.name()+","+column.columnDefinition()+","+column.hashCode()+","+column.length()+","+column.precision()+","
//						+column.scale()+","+column.table()+","+column.toString()+","+column.insertable()+","+column.nullable()+","+column.unique()+","+column.updatable()+"]");
			}
		}
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年6月2日 下午9:50:24 
	 * @Title: makeNeedString 
	 * @Description: 获取需要的字符串
	 * @param srcStr
	 * @param flag
	 * @param from
	 * @param to
	 * @return
	 */
	public static String makeNeedString(String srcStr, boolean flag, int from, int to){
		String oneStr = srcStr.substring(0, from);
		String twoStr = srcStr.substring(from, to);
		String threeStr = srcStr.substring(to,srcStr.length());
		if(flag){
			twoStr = twoStr.toUpperCase();
		}else {
			twoStr = twoStr.toLowerCase();
		}
		return oneStr+twoStr+threeStr;
	}
	/**
	 * @author LiuTao @date 2018年5月31日 上午10:40:34 
	 * @Title: getClassAnnotationsByReflect 
	 * @Description: 通过反射获取类上的所有注解 
	 * @param object
	 */
	public static List<Class<?>> getClassAnnotationsByReflect(Object object){
		List<Class<?>> list = new ArrayList<Class<?>>(); 
		//获取类上的所有注解    
		 Annotation[] annotations = object.getClass().getAnnotations();
		 String className = object.getClass().getSimpleName();
		 for(Annotation annotation : annotations){    
		     Class<?> annotationType =  annotation.annotationType();  
		     list.add(annotationType);
		     System.out.println("类["+className+"]的注解有: " + annotationType);    
		 } 
		 return list;
	}
	/**
	 * @author LiuTao @date 2018年5月31日 上午10:42:40 
	 * @Title: getAttributeAnnotationsByReflect 
	 * @Description: 通过反射获取类属性上的所有注解
	 * @param object
	 */
	public static List<List<Class<?>>> getAttributeAnnotationsByReflect(Object object){
		List<List<Class<?>>> outterList = new ArrayList<List<Class<?>>>();
		Field[] fields = object.getClass().getDeclaredFields();
		for(Field field : fields){    
		     String filedName = field.getName();    
		     List<Class<?>> innerList = new ArrayList<Class<?>>(); 
		     //获取属性上的所有注解    
		     Annotation[] fieldAnnotations = field.getAnnotations();    
		     for(Annotation fieldAnnotation : fieldAnnotations){    
		         Class<?> annotationType = fieldAnnotation.annotationType(); 
		         innerList.add(annotationType);
		         System.out.println("属性["+filedName+"]的注解类型有: " + annotationType);    
		     }  
		     if(isNotNull(innerList)){
					outterList.add(innerList);
		     }
		 }  
		return outterList;
	}
	/**
	 * @author LiuTao @date 2018年5月31日 上午10:42:43 
	 * @Title: getMethodAnnotationsByReflect 
	 * @Description: 通过反射获取类方法上的所有注解 
	 * @param object
	 */
	public static List<List<Class<?>>> getMethodAnnotationsByReflect(Object object){
		List<List<Class<?>>> outterList = new ArrayList<List<Class<?>>>();  
		Method[] methods = object.getClass().getMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			List<Class<?>> innerList = new ArrayList<Class<?>>();
			// 获取方法上的所有注解   
			Annotation[] methodAnnotations = method.getAnnotations();   
			for(Annotation methodAnnotation : methodAnnotations){    
				Class<?> annotationType =  methodAnnotation.annotationType();  
				innerList.add(annotationType);
				System.out.println("方法["+methodName+"]的注解有: " + annotationType);    
		    } 
			if(isNotNull(innerList)){
				outterList.add(innerList);
			}
		}
		return outterList;
	}
	/**
	 * @author LiuTao @date 2018年5月31日 下午12:55:09 
	 * @Title: getAttributeAnnotationByReflectAnnotationObejct 
	 * @Description: 通过反射获取指定注解的Map 
	 * ---暂时不用:因为注解annotation不知道如何获取属性,而且在调用时需要送一个注解对象,这个注解对象实例化存在问题
	 * @param object
	 * @param annotationObejct
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> getAttributeAnnotationByReflectAnnotationObejct(Object object, Object annotationObejct){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		String className = annotationObejct.getClass().getName();
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Field[] fields = object.getClass().getDeclaredFields();
		try {
			Class theClass = classLoader.loadClass(className);
			for (Field field : fields) {
				String fieldName = field.getName();
				// 1.获取属性上的指定类型的注解
				Annotation annotation = field.getAnnotation(theClass);
				// 有该类型的注解存在
				if (annotation != null) {
					rstMap.put(fieldName, annotation);
					System.out.println("属性[" + fieldName + "],Column注解name的值: "+ annotation);
					System.out.println("属性[" + fieldName + "],Column注解name的值: "+ annotation.toString());
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rstMap;
	}
	
	
	/**
	 * @author LiuTao @date 2018年6月4日 下午9:14:19 
	 * @Title: getAttributeAnnotationByReflectAutowired 
	 * @Description: 通过反射获取类属性的有org.springframework.beans.factory.annotation.Autowired注解的属性
	 * @param object
	 * @return
	 */
	public static Map<Type, Object> getAttributeAnnotationByReflectAutowired(Object object){
		Map<Type, Object> rstMap = new HashMap<Type, Object>();
		//获取Object所有的属性
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			// 获取类属性上的jannotation.Autowired注解
			Annotation annotation = field.getAnnotation(Autowired.class);
			// 有该类型的注解存在
			if (annotation != null) {
				//获取属性上Column注解的name方法
				
				Type theType = field.getGenericType();
				//将注解Column注解的name属性和field的属性名称fieldName 组成一个键值对放在rstMap中
				rstMap.put(theType, field);
			}
		}
		return rstMap;
	}
	
	/**
	 * @author LiuTao @date 2018年5月22日 下午9:28:48 
	 * @Title: isNull 
	 * @Description: TODO(判断对象是否为空)  还有种情况是object = "null"
	 * @param object
	 * @return
	 */
	public static boolean isNull(Object object){
		boolean rstBoolean = false;
		if(null == object){
			rstBoolean = true;
		}else if("".equals(object)){
			rstBoolean = true;
		}
		return rstBoolean;
	}
	/**
	 * @author LiuTao @date 2018年5月22日 下午11:06:35 
	 * @Title: isNotNull 
	 * @Description: TODO(判断对象是否为空) 
	 * @param object
	 * @return
	 */
	public static boolean isNotNull(Object object){
		return !isNull(object);
	}
	/**
	 * @author LiuTao @date 2018年5月22日 下午9:48:39 
	 * @Title: equal 
	 * @Description: TODO(判断对象是否是同一个对象) 
	 * @param objectOne
	 * @param objectTwo
	 * @return
	 */
	public static boolean equal(Object objectOne, Object objectTwo) {
		boolean rstBoolean = false;
		if(objectOne == objectTwo){//是否同一对象
			rstBoolean = true;
		}else if(objectOne.equals(objectTwo)){//值是否相等
			rstBoolean = true;
		}
		return rstBoolean;
	}
	
	/**
	 * @author LiuTao @date 2018年5月26日 下午9:18:06 
	 * @Title: dealWith 
	 * @Description: 若srcStr是以headStr开头的将开头的headStr去掉返回
	 * @param headStr
	 * @param srcStr
	 * @return
	 */
	public static String dealWith(String headStr, String srcStr){
		if(srcStr.indexOf(headStr) == 0){
			srcStr = srcStr.substring(headStr.length());
		}
		return srcStr;
	}
	
	
}
