package cn.spring.mvn.basic.tools;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.persistence.Column;
import javax.persistence.Id;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.basic.util.BasicUtil;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author LiuTao @date 2018年11月14日 下午4:00:59
 * @ClassName: BasicReflection 
 * @Description: 反射工具类
 */
//@SuppressWarnings({"rawtypes", "unchecked"})
public class BasicReflection {
	private static final Logger LOGGER = Logger.getLogger(BasicReflection.class);
	
	public static final String INSERT = "insert";
	public static final String DELETE = "delete";
	public static final String SELECT = "select";
	public static final String UPDATE = "update";
	public static final String SCOUNT = "count";
	
	private static final String JAVAP = "java.";
	private static final String JAVADATESTR = "java.util.Date";
	private static final String SETPR = "set";//setXxxx前缀
	private static final String GETPR = "get";//getXxxx前缀
	
	/**
	 * @author LiuTao @date 2018年9月4日 下午4:07:40 
	 * @Title: executeMethodByReflectClassNameAndMethodName 
	 * @Description: 通过反射获得className对应的类并执行该类中methodName对应的方法
	 * @param className 类
	 * @param methodName 类中的方法
	 * @param classes 方法参数的类型  所以是不是需要将   输入和输出封装成单独的类
	 * @param objects 方法的参数
	 * @throws ClassNotFoundException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 * @throws NoSuchMethodException 
	 * @throws Exception
	 */
	public static void executeMethodByReflectClassNameAndMethodName(String className, String methodName, Class<?>[] classes, Object[] objects) throws ReflectiveOperationException{
		try {
			Class<?> theClass = getClassByReflectClassName(className);
			Object obj = theClass.newInstance();
			Method method = theClass.getMethod(methodName, classes);
			method.setAccessible(true);//对于类中的private方法也可以通过这只后可以访问
			method.invoke(obj, objects);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw e;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw e;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw e;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw e;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	/**
	 * @author LiuTao @date 2018年6月2日 下午7:11:56 
	 * @Title: getClassByReflectClassName 
	 * @Description: 通过反射根据className获取Class
	 * @param className
	 * @return
	 * @throws ClassNotFoundException 
	 */
	public static Class<?> getClassByReflectClassName(String className) throws ClassNotFoundException {
		try {
			Class<?> clazz = Class.forName(className);
			return clazz;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			LOGGER.info("根据字符串" + className + "获取类失败:" + e.getMessage());
			throw e;
		}
	}
	/**
	 * @author LiuTao @date 2018年11月14日 下午4:03:28 
	 * @Title: getClassByReflectClassAndObject 
	 * @Description: TODO(Describe) 
	 * @param clazz
	 * @param object
	 * @return
	 */
	public static Class<?> getClassByReflectClassAndObject(Class<?> clazz, Object object){
		if(clazz.isInstance(object)){
			return (Class<?>) clazz.cast(object);
		}
		return clazz;
	}
	/**
	 * @author LiuTao @date 2018年10月24日 上午11:25:49 
	 * @Title: getObject 
	 * @Description: TODO(Describe) 
	 * @param clazz
	 * @param object
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static Object getObjectByReflectClassAndObject(Class<?> clazz, Object object) throws InstantiationException, IllegalAccessException{
		Object obj = clazz.newInstance();
		obj = clazz.cast(object);
		return obj;
	}
	/**
	 * @author LiuTao @date 2018年10月24日 下午1:55:37 
	 * @Title: getObjectByClass
	 * @Description: TODO(Describe) 
	 * @param clazz
	 * @param jsonObject
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static Object getObjectByReflectClassAndJsonObject(Class<?> clazz, Object jsonObject) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		String objectJsonStr = JSONObject.toJSONString(jsonObject);
		Object object = objectMapper.readValue(objectJsonStr, clazz);
		return object;
	}
    /** 
     * @author LiuTao @date 2018年6月4日 下午8:17:35 
     * @Title: toJudgeClassIsSonOfParentClassByReflect 
     * @Description: 判断一个类是否继承某个父类或实现某个接口
     * @param className
     * @param parentClazz
     * @return
     */
    public static boolean toJudgeByReflectClassIsSonOfParentClass(String className, Class<?> parentClazz){  
        if(className == null) return false;  
        Class<?> clazz = null;  
        try {  
            clazz = Class.forName(className);  
            if(Modifier.isAbstract(clazz.getModifiers())){//抽象类忽略  
                return false;  
            }  
            if(Modifier.isInterface(clazz.getModifiers())){//接口忽略  
                return false;  
            } 
            if(BasicUtil.equals(clazz, parentClazz)){//该父类忽略
            	return false;  
            }
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
        return parentClazz.isAssignableFrom(clazz);  
    }  
    /**
	 * @author LiuTao @date 2018年11月13日 上午10:47:43 
	 * @Title: preseMapListToObjectList 
	 * @Description: 将List<Map<String, Object>> 转成List<Object>
	 * @param clazz
	 * @param daoResult
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getObjectListByReflectClassAndMapList(Class<?> clazz, List<Map<String, Object>> mapList) {
		List<T> result = new ArrayList<T>();
		for (Map<String, Object> map : mapList) {
			try {
				Object object = clazz.newInstance();
				result.add((T)getObjectByReflectMapAndObject(map, object));
			} catch (Exception e) {
				LOGGER.info(e.getMessage());
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * @author LiuTao @date 2018年11月14日 下午3:26:33 
	 * @Title: getSQLStringForIBatisByReflect 
	 * @Description: 为IBatis生成合适的SQL
	 * @param t
	 * @param sqlType
	 * @return
	 */
	public static <T> String getSQLStringByReflectForIBatis(T t, String sqlType) {
		Class<?> clazz = t.getClass();
		String clazzName = clazz.getSimpleName();
		String tableName = BasicUtil.presentHumpNamedToUnderScoreString(clazzName, false);
		Map<String, Object> paramMap = getMapByReflectObject(t);
		StringBuilder stringBuilder = new StringBuilder();
		switch (sqlType) {
		case INSERT://增
			stringBuilder.append("insert into " + tableName );
			String k = "";
			String v = "";
			for (Entry<String, Object> entry : paramMap.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				k += ", " + key;
				v += ", " + value;//需要根据T的属性类型进行处理,在获取paramMap时已经处理
			}
			k = BasicUtil.sourceStrCastHeadStr(", ", k);
			v = BasicUtil.sourceStrCastHeadStr(", ", v);
			stringBuilder.append("(" + k + ") values("+ v + ")");
			break;
		case DELETE://删
			stringBuilder.append("delete from " + tableName + " where 1 = 1 ");
			for (Entry<String, Object> entry : paramMap.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				stringBuilder.append(" and " + key + " = " + value);
			}
			break;
		case SELECT://查
			stringBuilder.append("select * from " + tableName + " where 1 = 1");
			for (Entry<String, Object> entry : paramMap.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				stringBuilder.append(" and ").append(key).append(" = ").append(value);
			}
			break;
		case UPDATE://改
			stringBuilder.append("update " + tableName + " set");
			String str = "";
			for (Entry<String, Object> entry : paramMap.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				str += ", " + key + " = " + value;
			}
			stringBuilder.append(BasicUtil.sourceStrCastHeadStr(",", str) + " where 1 = 1");
			//根据t获取实体类的主键列若没有时则返回第一个不为空的属性作为主键
			Map<String, Object> PKMap = BasicReflection.getPKMapByReflectObejct(t);
			if(BasicUtil.isNull(PKMap)){
				BasicUtil.takeTheFirstOfSourceMap(paramMap);
			}
			for (Entry<String, Object> entry : PKMap.entrySet()) {
				stringBuilder.append(" and ").append(entry.getKey()).append(" = ").append(entry.getValue());
			}
			break;
		case SCOUNT://计数
			stringBuilder.append("select count(*) from " + tableName + " where 1 = 1");
			for (Entry<String, Object> entry : paramMap.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				stringBuilder.append(" and ").append(key).append(" = ").append(value);
			}
			break;
		default:
			break;
		}
		String SQL = stringBuilder.toString();
		LOGGER.info("===SQL===" + SQL);
//		SQL = "insert into student(no, phone, sex, name, birth, id, age) values(9925, 18982598359, 'M', '杨过', 20181113, 119, 28)";
		return SQL;
	}
	/**
	 * @author LiuTao @date 2018年9月5日 下午8:07:16 
	 * @Title: getMapByReflecObject 
	 * @Description: TODO(获取利用反射获取类里面的值和名称) 
	 * @param obj
	 * @return
	 * @throws IllegalAccessException
	 */
	public static Map<String, Object> getMapByReflecObject(Object obj) throws IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Class<?> clazz = obj.getClass();
		System.out.println(clazz);
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Object value = field.get(obj);
			map.put(fieldName, value);
		}
		return map;
	}
	/**
	 * @author LiuTao @date 2018年9月5日 下午8:06:07 
	 * @Title: getMapByReflecFormatObjectMapAndFields
	 * @Description: TODO(递归调用函数) 
	 * @param timeFormatStr
	 * @param obj 对象
	 * @param map
	 * @param excludeFields 对应参数
	 * @return
	 * @throws IllegalAccessException
	 */
	public static Map<String, Object> getMapByReflecFormatObjectMapAndFields(String timeFormatStr, Object obj, Map<String, Object> map, List<String> excludeFields) throws IllegalAccessException {
		boolean isExclude = false;
		// 默认字符串
		String formatStr = "YYYY-MM-dd HH:mm:ss";
		// 设置格式化字符串
		if (timeFormatStr != null && !timeFormatStr.isEmpty()) {
			formatStr = timeFormatStr;
		}
		if (excludeFields != null) {
			isExclude = true;
		}
		Class<?> clazz = obj.getClass();
		// 获取值
		for (Field field : clazz.getDeclaredFields()) {
			String fieldName = clazz.getSimpleName() + "." + field.getName();
			// 判断是不是需要跳过某个属性
			if (isExclude && excludeFields.contains(fieldName)) {
				continue;
			}
			// 设置属性可以被访问
			field.setAccessible(true);
			Object value = field.get(obj);
			Class<?> valueClass = value.getClass();
			if (valueClass.isPrimitive()) {
				map.put(fieldName, value.toString());

			} else if (valueClass.getName().contains(JAVAP)) {// 判断是不是基本类型
				if (valueClass.getName().equals(JAVADATESTR)) {
					// 格式化Date类型
					SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
					Date date = (Date) value;
					String dataStr = sdf.format(date);
					map.put(fieldName, dataStr);
				} else {
					map.put(fieldName, value.toString());
				}
			} else {
				getMapByReflecFormatObjectMapAndFields(timeFormatStr, value, map, excludeFields);
			}
		}
		return map;
	}
	/**
	 * @author LiuTao @date 2018年11月13日 下午3:37:43 
	 * @Title: getMapByReflectObject 
	 * @Description: 通过反射将对象Object按数据库表列名对应的属性组装为一个map 不包括序列化的属性
	 * @param object
	 * @return  
	 */
	public static Map<String, Object> getMapByReflectObject(Object object){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		Class<?> clazz = object.getClass();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			Class<?> fieldClazz = field.getType();
			String fieldName = field.getName();
			if(!BasicUtil.equals("serialVersionUID", fieldName)){//非serialVersionUID
				try {
					Method method = clazz.getMethod(BasicUtil.convertKey(fieldName, GETPR));
					method.setAccessible(true);
					Object fieldValue = method.invoke(object);
					if(BasicUtil.isNotNull(fieldValue)){
						fieldValue = BasicUtil.convertValueTypeForDB(fieldValue, fieldClazz);
						String filedKey = BasicUtil.presentHumpNamedToUnderScoreString(fieldName, false);
						rstMap.put(filedKey, fieldValue);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年5月31日 下午1:27:55 
	 * @Title: getMapByReflectWithOutNullValueObject
	 * @Description: 通过反射一个类对象获取没有空值的paramMap对象 需要用到Entity属性的注解  适用于Hibernat
	 * @param object
	 * @return
	 */
	public static Map<String, Object> getMapByReflectWithOutNullValueObject(Object object){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		Map<String, Object> columnNameAndValueMap = new HashMap<String, Object>();
		//获取类属性(变量)的Column注解的 name属性值
		Map<String, Object> columnNameMap = getAttributeColumnAnnotationMapByReflectObject(object);
		//获取对象的所有属性
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			//将属性设置为可读的
			field.setAccessible(true);
			try {
				//得到属性对应的值
				Object fieldValue = field.get(object);
				if(BasicUtil.isNotNull(fieldValue)){
					//属性名称
					String fieldName = field.getName();
					//属性名称存在于
					Object column = columnNameMap.get(fieldName);
					if(BasicUtil.isNotNull(column)){
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
	 * @Description:  通过反射一个类对象获取该对象非空的的paramMap对象   适合MyBatis
	 * 					排除序列化的参数
	 * @param object
	 * @return
	 */
	public static Map<String, Object> getMapByReflectWithOutNullObject(Object object){
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
				if(!BasicUtil.equals("serialVersionUID", fieldName)){//排除序列化的参数
					if(!BasicUtil.isNull(fieldValue)){//20181106
						rstMap.put(BasicUtil.presentHumpNamedToUnderScoreString(fieldName, false), 
								BasicUtil.convertValueTypeForDB(fieldValue, field.getType()));
					}
//					rstMap.put(fieldName, isNull(fieldValue) ? "" : fieldValue);
				}
			} catch (Exception e) {
				System.out.println("类转换成map时遇到:" + e.getMessage());
			} 
		}
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年11月12日 下午9:18:59 
	 * @Title: getObjectByReflectMapAndObject 
	 * @Description: 通过反射的方法将map按照object实例的属性进行设置并返回该实体对象 适用与 MyBatis
	 * @param map
	 * @param object
	 * @return
	 */
	public static Object getObjectByReflectMapAndObject(Map<String, Object> map, Object object){
		/**
		 * Class类是反射的入口 一般获得一个Class对象有三种途径 :
		 * 		1.类属性方式,如String.class
		 * 		2.对象的getClass方法加载,如new String().getClass().
		 * 		3.forName方法加载,如Class.forName("java.lang.String") 用于动态加载 比如加载驱动
		 * 这里我传入一个Object对象,所以我用的是第2种
		 */
		Class<?> clazz = object.getClass();
		// 判断map集合参数不能为null
		if (!map.isEmpty()) {
			for (Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				// 得到属性
				Field field = getFieldByReflectClassFieldName(clazz, key);
				if (field != null) {
					// 获取属性类型
					Class<?> fieldType = field.getType();
					value  = BasicUtil.convertValueTypeForJava(value, fieldType);
					Method method = null;
						// 得到属性set方法名
						String setMethodName = BasicUtil.convertKey(key, SETPR);
						try {
							// 得到实体类属性set方法
							method = clazz.getMethod(setMethodName, field.getType());
							// 设置方法为可执行
							method.setAccessible(true); 
							// 执行该方法
							method.invoke(object, value);
						} catch (Exception e) {
							LOGGER.info("===key===" + key);
							e.printStackTrace();
						}
				}
			}
		}
		return object;
	}
	/**
	 * @author LiuTao @date 2018年11月14日 下午3:53:28 
	 * @Title: getClassFieldByReflectClassFieldName 
	 * @Description: 得到属性名
	 * @param clazz 类
	 * @param fieldName 属性名
	 * @return
	 */
	public static Field getFieldByReflectClassFieldName(Class<?> clazz, String fieldName) {
		// 传入类是Object类型或者是null直接return
		if (clazz == null || Object.class.getName().equals(clazz.getName())) {
			return null;
		}
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			if (field.getName().equals(fieldName)) {
				return field;
			}
		}
		Class<?> superClass = clazz.getSuperclass();
		if (superClass != null) {// 简单的递归一下
			return getFieldByReflectClassFieldName(superClass, fieldName);
		}
		return null;
	}
	/**
	 * @author LiuTao @date 2018年5月31日 下午1:07:47 
	 * @Title: getAttributeColumnAnnotationMapByReflectObject 
	 * @Description: 通过反射获取类属性的javax.persistence.Column注解 
	 * @param object
	 * @return
	 */
	public static Map<String, Object> getAttributeColumnAnnotationMapByReflectObject(Object object){
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
	 * @author LiuTao @date 2018年5月31日 上午10:40:34 
	 * @Title: getClassAnnotationListByReflectObject 
	 * @Description: 通过反射获取类上的所有注解 
	 * @param object
	 */
	public static List<Class<?>> getClassAnnotationListByReflectObject(Object object){
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
	 * @author LiuTao @date 2018年11月12日 下午1:59:21 
	 * @Title: getClassAnnotationByReflectObjectAnnotationClass 
	 * @Description: 通过反射获取类上指定类型的注解
	 * @param object 实体类
	 * @param clazz  指定注解类型
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Annotation getClassAnnotationByReflectObjectAnnotationClass(Object object, Class<?> clazz){
		Annotation annotation = BasicUtil.isNull(object) ? null : object.getClass().getAnnotation((Class) clazz);
		return annotation;
	}
	/**
	 * @author LiuTao @date 2018年5月31日 下午12:55:09 
	 * @Title: getAttributeAnnotationByReflectAnnotationObejct 
	 * @Description: 通过反射获取实体类对象指定注解的属性Map<field, fieldValue>
	 *  因为注解annotation不知道如何获取属性,而且在调用时需要送一个注解对象,这个注解对象实例化存在问题
	 * @param object 实体对象
	 * @param clazz 注解类型
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> getPKMapByReflectObejct(Object object){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		if(BasicUtil.isNotNull(object)){
			Field[] fields = object.getClass().getDeclaredFields();
			try {
				for (Field field : fields) {
					// 属性名称
					String fieldName = field.getName();
					if(!BasicUtil.equals("serialVersionUID", fieldName)){//非serialVersionUID
						// 属性类型
						Class<?> fieldClazz = field.getType();
						// 获取属性上的指定类型的注解
						Annotation annotation = field.getDeclaredAnnotation((Class) Id.class);
						// 有该类型的注解存在
						if (annotation != null) {
							String getMethod = BasicUtil.convertKey(fieldName, GETPR);
							Method method = object.getClass().getMethod(getMethod);
							method.setAccessible(true);
							Object fieldValue = method.invoke(object);
							if(BasicUtil.isNotNull(fieldValue)){
								fieldValue = BasicUtil.convertValueTypeForDB(fieldValue, fieldClazz);
								String filedKey = BasicUtil.presentHumpNamedToUnderScoreString(fieldName, false);
								Column column = field.getDeclaredAnnotation(Column.class);//
								if(BasicUtil.isNotNull(column)){
									filedKey = BasicUtil.isNull(column.name()) ? filedKey : column.name();
								}
								rstMap.put(filedKey, fieldValue);
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年5月31日 上午10:42:40 
	 * @Title: getAttributeAnnotationsByReflectObject 
	 * @Description: 通过反射获取类属性上的所有注解
	 * @param object
	 */
	public static List<List<Class<?>>> getAttributeAnnotationsByReflectObject(Object object){
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
		     if(BasicUtil.isNotNull(innerList)){
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
	public static List<List<Class<?>>> getMethodAnnotationsByReflectObject(Object object){
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
			if(BasicUtil.isNotNull(innerList)){
				outterList.add(innerList);
			}
		}
		return outterList;
	}
	/**
	 * @author LiuTao @date 2018年6月4日 下午9:14:19 
	 * @Title: getMapByReflectAttributeAnnotationAutowiredObject 
	 * @Description: 通过反射获取类属性的有org.springframework.beans.factory.annotation.Autowired注解的属性
	 * @param object
	 * @return
	 */
	public static Map<Type, Object> getMapByReflectAttributeAnnotationAutowiredObject(Object object){
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
     * @author LiuTao @date 2018年6月4日 下午8:17:51 
     * @Title: getClassListByReflecJarNametFromJar 
     * @Description: 从jar包读取所有的class文件名 
     * @param jarName
     * @return
     */
    @SuppressWarnings("resource")
	public static List<String> getClassListByReflecJarNametFromJar(String jarName){  
        List<String> fileList = new ArrayList<String>();  
        try {  
            JarFile jarFile = new JarFile(new File(jarName));  
             Enumeration<JarEntry> en = jarFile.entries(); // 枚举获得JAR文件内的实体,即相对路径    
             while (en.hasMoreElements()) {  
                 String name1 =  en.nextElement().getName();  
                 if(!name1.endsWith(".class")){//不是class文件  
                     continue;  
                 }  
                 String name2 = name1.substring(0, name1.lastIndexOf(".class"));  
                 String name3 = name2.replaceAll("/", ".");  
                 fileList.add(name3);  
             }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return fileList;  
    } 
}