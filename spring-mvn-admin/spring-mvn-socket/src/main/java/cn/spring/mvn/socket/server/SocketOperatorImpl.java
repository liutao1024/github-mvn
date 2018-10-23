package cn.spring.mvn.socket.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.spring.mvn.base.entity.SystemTransaction;
import cn.spring.mvn.base.entity.service.SystemTransactionService;
import cn.spring.mvn.base.tools.BaseReflection;
import cn.spring.mvn.base.tools.BaseTool;
import cn.spring.mvn.base.tools.DateTool;
import cn.spring.mvn.base.util.BaseUtil;
import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.core.account.Myinput;
import cn.spring.mvn.core.account.Myoutput;
import cn.spring.mvn.core.account.zinput.Qrcust;
import cn.spring.mvn.socket.Comm;
import cn.spring.mvn.socket.Sys;
import cn.spring.mvn.socket.tools.SocketTool;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
//import org.spring.mvn.core.account.ObjectToMapTest;

/**
 * @author LiuTao @date 2018年6月13日 下午10:32:13
 * @ClassName: SocketHandlerImpl 
 * @Description: 接收到客户端发送的消息后,登记交易记录表和执行交易
 * 接口定义表字段:交易码,交易所在类,交易对应方法.....
 * 交易记录表字段:交易码,执行时间,执行结果,信息,输入报文,输出报文
 */
@SuppressWarnings({"unchecked", "unused", "rawtypes"})
public class SocketOperatorImpl {
	private static String ERROR = "ERROR";
	private static String SUCCESS = "SUCCESS";
	private static String SERIAL = BaseTool.getSerial();
	private static String TRANDT = DateTool.getNow(DateTool.YYYYMMDD);
	private static String TRANTM = DateTool.getNow(DateTool.YYYYMMDDHHMMSS);
//	private static String SERIAL = BaseTool.getSerial();
	private static SystemTransactionService systemTransactionServiceImpl = (SystemTransactionService) SpringContextUtil.getBean("SystemTransactionService");
	
