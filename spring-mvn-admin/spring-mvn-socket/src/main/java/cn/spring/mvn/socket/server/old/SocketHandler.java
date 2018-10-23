package cn.spring.mvn.socket.server.old;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import cn.spring.mvn.base.tools.BaseTool;

//@SuppressWarnings("unused")
public class SocketHandler implements Runnable {
	//Socket tools
	private Socket socket;
	//charSet - UTF-8
	private String charSetStr = "UTF-8";
	//Constructor Method
	public SocketHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		DataOutputStream outputStream = null;
		String string = "";
		String requestStr = ""; 
		String responseStr = "";
		try {
			/**
			 * 步骤: 
			 * 1.通过Socket创建输入流 ,将Socket的输入流转换成Json报文
			 * 2.读取客户端发送过来的json格式的请求报文
			 * 3.对请求报文进行解析处理后,将处理结果通过Socket创建输出流 
			 * 4.回复客户端"OK"
			 */
			inputStreamReader = new InputStreamReader(socket.getInputStream(), charSetStr);//解决中文字符乱码问题
			bufferedReader = new BufferedReader(inputStreamReader);
			while((string = bufferedReader.readLine()) != null){
				requestStr += string;
			}
			socket.shutdownInput();//socket数据传输完成后,关闭
            System.out.println("========请求json报文========" + requestStr);
            responseStr = SocketHandlerImpl.callInterface(requestStr);//responseMap.toString();
            System.out.println("========响应json报文========" + responseStr);
            outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            outputStream.writeUTF(responseStr); 
            inputStreamReader.close();
            bufferedReader.close();
            outputStream.flush();  
            outputStream.close();  
		} catch (Exception e) {
			e.printStackTrace();
			try {//some Exception in try return some message 
				responseStr =  "{" + 
									"\"comm\":{\"corecd\":\"\",\"mesage\":\"" + e.getMessage() + "\",\"asktyp\":\"\",\"status\":\"ERROR\"}," + 
									"\"sys\":{\"servtp\":\"\",\"servno\":\"\",\"serial\":\"" + BaseTool.getSerial() + "\",\"corpno\":\"\"}" +
							   "}";
				outputStream.writeUTF(responseStr);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("服务器 run 异常--1: " + e.getMessage()); 
			} 
			System.out.println("服务器 run 异常--2: " + e.getMessage()); 
		} finally {
			if (socket != null) {
				try {
					inputStreamReader.close();
		            bufferedReader.close();
		            outputStream.flush();  
		            outputStream.close(); 
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
