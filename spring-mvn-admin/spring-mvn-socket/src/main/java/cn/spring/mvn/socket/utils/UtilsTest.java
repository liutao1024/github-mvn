package cn.spring.mvn.socket.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.spring.mvn.basic.tools.BasicReflection;
import cn.spring.mvn.socket.Comm;
import cn.spring.mvn.socket.Input;
import cn.spring.mvn.socket.Output;
import cn.spring.mvn.socket.Sys;
import cn.spring.mvn.socket.tipc.InputR;
import cn.spring.mvn.socket.tipc.OutputI;
import cn.spring.mvn.socket.tipc.OutputR;
import cn.spring.mvn.socket.tools.SocketTool;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

//import com.demo.bean.Opcust;

@SuppressWarnings({ "rawtypes", "unused" })
public class UtilsTest {
	
	public static void Test006(){
		String s = "wo";
		int i = 2;
		System.out.println("TEST0006"+"s="+s+",i="+i);
		Change(s, i);
		System.out.println("TEST0006"+"s="+s+",i="+i);
		Set<String> str = System.getProperties().stringPropertyNames();
		for (String string : str) {
			System.out.println(string);
		}
	}
	public static void Change(String s, int i){
		System.out.println("s="+s+",i="+i);
		s = "wo变了";
		i = i+1;
		System.out.println("s="+s+",i="+i);
	}
	/**
	 * @author LiuTao @date 2018年10月23日 上午9:03:50 
	 * @throws Exception 
	 * @Title: Test005 
	 * @Description: TODO(Describe)
	 */
	public static void Test005() throws Exception{
		String str = "{"+
				"\"sys_req\":{"+
								"\"servtp\":\"MGR\","+
								"\"servno\":\"02\","+
								"\"servdt\":\"20181016\","+
								"\"servtm\":\"20:49:32:42\","+
								"\"servsq\":\"201810161120398\","+
								"\"tranbr\":\"01\","+
								"\"tranus\":\"10001\","+
								"\"trandt\":\"\","+
								"\"trantm\":\"\","+
								"\"transq\":\"\","+
								"\"status\":\"\","+
								"\"mesage\":\"\""+
							"},"+
				"\"comm_req\":{"+
								"\"corpno\":\"001\","+
								"\"prcscd\":\"qrcust\""+
							"},"+
				"\"input\":{"+
								"\"custno\":\"\","+
								"\"custna\":\"刘涛\""+
							"}"+
				"}";
		Sys sys = new Sys();
		Comm comm = new Comm();
		Object obj = new Object();
//		SocketTool.parseRequest(sys, comm, obj, str);
//		Qrcust q = new Qrcust();
		
		
		  
		String className = "cn.spring.mvn.core.account.I.Qrcust.Input";
//		Interface i = Interface.
		Class c = BasicReflection.getClassByReflectClassName(className);
		c.cast(obj);
		System.out.println(obj);
		
	}
	
	/**
	 * @author LiuTao @date 2018年10月22日 下午4:17:39 
	 * @Title: Test004 
	 * @Description: TODO(Describe)
	 */
	public void Test004(){
		OutputR r = new OutputR();
		List<OutputI> list = new ArrayList<OutputI>();
		OutputI o1 = new OutputI();
		o1.setCustno("121");
//		o1.setCustna("121");
//		o1.setCustsx("121");
//		o1.setCustag("121");
		OutputI o2 = new OutputI();
		o2.setCustno("211");
//		o2.setCustna("211");
//		o2.setCustsx("211");
		list.add(o1);
		list.add(o2);
		r.setCount(2);
//		r.setOuputis(list);
//		ObjectMapper mapper = new ObjectMapper();
//		String str = mapper.writeValueAsString(r);
		String str = JSONObject.toJSONString(r,SerializerFeature.QuoteFieldNames, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullBooleanAsFalse );
		System.out.println(str);
	}
	
	/**
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @Title: Test003 
	 * @Description: TODO(Describe)
	 */
	public static void Test003() throws JsonParseException, JsonMappingException, IOException{
		Sys sys = new Sys();
		Comm comm = new Comm();
		Output output = new OutputR();  
		String response = SocketTool.formatResponse(sys, comm, output);
		System.out.println(response);
	}
	/**
	 * @author LiuTao @date 2018年10月22日 下午3:12:45 
	 * @Title: Test002 
	 * @Description: TODO(Describe) 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void Test002() throws JsonParseException, JsonMappingException, IOException{
		String str = "{"+
				"\"sys_req\":{"+
								"\"servtp\":\"MGR\","+
								"\"servno\":\"02\","+
								"\"servdt\":\"20181016\","+
								"\"servtm\":\"20:49:32:42\","+
								"\"servsq\":\"201810161120398\","+
								"\"tranbr\":\"01\","+
								"\"tranus\":\"10001\","+
								"\"trandt\":\"\","+
								"\"trantm\":\"\","+
								"\"transq\":\"\","+
								"\"status\":\"\","+
								"\"mesage\":\"\""+
							"},"+
				"\"comm_req\":{"+
								"\"corpno\":\"001\","+
								"\"prcscd\":\"qrcust\""+
							"},"+
				"\"input\":{"+
								"\"custno\":\"\","+
								"\"custna\":\"刘涛\""+
							"}"+
				"}";
		Sys sys = new Sys();
		Comm comm = new Comm();
		Input input = new InputR();  
//		SocketTool.parseRequest(sys, comm, input, str);
		System.out.println(sys);
		System.out.println(comm);
		System.out.println(input);
	}
	/**
	 * @Title: Test001 
	 * @Description: TODO(Describe)
	 */
	public static void Test001(){
//		Opcust o = new Opcust();
//		o.getComm().getAsktyp();
	}
	/**
	 * @author LiuTao @date 2018年10月22日 下午2:00:42 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//			Test003();
			Test006();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
