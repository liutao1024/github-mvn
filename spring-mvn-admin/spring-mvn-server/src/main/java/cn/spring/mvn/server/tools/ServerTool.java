package cn.spring.mvn.server.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSONObject;
/**
 * @author LiuTao @date 2018年6月13日 下午2:08:16
 * @ClassName: ServerTool 
 * @Description: 都是JSon格式的String
 */
public class ServerTool {
	/**
	 * 			发送请求
	 * @author LiuTao @date 2018年6月13日 下午1:44:00 
	 * @Title: praseMapsToString 
	 * @Description: 将请求的Map参数转换成String便于Socket传输,
	 * 			用于客户端发送请求时将请求报文塞进socket的input流里面
	 * @param sysMap
	 * @param commMap
	 * @param requestMap
	 * @return
	 */
	public static String praseMapsToString(Map<String, Object> sysMap, Map<String, Object> commMap, Map<String, Object> requestMap){
		String dstStr = "";
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("sys", sysMap);
		request.put("comm", commMap);
		request.put("request", requestMap);
		JSONObject requestJsonObject = new JSONObject(request);
		dstStr = requestJsonObject.toString();
		return dstStr;
	}
	/**
	 * 			处理请求
	 * @author LiuTao @date 2018年6月13日 下午1:49:01 
	 * @Title: praseStringToListWithInMap 
	 * @Description: 用与服务器端将客户端通过Socket传输来的塞在input里的字节流转换成 map后进行处理
	 * @param jsonStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> praseRequestStringMap(String jsonStr){
		Map<String, Object> dstMap = new HashMap<String, Object>();
		JSONObject requestJsonObject = JSONObject.parseObject(jsonStr);
		Map<String, Object> sysMap = (Map<String, Object>) requestJsonObject.get("sys");
		Map<String, Object> commMap = (Map<String, Object>) requestJsonObject.get("comm");
		Map<String, Object> requestMap = (Map<String, Object>) requestJsonObject.get("request");
		dstMap.put("sys", sysMap);
		dstMap.put("comm", commMap);
		dstMap.put("request", requestMap);
		return dstMap;
		
	}
	/**
	 * @author LiuTao @date 2018年6月13日 下午2:04:37 
	 * @Title: praseMapToString 
	 * @Description: 用于将核心处理后得到的响应Map(无问对错),
	 * 			处理成String赛到Socket的Output字节流中返回给客户端 
	 * @param responseMap 核心经过处理后返回给服务器的结果Map
	 * @return
	 */
	public static String praseMapToString(Map<String, Object> responseMap){
		String dstStr = "";
		JSONObject responseJsonObject = new JSONObject(responseMap);
		dstStr = responseJsonObject.toString();
		return dstStr;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> praseResponseStringToMap(String jsonStr){
		Map<String, Object> dstMap = new HashMap<String, Object>();
		JSONObject requestJsonObject = JSONObject.parseObject(jsonStr);
		Map<String, Object> sysMap = (Map<String, Object>) requestJsonObject.get("sys");
		Map<String, Object> commMap = (Map<String, Object>) requestJsonObject.get("comm");
		Map<String, Object> responseMap = (Map<String, Object>) requestJsonObject.get("response");
		dstMap.put("sys", sysMap);
		dstMap.put("comm", commMap);
		dstMap.put("response", responseMap);
		return dstMap;
	}
	
	/**
	 * @author LiuTao @date 2018年6月14日 下午10:16:57 
	 * @Title: getRootElement 
	 * @Description: 获取指定xml文件的主节点 
	 * @param fileName
	 * @return
	 * @throws DocumentException
	 */
	public static Element getRootElement(String fileName) throws DocumentException{
		try {
			File file = new File("./src/main/resources/interface/"+ fileName +".xml");
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(file);
			Element root = document.getRootElement();
			return root;
		} catch (DocumentException e) {
			throw e;
		}
	}
	
	/**
	 * @author LiuTao @date 2018年6月14日 下午10:15:56 
	 * @Title: getElementByRootElement 
	 * @Description: 获取指定父节点下的指定子节点 
	 * @param rootElement
	 * @param elementStr
	 * @return
	 */
	public static Element getElementByElement(Element rootElement, String elementStr){
		Element element = rootElement.element(elementStr);
		return element;
	}
	/**
	 * @author LiuTao @date 2018年6月14日 下午10:18:57 
	 * @Title: getElemenNameByElement 
	 * @Description: 获取指定节点下所有子节点的名称List集合 
	 * @param element
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getElemenNameByElement(Element element){
		List<String> rstStrList = new ArrayList<String>();
		List<Element> elementList = element.elements();
		for (Element e : elementList) {
			rstStrList.add(e.getName());
		}
		return rstStrList;
	}
	
	public static List<String> getRequestElementNameStrLits(String fileName) throws DocumentException{
		List<String> requestStrList = new ArrayList<String>();
		Element rootElement = getRootElement(fileName);
		Element requestElement = getElementByElement(rootElement, "request");
		requestStrList = getElemenNameByElement(requestElement); 
		return requestStrList;
	}
	
	public static List<String> getResponseElementNameStrLits(String fileName) throws DocumentException{
		List<String> responseStrList = new ArrayList<String>();
		Element rootElement = getRootElement(fileName);
		Element responseElement = getElementByElement(rootElement, "response");
		responseStrList = getElemenNameByElement(responseElement); 
		return responseStrList;
	}
	public static List<String> getResponseCountElementNameStrLits(String fileName) throws DocumentException{
		List<String> responseCountStrList = new ArrayList<String>();
		Element rootElement = getRootElement(fileName);
		Element responseElement = getElementByElement(rootElement, "response");
		Element responseCountElement = getElementByElement(responseElement, "count");
		responseCountStrList = getElemenNameByElement(responseCountElement); 
		return responseCountStrList;
	}
	public static List<String> getResponseDataElementNameStrLits(String fileName) throws DocumentException{
		List<String> responseDataStrList = new ArrayList<String>();
		Element rootElement = getRootElement(fileName);
		Element responseElement = getElementByElement(rootElement, "response");
		Element responseDataElement = getElementByElement(responseElement, "data");
		responseDataStrList = getElemenNameByElement(responseDataElement); 
		return responseDataStrList;
	}
}
