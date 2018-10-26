package cn.spring.mvn.socket;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import cn.spring.mvn.base.tools.BaseReflection;
import cn.spring.mvn.core.account.entity.CustUser;
import cn.spring.mvn.core.account.zport.QrcustOutput;
import cn.spring.mvn.socket.tools.SocketTool;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class EntityTest {
	@Test
	public void Test0004() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
//		String str = "{\"custna\":\"刘涛\",\"acctno\":\"9527\"}";
		String str = "{\"sada\":2,\"count\":2,\"infos\":[{\"addrcd\":\"\",\"addres\":\"中国香港\",\"birthd\":\"\",\"brchno\":\"\",\"closdt\":\"\",\"clossq\":\"\",\"corpno\":\"\",\"cuslvl\":\"\",\"custna\":\"张家辉\",\"custno\":\"7011001100002\",\"custst\":\"1\",\"datetm\":\"\",\"emails\":\"\",\"emplcu\":\"\",\"idtfno\":\"511024198612030398\",\"idtftp\":\"01\",\"opendt\":\"\",\"opensq\":\"\",\"postcd\":\"\",\"sextyp\":\"1\",\"teleno\":\"18581598359\",\"timetm\":\"\"},{\"addrcd\":\"\",\"addres\":\"中国四川\",\"birthd\":\"\",\"brchno\":\"\",\"closdt\":\"\",\"clossq\":\"\",\"corpno\":\"\",\"cuslvl\":\"\",\"custna\":\"刘涛\",\"custno\":\"7011001100001\",\"custst\":\"2\",\"datetm\":\"\",\"emails\":\"\",\"emplcu\":\"\",\"idtfno\":\"511024199112030398\",\"idtftp\":\"01\",\"opendt\":\"\",\"opensq\":\"\",\"postcd\":\"\",\"sextyp\":\"1\",\"teleno\":\"15928435559\",\"timetm\":\"\"}]}";
//		String className = "cn.spring.mvn.core.account.zport.QrcustInput";
		String className = "cn.spring.mvn.core.account.zport.QrcustOutput";
		Object obj = JSONObject.parse(str);
		Class<?> clazz = BaseReflection.getClassByClassName(className);
		obj = SocketTool.praseToClass(clazz, obj);
		System.out.println(obj);
	}
	
	@Test
	public void Test0003() throws ClassNotFoundException, JsonParseException, JsonMappingException, IOException, InstantiationException, IllegalAccessException{
		String str = "{\"ints\":2,\"count\":2,\"infos\":[{\"addrcd\":\"\",\"addres\":\"中国香港\",\"birthd\":\"\",\"brchno\":\"\",\"closdt\":\"\",\"clossq\":\"\",\"corpno\":\"\",\"cuslvl\":\"\",\"custna\":\"张家辉\",\"custno\":\"7011001100002\",\"custst\":\"1\",\"datetm\":\"\",\"emails\":\"\",\"emplcu\":\"\",\"idtfno\":\"5*****198612030398\",\"idtftp\":\"01\",\"opendt\":\"\",\"opensq\":\"\",\"postcd\":\"\",\"sextyp\":\"1\",\"teleno\":\"185*****359\",\"timetm\":\"\"},{\"addrcd\":\"\",\"addres\":\"中国\",\"birthd\":\"\",\"brchno\":\"\",\"closdt\":\"\",\"clossq\":\"\",\"corpno\":\"\",\"cuslvl\":\"\",\"custna\":\"古天乐\",\"custno\":\"7011001100001\",\"custst\":\"2\",\"datetm\":\"\",\"emails\":\"\",\"emplcu\":\"\",\"idtfno\":\"5*****199112030398\",\"idtftp\":\"01\",\"opendt\":\"\",\"opensq\":\"\",\"postcd\":\"\",\"sextyp\":\"1\",\"teleno\":\"15*****35559\",\"timetm\":\"\"}]}";
		String className = "cn.spring.mvn.core.account.zport.QrcustOutput";
		Class<?> clazz = Class.forName(className);
		Object obj = clazz.newInstance();
		obj = new Gson().fromJson(str, clazz);
		System.out.println(obj);
		QrcustOutput out = (QrcustOutput)obj;
		System.out.println(out.getCount());
		List<CustUser> infos = out.getInfos();
		for (CustUser custUser : infos) {
			System.out.println(custUser.getCustna());
		}
		
		ObjectMapper om = new ObjectMapper();
		Object obj1 = clazz.newInstance();
		obj1 = om.readValue(str, clazz);
		QrcustOutput out1 = (QrcustOutput)obj1;
		System.out.println(out1.getCount());
		List<CustUser> infos1 = out1.getInfos();
		for (CustUser custUser : infos1) {
			System.out.println(custUser.getCustna());
		}
		System.out.println(obj);
	}
	
	@Test
	public void Test0002(){
		Object a = 1L;
		System.out.println(a instanceof Integer);
//		int i = 1;
		System.out.println(isBaseType(a.getClass()));
		List<String> list = new ArrayList<String>();
		System.out.println(isBaseType(list.getClass()));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "9527");
		String text = map.toString();
		Object obj = JSONObject.parse(text);
		System.out.println(obj);
	}
	private boolean isBaseType(Class<?> clazz){
		boolean b =  
				clazz.equals(String.class) || 
				clazz.equals(Integer.class)|| 
				clazz.equals(Byte.class) || 
				clazz.equals(Long.class) || 
				clazz.equals(Double.class) || 
				clazz.equals(Float.class) || 
				clazz.equals(Character.class) || 
				clazz.equals(Short.class) || 
				clazz.equals(BigDecimal.class) || 
				clazz.equals(BigInteger.class) || 
				clazz.equals(Boolean.class) || 
				clazz.equals(Date.class) || 
//				clazz.equals(DateTime.class) || 
				clazz.isPrimitive(); 
		return b;
	}
	
	@Test
	public void Test0001() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchFieldException, SecurityException{
//		String str = "{\"custna\":\"刘涛\",\"acctno\":\"9527\"}";
		String str = "{\"count\":2,\"infos\":[{\"addrcd\":\"\",\"addres\":\"中国香港\",\"birthd\":\"\",\"brchno\":\"\",\"closdt\":\"\",\"clossq\":\"\",\"corpno\":\"\",\"cuslvl\":\"\",\"custna\":\"张家辉\",\"custno\":\"7011001100002\",\"custst\":\"1\",\"datetm\":\"\",\"emails\":\"\",\"emplcu\":\"\",\"idtfno\":\"511024198612030398\",\"idtftp\":\"01\",\"opendt\":\"\",\"opensq\":\"\",\"postcd\":\"\",\"sextyp\":\"1\",\"teleno\":\"18581598359\",\"timetm\":\"\"},{\"addrcd\":\"\",\"addres\":\"中国四川\",\"birthd\":\"\",\"brchno\":\"\",\"closdt\":\"\",\"clossq\":\"\",\"corpno\":\"\",\"cuslvl\":\"\",\"custna\":\"刘涛\",\"custno\":\"7011001100001\",\"custst\":\"2\",\"datetm\":\"\",\"emails\":\"\",\"emplcu\":\"\",\"idtfno\":\"511024199112030398\",\"idtftp\":\"01\",\"opendt\":\"\",\"opensq\":\"\",\"postcd\":\"\",\"sextyp\":\"1\",\"teleno\":\"15928435559\",\"timetm\":\"\"}]}";
//		String className = "cn.spring.mvn.core.account.zport.QrcustInput";
		String className = "cn.spring.mvn.core.account.zport.QrcustOutput";
		JSONObject jsonObject = JSONObject.parseObject(str);
		Object object = delWithNew(className, jsonObject);
		
		QrcustOutput out = (QrcustOutput)object;
//		int count = out.getCount();
		List<CustUser> list = out.getInfos();
		for (CustUser custUser : list) {
			System.out.println(custUser.toString());
		}
		System.out.println(object);
		//2.处理类的方法
//		Method[] methods = clazz.getMethods();//获取所有的方法
//		Method[] declaredMethods = clazz.getDeclaredMethods();//获取自己定义的方法
//		for (Method method : declaredMethods) {
//			methodNameList.add(method.getName());
//		}
//		System.out.println(object);
	
	}
	private Object delWithNew(String className, JSONObject jsonObject) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchFieldException, SecurityException{
		Class<?> clazz = Class.forName(className);
		Object object = clazz.newInstance();
		Field[] fields  = clazz.getDeclaredFields();//获取自己定义的属性(是否包括父类的呢? ---不包含)
		Map<String, Field> fieldMap = new HashMap<String, Field>();
		Map<String, Class<?>> fieldTypeMap = new HashMap<String, Class<?>>();
		for (Field field : fields) {
			String fieldName = field.getName();
			Class<?> fieldType = field.getType();
			fieldMap.put(fieldName, field);
			fieldTypeMap.put(fieldName, fieldType);
		}
		Set<Entry<String, Object>> set = jsonObject.entrySet();
		for (Entry<String, Object> entry : set) {
			String entryKey = entry.getKey();
			Object obj = entry.getValue();
			if(fieldTypeMap.containsKey(entryKey)){
				Field field = fieldMap.get(entryKey);
				Class<?> fieldType = fieldTypeMap.get(entryKey);
				/**
				 * 判断fieldType 是什么类型
				 * 1.基本类型int,double,float,long,short,boolean,byte,char
				 * 2.引用类型String
				 * 3.指针类型List Set Map Collection
				 */
				boolean b = true;//isSimple(fieldType);
				if(!b){
					JSONObject childJsonObject = JSONObject.parseObject(obj.toString());
					object = delWithNew(fieldType.toString(), childJsonObject);
				}else {
					field.setAccessible(true);
					field.set(object, entry.getValue());
				}
			}
		}
		return object;
	}
	public boolean isSimple(Class<?> clazz, Object object){
		boolean b = false;
		if(object instanceof Integer){
			b = true;
		}
		if(object instanceof Double){
			b = true;
		}
		if(object instanceof Float){
			b = true;
		}
		if(object instanceof Long){
			b = true;
		}
		if(object instanceof Short){
			b = true;
		}
		if(object instanceof Boolean){
			b = true;
		}
		if(object instanceof Byte){
			b = true;
		}
		if(object instanceof Character){
			b = true;
		}
		if(object instanceof Void){
			b = true;
		}
		if(object instanceof String){
			b = true;
		}
		try {
//			Object obj = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			b = true;
		}
		return b;
	}
	
	
	
	
	@Test
    public void Test0000() throws IOException {
 
        String jsonStr = "{\"unuse\":\"A中没有的字段\",\"count\":\"2\",\"infos\":[{\"withOut\":\"B中没有的字段\",\"id\":\"119\",\"name\":\"zhansan\"},{\"withOut\":\"B中没有的字段\",\"id\":\"9527\",\"name\":\"lisi\"}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.readValue(jsonStr, A.class));
    }
 
 
    /*@JsonIgnoreProperties(ignoreUnknown = true)*/
   static class A {
        int count;
        List<B> infos;
 
        public int getCount() {
            return count;
        }
 
        public void setCount(int count) {
            this.count = count;
        }
 
        public List<B> getInfos() {
            return infos;
        }
 
        public void setInfos(List<B> infos) {
            this.infos = infos;
        }
 
        @Override
        public String toString() {
            return "A{" +
                    "count=" + count +
                    ", infos=" + infos +
                    '}';
        }
    }
 
   /* @JsonIgnoreProperties(ignoreUnknown = true)*/
     static class B {
        int id;
        String name;
 
        public int getId() {
            return id;
        }
 
        public void setId(int id) {
            this.id = id;
        }
 
        public String getName() {
            return name;
        }
 
        public void setName(String name) {
            this.name = name;
        }
 
        @Override
        public String toString() {
            return "B{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
