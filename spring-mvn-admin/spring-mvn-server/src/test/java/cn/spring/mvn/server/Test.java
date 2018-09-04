package cn.spring.mvn.server;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import cn.spring.mvn.server.tools.RequestMap;
import cn.spring.mvn.base.util.BaseUtil;
import cn.spring.mvn.core.account.entity.CustUser;

import com.alibaba.fastjson.JSONObject;

public class Test {
	
	
	@SuppressWarnings("unchecked")
	@org.junit.Test
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
	
	
	
	@org.junit.Test
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
	
	@org.junit.Test
	public void TestStringToJson(){
		String s = "{comm={mesage=新增成功, status=SUCCESS}, data=[{custna=渣渣辉, custno=979497772, opensq=763728388979454954773272}], sys={servtp=01, servno=02, cropno=001}}";
		JSONObject json = (JSONObject) JSONObject.parse(s);
		System.out.println(json);
	}
	
	@org.junit.Test
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
		List<CustUser> custUserList = new ArrayList<CustUser>();//通过heibrnt查询出来的结果
		CustUser one = new CustUser();
		CustUser two = new CustUser();
		CustUser three = new CustUser();
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
		
		custUserList.add(one);
		custUserList.add(two);
		custUserList.add(three);
		for (CustUser custUser : custUserList) {
			//将对象的custUser转化成属性为key,属性对应值为value的map,不管这个属性上是否有值均需要写在map中无值时,赋值为""
			//commUtil中的那个方法不够用需要改造
			Map<String, Object> map = BaseUtil.getObjectMapByReflectObject(custUser);
			dataList.add(map);
		}
		responseMap.put("count", custUserList.size());
		responseMap.put("data", dataList);
		
		dstMap.put("sys", sysMap);
		dstMap.put("comm", commMap);
		dstMap.put("response", responseMap);
		JSONObject response = new JSONObject(dstMap);
		System.out.println("反馈JSON报文======" + response);
		
		
	}
}
