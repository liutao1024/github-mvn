package cn.spring.mvc.server;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

@SuppressWarnings("unused")
public class SocketHandler implements Runnable {
	//Socket tools
	private Socket socket;
	private byte[] array = new byte[2048];  
	//Constructor Method
	public SocketHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("SocketHandler.run");
		try {
			/**
			 * 步骤: 
			 * 1:通过Socket创建输入流 ,将Socket的输入流转换成Json报文
			 * 2:读取客户端发送过来的json格式的请求报文
			 * 3:对请求报文进行解析处理后,将处理结果通过Socket创建输出流 
			 * 4:回复客户端"OK"
			 */
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); 
			
            int n;  
            while((n = inputStream.read(array)) != -1){  
            	byteArrayOutputStream.write(array, 0, n);           
            }  
            String requesStr = new String(byteArrayOutputStream.toByteArray()); 
            socket.shutdownInput(); 
            System.out.println("========请求json报文========" + requesStr);
            String responseStr = SocketHandlerImpl.callInterface(requesStr);//responseMap.toString();
            System.out.println("========响应json报文========" + responseStr);
            DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            outputStream.writeUTF(responseStr); 
            outputStream.flush();  
            outputStream.close();  
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务器 run 异常: " + e.getMessage()); 
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
