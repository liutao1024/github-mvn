package cn.spring.mvn.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.spring.mvn.socket.server.SocketOperatorImpl;

@Controller("DemoController")
@RequestMapping(value="/test")
public class DemoController {
	@RequestMapping("/test1")
	public void Test(HttpServletRequest request, HttpServletResponse response){
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
								"\"custna\":\"刘涛\""+
							"}"+
				"}";
		try {
//			Map<String, Object> map = new HashMap<String, Object>();
			String s = SocketOperatorImpl.call(str, new String());
//			response.s
			System.out.println("==================="+s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
