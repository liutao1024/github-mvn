package cn.spring.mvn.server;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import cn.spring.mvn.server.SocketHandlerImpl;
import cn.spring.mvn.server.tools.ServerTool;
import cn.spring.mvn.server.client.SocketClient;

public class ServerToolTest {
	
	
	
	@Test
	public void TestImpl(){
		Map<String, Object> requestMap = new HashMap<String, Object>();
		
		Map<String, Object> sysMap = new HashMap<String, Object>();
		Map<String, Object> commMap = new HashMap<String, Object>();
		Map<String, Object> srcMap = new HashMap<String, Object>();
		sysMap.put("corpno", "001");
		sysMap.put("servtp", "01");
		sysMap.put("servno", "02");
		
		commMap.put("corecd", "opcust");
		commMap.put("asktyp", "Q");//请求类型:Q--查询(返回的是一个list),D--执行(返回的是一个结果)
		
		srcMap.put("idtftp", "01");
		srcMap.put("idtfno", "511024199112030398");
		srcMap.put("custna", "渣渣辉");
		requestMap.put("sys", sysMap);
		requestMap.put("comm", commMap);
		requestMap.put("request", srcMap);		
		
		JSONObject obj = new JSONObject(requestMap);
		String str = SocketHandlerImpl.callInterface(obj.toString());
		System.out.println(str);
	}
	
	@Test
	public void TestServer() throws Exception{
		Map<String, Object> sysMap = new HashMap<String, Object>();
		Map<String, Object> commMap = new HashMap<String, Object>();
		Map<String, Object> srcMap = new HashMap<String, Object>();
		Map<String, Object> requestMap = new HashMap<String, Object>();
		
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
		
		SocketClient socketClient = new SocketClient();
		JSONObject json = socketClient.callClientReturnJson("127.0.0.1", 8088, requestMap);
		System.out.println(json);
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void Test0001(){
		Map<String, Object> sysMap = new HashMap<String, Object>();
		Map<String, Object> commMap = new HashMap<String, Object>();
		Map<String, Object> requestMap = new HashMap<String, Object>();
		sysMap.put("cropno", "001");
		sysMap.put("servtp", "01");
		sysMap.put("servno", "02");
		
		commMap.put("corecd", "opcust");
		commMap.put("asktyp", "D");//请求类型:Q--查询(返回的是一个list),D--执行(返回的是一个结果)
		
		requestMap.put("idtftp", "01");
		requestMap.put("idtfno", "511024199112030398");
		requestMap.put("custna", "渣渣辉");
		
		String requestJsonStr = ServerTool.praseMapsToString(sysMap, commMap, requestMap);
		System.out.println(requestJsonStr);
		Map<String, Object> reqMap = ServerTool.praseRequestStringMap(requestJsonStr);
		System.out.println(reqMap);
		Map<String, Object> request = (Map<String, Object>) reqMap.get("request");
		String custna = (String) request.get("custna");
		System.out.println(custna);
	}
}