	/**
	 * 1.请求报文格式为:
	 * 	{
	 * 		"sys_req":{
	 * 					"servtp":"MGR",
	 * 					"servno":"02",
	 * 					"servdt":"20181016",
	 * 					"servtm":"20:49:32:42",
	 * 					"servsq":"201810161120398",
	 * 					"tranbr":"01",
	 * 					"tranus":"10001",
	 * 					"trandt":"",
	 * 					"trantm":"",
	 * 					"transq":"",
	 * 					"status":"",
	 * 					"retcod":"",
	 * 					"retmsg":""
	 * 			  },
	 * 		"comm_req":{
	 * 					"corpno":"001",
	 * 					"prcscd":"qrcust"
	 * 				},
	 * 		"input":{
	 * 					"custno":"",
	 * 					"custna":"刘涛"
	 * 				}
	 * 		
	 * 	}
	 * sys_reqp和comm_req中的字段固定,接口内容一般放在input中
	 * 
	 * 2.响应报文的格式为:
	 * (查询类)
	 * {
	 * 		"sys_rsp":{
	 * 					"servtp":"MGR",
	 * 					"servno":"02",
	 * 					"servdt":"20181016",
	 * 					"servtm":"20:49:32:42",
	 * 					"servsq":"201810161120398",
	 * 					"tranbr":"01",
	 * 					"tranus":"10001",
	 * 					"trandt":"20181016",
	 * 					"trantm":"20:49:33:42",
	 * 					"transq":"0bfc22b296224axaa7b11fe7036a7c61",
	 * 					"status":"SUCCUS",(ERROR)
	 * 					"mesage":""
	 * 			  	},
	 * 		"comm_rsp":{
	 * 					"corpno":"001",
	 * 					"prcscd":"qrcust"
	 * 				},
	 * 		"output":{
	 * 					"count":"4",
	 * 					"infos":[
	 *						      {"custna":"刘德华","custno":"201110241001","idtfno":"511024199112030398","idtftp":"SFZ","email":""},
	 *			 				  {"custna":"张家辉","custno":"201110241002","idtfno":"511024198612030398","idtftp":"SFZ","email":""},
	 *			 				  {"custna":"陈小春","custno":"201110241003","idtfno":"511024198512030398","idtftp":"SFZ","email":""},
	 *			 				  {"custna":"古天乐","custno":"201110241004","idtfno":"511024198812030398","idtftp":"SFZ","email":""}
	 *							]
	 * 				},
	 * 		"retCode":"0000",
	 * 		"retMsg":""
	 * }
	 * (执行类)
	 * {
	 * 		"sys_rsp":{
	 * 					"servtp":"MGR",
	 * 					"servno":"02",
	 * 					"servdt":"20181016",
	 * 					"servtm":"20:49:32:42",
	 * 					"servsq":"201810161120398",
	 * 					"tranbr":"01",
	 * 					"tranus":"10001",
	 * 					"trandt":"20181016",
	 * 					"trantm":"20:49:33:42",
	 * 					"transq":"0bfc22b296224axaa7b11fe7036a7c61",
	 * 					"status":"SUCCUS",(ERROR)
	 * 					"mesage":"执行成功"
	 * 			  	},
	 * 		"comm_rsp":{
	 * 					"corpno":"001",
	 * 					"prcscd":"opcust"
	 * 				},
	 * 		"output":{
	 * 					"opendt":"20181016",
	 * 					"opensq":"0bfc22b296224axaa7b11fe7036a7c61",
	 * 					"custno":"6010000123",
	 * 					"trandt":"20181016"
	 * 				},
	 * 		"retCode":"0000",
	 * 		"retMsg":""
	 * }
	 * sys_rsp和comm_rsp中的字段固定,接口字段在output
	 */
	/**
	 * @author LiuTao @date 2018年10月16日 上午10:37:35 
	 * @Title: call 
	 * @Description: TODO(Describe) 
	 * @param jsonStr
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static String call(String reqJsonStr) throws JsonParseException, JsonMappingException, IOException{
		String rspJsonStr = "";
		String status = ""; 
		String mesage = ""; 
		Sys sys = new Sys();
		Comm comm = new Comm();
		Object objInput = new Object();
		Object objOutput = new Object();
		try {
			SocketTool.parseRequest(sys, comm, objInput, reqJsonStr);
			String prcscd = comm.getPrcscd();
			SystemTransaction systemTransaction = systemTransactionServiceImpl.selectOne(prcscd, "");
			if(CommUtil.isNotNull(systemTransaction) && "YES".equals(systemTransaction.getRunmak())){
				String path = systemTransaction.getPath();
				String module = systemTransaction.getModule();
				String eclass = systemTransaction.getEclass();
				String method = systemTransaction.getMethod();
				//获取实现类
				String className = path + "." + module + "." + eclass;
				//方法名
				String methodName = method;
				//将objInput转成接口对应的接口Input类
				//input 和 output如何精确的定位到该方法对应的两个类
				String inputClassStr = path + "." + module + "." + prcscd + "." + "input";//prcscd首字母大写
				String outputClassStr = path + "." + module + "." + prcscd + "." + "output";//prcscd首字母大写
				Class inClass = BaseReflection.getClassByClassName(inputClassStr);
				Class outClass = BaseReflection.getClassByClassName(outputClassStr);
//				Qrcust.input;
//				Qrcust i = new Qrcust();
				//接口的输入输出都需要封装成类 input.class,output.class
				Class[] classes = {inClass, outClass};
				//input output
				Object[] objects = {objInput, objOutput};
				
				
				BaseReflection.executeMethodByClassNameAndMethodName(className, methodName, classes, objects);
				status = SUCCESS;
			}else {
				status =  ERROR;
				mesage = "";
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
			status =  ERROR;
			mesage = e.getMessage();
		} catch (JsonMappingException e) {
			e.printStackTrace();
			status =  ERROR;
			mesage = e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			status =  ERROR;
			mesage = e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			status =  ERROR;
			mesage = e.getMessage();
		}finally{
			sys.setTrandt(TRANDT);
			sys.setTrantm(TRANTM);
			sys.setTransq(SERIAL);
			sys.setStatus(status);
			sys.setMesage(mesage);
			rspJsonStr = SocketTool.formatResponse(sys, comm, objOutput);
		}
		return rspJsonStr;
	}
	/**
	 * @author LiuTao @date 2018年10月16日 上午10:35:35 
	 * @Title: callInterface 
	 * @Description: 将请求进行转换并对应出后方的实现 
	 * @param jsonStr
	 * @return
	 */
	public static String callInterface(String jsonStr){
		String returnString = "";
		String responseStatus = "";
		String responseMesage = "";
		String responseSerial = BaseTool.getSerial();
		
		Map<String, Object> requestMap = new HashMap<String, Object>();
		Map<String, Object> requestSysMap = new HashMap<String, Object>();
		Map<String, Object> requestCommMap = new HashMap<String, Object>();
		Map<String, Object> requestDataMap = new HashMap<String, Object>();
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		Map<String, Object> responseSysMap = new HashMap<String, Object>();
		Map<String, Object> responseCommMap = new HashMap<String, Object>();
		Map<String, Object> responseDataMap = new HashMap<String, Object>();
		
		String corpno = "";
		String servtp = "";
		String servno = "";
		String serial = "";

		String corecd = "";
		String asktyp = "";
		String status = "";
		String mesage = "";

		try {
			requestMap = SocketTool.praseRequestStringMap(jsonStr);
			
			requestSysMap = (Map<String, Object>) requestMap.get("sys");
			requestCommMap = (Map<String, Object>) requestMap.get("comm");
			requestDataMap = (Map<String, Object>) requestMap.get("request");
			
			corpno = (String) requestSysMap.get("corpno");//机构
			servtp = (String) requestSysMap.get("servtp");//渠道类型
			servno = (String) requestSysMap.get("servno");//渠道号
			serial = (String) requestSysMap.get("serial");//流水号

			corecd = (String) requestCommMap.get("corecd");//交易码,接口定义表中的唯一索引
			asktyp = (String) requestCommMap.get("asktyp");//请求类型:Q--查询类,D--执行类
			status = (String) requestCommMap.get("status");
			mesage = (String) requestCommMap.get("mesage");

			
			responseSysMap.put("corpno", corpno);
			responseSysMap.put("servtp", servtp);
			responseSysMap.put("servno", servno);
			responseSysMap.put("serial", responseSerial);
			if(CommUtil.isNull(corecd)){
				responseStatus = ERROR;
				responseMesage = "交易码corecd不能为空";
				
				responseCommMap.put("corecd", corecd);
				responseCommMap.put("asktyp", asktyp);
				responseCommMap.put("status", responseStatus);
				responseCommMap.put("mesage", responseMesage);

				responseMap.put("sys", responseSysMap);
				responseMap.put("comm", responseCommMap);
			}else if(CommUtil.isNull(asktyp)){
				responseStatus = ERROR;
				responseMesage = "请求类型asktyp不能为空";
				
				responseCommMap.put("corecd", corecd);
				responseCommMap.put("asktyp", asktyp);
				responseCommMap.put("status", responseStatus);
				responseCommMap.put("mesage", responseMesage);
				
				responseMap.put("sys", responseSysMap);
				responseMap.put("comm", responseCommMap);
			}else{
				//根据接口文件将接口的input内容从requestDataMap中取出来,并赋值给掉用的方法
				//还是通过反射做,但是发射如何给方法传参数需要百度 
				//用xml配置报文不太好,因为在接口处理后,根据xml里面的节点进行后续组装responseMap时,
				//必须要获取节点的具体字段才能准确的将值放进对应的key里面
	//			List<String> requestStrList = ServerTool.getRequestElementNameStrLits(corecd);
	//			for (String string : requestStrList) {//
	//				
	//			}
				//迭代器获取requestDataMap中的参数作为传递的数据
//				for (Entry<String, Object> entry : requestDataMap.entrySet()) {
//					
//				}
				//将参数传入需要执行的方法签名如何实现------???未知???
				Map<String, Object> rstMap = new HashMap<String, Object>();//调用接口后得到的map
				//根据接口类型(asktyp)选择返回接口response的抓成方式
				try {
					/**
					 * 根据请求中comm中的corecd+asktyp在交易定义表sys_transaction中查询是否存在,
					 * 	1.存在,有且只有一条(主键)根据交易码获得是否执行标志transactionMark,
					 * 		判断后反编译执行 transactionModule+transactionMethod
					 * 	2.不存在,返回错误信息
					 */
					SystemTransaction systemTransaction = systemTransactionServiceImpl.selectOne(corecd, asktyp);
					if(CommUtil.isNotNull(systemTransaction) && "YES".equals(systemTransaction.getRunmak())){
						String module = systemTransaction.getModule();
						String eclass = systemTransaction.getEclass();
						String method = systemTransaction.getMethod();
						String className = "cn.spring.mvn." + module + "." + eclass;
						String methodName = method;
						Class[] classes = {Myinput.class, Myoutput.class};//接口的输入输出都需要封装成类 input.class,output.class
						Myinput input = new Myinput();
						Myoutput output = new Myoutput();
						Object[] objects = {input, output};//input output
						BaseReflection.executeMethodByClassNameAndMethodName(className, methodName, classes, objects);
						rstMap = BaseUtil.objectToMap(output);
//						rstMap = AccountServiceImpl.queryCustUser("01", "", "测试");
//						rstMap = CoreServerImpl.openAccount(corpno, (String) requestDataMap.get("idtftp"), (String) requestDataMap.get("idtfno"), (String) requestDataMap.get("custna"));
//						rstMap.put("custno", SequenceTool.getSequence("USER"));
						if("Q".equals(asktyp)){//Q 
							responseDataMap.putAll(rstMap);
						}else {//D
							responseDataMap.put("data", rstMap);
						}
						responseStatus = SUCCESS;
						responseMesage = "请求成功";
					}else {
						responseStatus = ERROR;
						responseMesage = "表[sys_transaction],无对应记录!";
					}
					responseCommMap.put("corecd", corecd);
					responseCommMap.put("asktyp", asktyp);
					responseCommMap.put("status", responseStatus);
					responseCommMap.put("mesage", responseMesage);
				} catch (Exception exception) {
					responseStatus = ERROR;
					responseMesage = exception.getMessage();
					responseCommMap.put("corecd", corecd);
					responseCommMap.put("asktyp", asktyp);
					responseCommMap.put("status", responseStatus);
					responseCommMap.put("mesage", responseMesage);
				}
				//调用的具体执行方法都必须返回的是一个map
	//			responseMap = 
				
				responseMap.put("sys", responseSysMap);
				responseMap.put("comm", responseCommMap);
				responseMap.put("response", responseDataMap);
			}
		} catch (Exception e) {
			responseStatus = ERROR;
			responseMesage = e.getMessage();
			responseSysMap.put("corpno", corpno);
			responseSysMap.put("servtp", servtp);
			responseSysMap.put("servno", servno);
			responseSysMap.put("serial", responseSerial);
			
			responseCommMap.put("corecd", corecd);
			responseCommMap.put("asktyp", asktyp);
			responseCommMap.put("status", responseStatus);
			responseCommMap.put("mesage", responseMesage);
			
			responseMap.put("sys", responseSysMap);
			responseMap.put("comm", responseCommMap);
			
		}
		returnString = SocketTool.praseMapToString(responseMap);
		return returnString;
	}
}
