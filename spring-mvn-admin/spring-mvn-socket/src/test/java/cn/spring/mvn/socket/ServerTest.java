package cn.spring.mvn.socket;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import cn.spring.mvn.base.util.BaseUtil;
import cn.spring.mvn.core.amain.entity.Customer;
import cn.spring.mvn.core.amain.zport.QrcustOutput;
import cn.spring.mvn.socket.tools.RequestMap;

import com.alibaba.fastjson.JSONObject;

@SuppressWarnings("unused")
public class ServerTest {
	
	/**
	 * @author LiuTao @date 2018年10月25日 下午1:12:57 
	 * @throws Exception 
	 * @Title: TestReflect 
	 * @Description: TODO(Describe)
	 */
	@Test
	public void TestReflect() throws Exception{
//		String str = "{\"custna\":\"刘涛\",\"acctno\":\"9527\"}";
		String str = "{\"count\":2,\"infos\":[{\"addrcd\":\"\",\"addres\":\"中国香港\",\"birthd\":\"\",\"brchno\":\"\",\"closdt\":\"\",\"clossq\":\"\",\"corpno\":\"\",\"cuslvl\":\"\",\"custna\":\"张家辉\",\"custno\":\"7011001100002\",\"custst\":\"1\",\"datetm\":\"\",\"emails\":\"\",\"emplcu\":\"\",\"idtfno\":\"511024198612030398\",\"idtftp\":\"01\",\"opendt\":\"\",\"opensq\":\"\",\"postcd\":\"\",\"sextyp\":\"1\",\"teleno\":\"18581598359\",\"timetm\":\"\"},{\"addrcd\":\"\",\"addres\":\"中国四川\",\"birthd\":\"\",\"brchno\":\"\",\"closdt\":\"\",\"clossq\":\"\",\"corpno\":\"\",\"cuslvl\":\"\",\"custna\":\"刘涛\",\"custno\":\"7011001100001\",\"custst\":\"2\",\"datetm\":\"\",\"emails\":\"\",\"emplcu\":\"\",\"idtfno\":\"511024199112030398\",\"idtftp\":\"01\",\"opendt\":\"\",\"opensq\":\"\",\"postcd\":\"\",\"sextyp\":\"1\",\"teleno\":\"15928435559\",\"timetm\":\"\"}]}";
//		String className = "cn.spring.mvn.core.account.zport.QrcustInput";
		String className = "cn.spring.mvn.core.account.zport.QrcustOutput";
		JSONObject jsonObject = JSONObject.parseObject(str);
		Object object = delWithNew(className, jsonObject);
		
		QrcustOutput out = (QrcustOutput)object;
		int c = out.getCount();
		List<Customer> list = out.getInfos();
		for (Customer custUser : list) {
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

	private Object delWith(String className, JSONObject jsonObject)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Set<Entry<String, Object>> set = jsonObject.entrySet();
		List<String> entryKeyList = new ArrayList<String>();
		Map<String, Object> entryMap = new HashMap<String, Object>();
		for (Entry<String, Object> entry : set) {
			Object obj = entry.getValue();
			
			JSONObject childJsonObject = JSONObject.parseObject(obj.toString());
			obj = delWith("", childJsonObject);
			entryMap.put(entry.getKey(), obj);
			entryKeyList.add(entry.getKey());
		}
		Class<?> clazz = Class.forName(className);
		Object object = clazz.newInstance();
		//
		List<String> fieldNameList = new ArrayList<String>();
		List<String> methodNameList = new ArrayList<String>();
		
		//1.处理类的属性
		Field[] fields  = clazz.getFields();//获取所有public的属性
		Field[] declaredFields  = clazz.getDeclaredFields();//获取自己定义的属性(是否包括父类的呢)
		for (Field field : declaredFields) {
			fieldNameList.add(field.getName());
			String fieldName = field.getName();
			if(entryKeyList.contains(fieldName)){
				field.setAccessible(true);
				field.set(object, entryMap.get(fieldName));
			}
		}
		return object;
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
				boolean b = isSimple(fieldType);
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
	private boolean isSimple(Class<?> clazz){
//		assertEquals
		boolean b = false;
		try {
			Object obj = clazz.newInstance();
			if(obj instanceof Integer){
				b = true;
			}
			if(obj instanceof Double){
				b = true;
			}
			if(obj instanceof Float){
				b = true;
			}
			if(obj instanceof Long){
				b = true;
			}
			if(obj instanceof Short){
				b = true;
			}
			if(obj instanceof Boolean){
				b = true;
			}
			if(obj instanceof Byte){
				b = true;
			}
			if(obj instanceof Character){
				b = true;
			}
			if(obj instanceof Void){
				b = true;
			}
			if(obj instanceof String){
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			b = true;
		}
		return b;
	}
	@Test
	public void Test00007() throws Exception{
		QrcustOutput o = new QrcustOutput();
		boolean a = isSimple(o.getClass());
		int i = 1;
		boolean b = isSimple(Boolean.class);
		System.out.println(b);
	}
	@SuppressWarnings("unchecked")
	@Test
	public void TestXml() {
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("./src/main/resources/interface/opcust.xml"));
			/**
			 * 节点对象的操作方法
			 */
			//获取文档根节点
			Element root = document.getRootElement();
			//输出根标签的名字
			System.out.println(root.getName());
			//获取根节点下面的所有子节点(不包过子节点的子节点)
			List<Element> list = root.elements() ;
			//遍历List的方法
			for (Element e:list){
				System.out.println(e.getName());
			}
			//获得指定节点下面的子节点
			Element contactElem = root.element("contact");//首先要知道自己要操作的节点。 
			List<Element> contactList = contactElem.elements();
			for (Element e:contactList){
				System.out.println(e.getName());
			}  
			
			//调用下面获取子节点的递归函数。
			getChildNodes(root);
			//获得当前标签下指定名称的第一个子标签
			Element conElem = root.element("contact");
			System.out.println(conElem.getName());
			//获得更深层次的标签（一层一层的获取）
			Element nameElem = root.element("contact").element("name");
			System.out.println(nameElem.getName());
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//递归查询节点函数,输出节点名称
	@SuppressWarnings("unchecked")
	private static void  getChildNodes(Element elem){
		System.out.println(elem.getName());
		Iterator<Node> it=    elem.nodeIterator();
		while (it.hasNext()){
			Node node = it.next();
			if (node instanceof Element){
				Element e1 = (Element)node;
				getChildNodes(e1);
			}
		}
	}
	
	
	
	@Test
	public void TestRequestMap(){
		Map<String, Object> sys = new HashMap<String, Object>();
		Map<String, Object> comm = new HashMap<String, Object>();
		Map<String, Object> request = new HashMap<String, Object>();
		sys.put("cropno", "001");
		sys.put("servtp", "01");
		sys.put("servno", "02");
		
		comm.put("corecd", "opcust");
		comm.put("asktyp", "D");//请求类型:Q--查询(返回的是一个list),D--执行(返回的是一个结果)
		
		request.put("idtftp", "01");
		request.put("idtfno", "511024199112030398");
		request.put("custna", "渣渣辉");
		
		
		
		RequestMap requestMap = new RequestMap(sys, comm, request);
		JSONObject requestJ = new JSONObject(requestMap);
		System.out.println(requestJ.toString());
	}
	
	@Test
	public void TestStringToJson(){
		String s = "{comm={mesage=新增成功, status=SUCCESS}, data=[{custna=渣渣辉, custno=979497772, opensq=763728388979454954773272}], sys={servtp=01, servno=02, cropno=001}}";
		JSONObject json = (JSONObject) JSONObject.parse(s);
		System.out.println(json);
	}
	
	@Test
	public void TestMapAndJson(){
		Map<String, Object> srcMap = new HashMap<String, Object>();
		Map<String, Object> dstMap = new HashMap<String, Object>();
		
		Map<String, Object> sysMap = new HashMap<String, Object>();
		Map<String, Object> commMap = new HashMap<String, Object>();
		Map<String, Object> requestMap = new HashMap<String, Object>();
		Map<String, Object> responseMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		/**--------------------------------请求报文------------------------------*/
		sysMap.put("cropno", "001");
		sysMap.put("servtp", "01");
		sysMap.put("servno", "02");
		
		commMap.put("corecd", "opcust");
		commMap.put("asktyp", "D");//请求类型:Q--查询(返回的是一个list),D--执行(返回的是一个结果)
		
		srcMap.put("idtftp", "01");
		srcMap.put("idtfno", "511024199112030398");
		srcMap.put("custna", "渣渣辉");
		
		requestMap.put("sys", sysMap);
		requestMap.put("comm", commMap);
		requestMap.put("request", srcMap);
		JSONObject request = new JSONObject(requestMap);
		System.out.println("请求JSON报文======" + request);
		/**--------------------------------响应报文------------------------------*/
		
		sysMap.put("cropno", "001");
		sysMap.put("servtp", "01");
		sysMap.put("servno", "02");
		
		commMap.put("status", "SUCCESS");
		commMap.put("mesage", "新增成功");
		
		/**------------------------------执行类---------------------------------*/
//		responseMap.put("custno", "979497772"); 
//		responseMap.put("custna", "渣渣辉"); 
//		responseMap.put("opensq", "763728388979454954773272"); 
		
		/**--------------------------------查询类-----对应的request的报文中也应该要多点东西出来----------------------*/
		List<Customer> customerList = new ArrayList<Customer>();//通过heibrnt查询出来的结果
		Customer one = new Customer();
		Customer two = new Customer();
		Customer three = new Customer();
		one.setCustno("979494372");
		one.setCustna("古天乐");
		one.setIdtftp("01");
		one.setIdtfno("511024199102933");
		one.setTeleno("15928435557");
		
		two.setCustno("943497772");
		two.setCustna("渣渣辉");
		two.setIdtftp("01");
		two.setIdtfno("51102419910245933");
		two.setTeleno("15928455557");
		
		three.setCustno("979497652");
		three.setCustna("周星驰");
		three.setIdtftp("01");
		three.setIdtfno("51102419910297633");
		three.setTeleno("15928835557");
		
		customerList.add(one);
		customerList.add(two);
		customerList.add(three);
		for (Customer customer : customerList) {
			//将对象的custUser转化成属性为key,属性对应值为value的map,不管这个属性上是否有值均需要写在map中无值时,赋值为""
			//commUtil中的那个方法不够用需要改造
			Map<String, Object> map = BaseUtil.getObjectMapByReflectObject(customer);
			dataList.add(map);
		}
		responseMap.put("count", customerList.size());
		responseMap.put("data", dataList);
		
		dstMap.put("sys", sysMap);
		dstMap.put("comm", commMap);
		dstMap.put("response", responseMap);
		JSONObject response = new JSONObject(dstMap);
		System.out.println("反馈JSON报文======" + response);
		
		
	}
}
