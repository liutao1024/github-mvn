package cn.spring.mvn.socket.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.spring.mvn.base.entity.SystemTransaction;
import cn.spring.mvn.base.entity.SystemTransactionInformation;
import cn.spring.mvn.base.entity.service.SystemTransactionInformationService;
import cn.spring.mvn.base.entity.service.SystemTransactionService;
import cn.spring.mvn.base.tools.BaseReflection;
import cn.spring.mvn.base.tools.BaseTool;
import cn.spring.mvn.comm.tools.DateTool;
import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.socket.Comm;
import cn.spring.mvn.socket.Sys;
import cn.spring.mvn.socket.tools.SocketTool;
import cn.spring.mvn.socket.utils.SocketUtil;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author LiuTao @date 2018年6月13日 下午10:32:13
 * @ClassName: SocketHandlerImpl 
 * @Description: 接收到客户端发送的消息后,登记交易记录表和执行交易
 * 接口定义表字段:交易码,交易所在类,交易对应方法.....
 * 交易记录表字段:交易码,执行时间,执行结果,信息,输入报文,输出报文
 */
public class SocketOperatorImpl {
	private static String ERROR = "ERROR";
	private static String SUCCESS = "SUCCESS";
	private static String INPUT = "Input";
	private static String OUTPUT = "Output";
	private static final Logger LOGGER = LoggerFactory.getLogger(SocketOperatorImpl.class);
	//
	private static SystemTransactionService systemTransactionServiceImpl = (SystemTransactionService) SpringContextUtil.getBean("SystemTransactionService");
	private static SystemTransactionInformationService systemTransactionInformationServiceImpl = (SystemTransactionInformationService) SpringContextUtil.getBean("SystemTransactionInformationService");
	
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
	 * @param <T>
	 * @Title: call 
	 * @Description: TODO(Describe) 
	 * @param jsonStr
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @note 仍然存在的问题: 1.在发生异常时,不能捕获,而是直接在代码中抛出并中断了程序
	 */
	public static String call(String reqJsonStr, String ipAddress) throws JsonParseException, JsonMappingException, IOException{
		//每次调用重新创建生成否则发布后这个这些值将不变
		String serial = BaseTool.getSerial();
		String trandt = DateTool.getNow(DateTool.YYYYMMDD);
		String trantm = DateTool.getNow(DateTool.YYYYMMDDHHMMSS);
		
		String rspJsonStr = "";
		String status = ""; 
		String mesage = ""; 
		Sys sys = new Sys();
		Comm comm = new Comm();
		Object objInput = new Object();
		Object objOutput = new Object();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SocketTool.parseRequest(reqJsonStr, map);//形参与实参的区别与联系注意参数的数据类型(指针类与非指针类)
			sys = (Sys) map.get(SocketUtil.SYS_REQ);
			comm = (Comm) map.get(SocketUtil.COMM_REQ);
			objInput = map.get(SocketUtil.INPUT);
			String prcscd = comm.getPrcscd();
			LOGGER.info("=====prcscd=====" + prcscd);
			//根据prcscd在系统中获取prcscd.xml文件
			/**
			 * 需要加载配置的接口文件.xml吗?貌似没有必要了,因为最后的input和output还都得定义成public的java类,否则涉及到权限访问问题
			 * 如果要加载判断的话,会出现加载不了的问题
			 * 		因为,这些项目都是被封成了jar包的并且这些xml文件也是封在jar里面的,而通过
			 * 		File xmlFile = ResourceUtils.getFile("classpath:ehcache" + POSTFIX);
			 * 		File xmlFile = new File("classpath:ehcache" + POSTFIX)
			 * 		都不能读取到这些配置文件,
			 * 解决方案: 1.想办法在项目启动时将jar包中的配置文件解析到web项目中
			 * 		    2.直接读取jar包中resources中的配置文件
			 * 
			 * 这里我选择不加载配置文件
			 */
//			File xmlFile = ResourceUtils.getFile("classpath:ehcache" + POSTFIX);//
//			File xmlFile = new File(PATH + prcscd + POSTFIX);//
//			String s = SocketOperatorImpl.class.getClassLoader().getResource("/xml/" + prcscd + POSTFIX).getPath();
			boolean exists = true;//xmlFile.exists()
			if(exists){
				SystemTransaction systemTransaction = systemTransactionServiceImpl.selectOne(prcscd, "");
				if(CommUtil.isNotNull(systemTransaction) && "YES".equals(systemTransaction.getRunmak())){
					String path = systemTransaction.getPath();
					String module = systemTransaction.getModule();
					String eclass = systemTransaction.getEclass();
					String method = systemTransaction.getMethod();
					//获取实现类
					String className = path + CommUtil.DOT + module + CommUtil.ZPORTIMPL + eclass;
					//方法名
					String methodName = method;
					/**
					 * 分割线
					 */
					
					//将objInput转成接口对应的接口Input类
					//input 和 output如何精确的定位到该方法对应的两个类
					//prcscd首字母大写
					String Prcscd = prcscd.substring(0, 1).toUpperCase() + prcscd.substring(1);
					String inputClassStr = path + CommUtil.DOT + module + CommUtil.ZPORT + Prcscd + INPUT;
					String outputClassStr = path + CommUtil.DOT + module + CommUtil.ZPORT + Prcscd + OUTPUT;
					Class<?> inClass = BaseReflection.getClassByClassName(inputClassStr);
					Class<?> outClass = BaseReflection.getClassByClassName(outputClassStr);
					//当接收到的input的字段比我们自己定义的input类多时需要怎么处理
					objInput = SocketTool.praseToClass(inClass, objInput);
					objOutput = SocketTool.praseToClass(outClass, objOutput);
					//就算objInput 和objOutput是null也要返回一个空对象
//					Qrcust.input;
//					Qrcust i = new Qrcust();
					//接口的输入输出都需要封装成类 input.class,output.class
					Class<?>[] classes = {inClass, outClass};
					//input output
					Object[] objects = {objInput, objOutput};
					
					/**
					 * 分割线
					 */
					BaseReflection.executeMethodByClassNameAndMethodName(className, methodName, classes, objects);
					status = SUCCESS;
				}else {
					status =  ERROR;
					mesage = prcscd + "接口未定或已失效!";
				}
			}else {
				status =  ERROR;
				mesage = prcscd + "接口文件不存在!";
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
			sys.setTrandt(trandt);
			sys.setTrantm(trantm);
			sys.setTransq(serial);
			sys.setStatus(status);
			sys.setMesage(mesage);
			rspJsonStr = SocketTool.formatResponse(sys, comm, objOutput);
			//登记通讯处理记录
			SystemTransactionInformation systemTransactionInformation = new SystemTransactionInformation();
			systemTransactionInformation.setSerialNumber(serial);
			systemTransactionInformation.setSerialDate(trandt);
			systemTransactionInformation.setSerialTime(trantm);
			systemTransactionInformation.setIpAddress(ipAddress);//
			systemTransactionInformation.setInput(reqJsonStr);
			systemTransactionInformation.setOutput(rspJsonStr);
			systemTransactionInformation.setErrorMesage(mesage);
			systemTransactionInformation.setTimesTamp(String.valueOf(System.currentTimeMillis()));
			systemTransactionInformationServiceImpl.insertSystemTransactionInformation(systemTransactionInformation);
		}
		return rspJsonStr;
	}
}
