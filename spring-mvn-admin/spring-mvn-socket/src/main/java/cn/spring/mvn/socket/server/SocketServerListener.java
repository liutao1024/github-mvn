package cn.spring.mvn.socket.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author LiuTao @date 2018年9月3日 下午3:25:13
 * @ClassName: SocketServiceListener 
 * @Description: TODO(将socket service随tomcat启动)
 */
public class SocketServerListener implements ServletContextListener {
	// socket server 线程
	private SocketThread socketThread;

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if (null == socketThread) {
			// 新建线程类
			socketThread = new SocketThread(null);
			// 启动线程
			socketThread.start();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if (null != socketThread && !socketThread.isInterrupted()) {
			socketThread.closeSocketServer();
			socketThread.interrupt();
		}
	}


}
