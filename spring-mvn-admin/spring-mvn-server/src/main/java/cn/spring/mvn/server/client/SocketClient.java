package cn.spring.mvn.server.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * @author LiuTao @date 2018年6月12日 下午1:54:22
 * @ClassName: Client
 * @Description: 向外部发送报文并获得返回结果报文
 */
public class SocketClient {
	private static final String charSet = "UTF-8";
	/**
	 * @author LiuTao @date 2018年6月13日 上午9:20:39 
	 * @Title: callClientReturnString 
	 * @Description: TODO(Describe) 
	 * @param host
	 * @param port
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	public static String callClientReturnString(String host, int port, Map<String, Object> requestMap) throws Exception{
		Socket socket = new Socket(host, port);
		//将requestMap转化为Json类型    
		JSONObject requestJsonObject = new JSONObject(requestMap);
		String requestStr = requestJsonObject.toString();
		InputStream inputStream = socket.getInputStream();
		OutputStream outputStream = socket.getOutputStream();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, charSet));
		bufferedWriter.write(requestStr);
		bufferedWriter.flush();
		socket.shutdownOutput();
		//读取服务器端数据    
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charSet));
		String responseStr = bufferedReader.readLine();
		socket.close();
		System.out.println("输入的信息为："+ requestStr); 
		System.out.println("输出的信息为："+ responseStr); 
		return responseStr;
	}
	/**
	 * @author LiuTao @date 2018年6月13日 上午9:20:45 
	 * @Title: callClientReturnMap 
	 * @Description: TODO(Describe) 
	 * @param host
	 * @param port
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> callClientReturnMap(String host, int port, Map<String, Object> requestMap) throws Exception{
        JSONObject responseJsonObject = callClientReturnJson(host, port, requestMap);
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.putAll(responseJsonObject);
        //将Map数据返回
        return responseMap;
	}
	/**
	 * @author LiuTao @date 2018年6月13日 上午9:20:49 
	 * @Title: callClientReturnJson 
	 * @Description: TODO(Describe) 
	 * @param host
	 * @param port
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	public JSONObject callClientReturnJson(String host, int port, Map<String, Object> requestMap) throws Exception{
		String responseStr = callClientReturnString(host, port, requestMap);
		JSONObject responseJsonObject = JSONObject.parseObject(responseStr);  
		return responseJsonObject;
	}
	
	
	
	/**
	 * @author LiuTao @date 2018年6月13日 上午9:34:16 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String args[]) {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		
		Map<String, Object> sysMap = new HashMap<String, Object>();
		Map<String, Object> commMap = new HashMap<String, Object>();
		Map<String, Object> srcMap = new HashMap<String, Object>();
		sysMap.put("corpno", "001");
		sysMap.put("servtp", "01");
		sysMap.put("servno", "02");
		
		commMap.put("corecd", "qrcust");
		commMap.put("asktyp", "Q");//请求类型:Q--查询(返回的是一个list),D--执行(返回的是一个结果)
		
		srcMap.put("idtftp", "01");
		srcMap.put("idtfno", "511024198612030398");
		srcMap.put("custna", "张家辉");
		requestMap.put("sys", sysMap);
		requestMap.put("comm", commMap);
		requestMap.put("request", srcMap);
		
		try {
			callClientReturnString("localhost", 8088, requestMap);//本地
//			callClientReturnString("192.168.1.11", 8088, requestMap);//linux
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
