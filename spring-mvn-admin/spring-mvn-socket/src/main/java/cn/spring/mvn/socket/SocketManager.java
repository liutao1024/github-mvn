package cn.spring.mvn.socket;

public class SocketManager {
	/**
	 * @author LiuTao @date 2018年6月12日 下午4:30:10 
	 * @Title: main 
	 * @Description: 将服务器ServerManager启动起来 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int port = 8088;
			int nThreads = 50;
			SocketServer socketServer = new SocketServer(port, nThreads);
			socketServer.startSocketServer();
		} catch (Exception e) {
			System.out.println("服务器启动失败" + e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * @author LiuTao @date 2018年6月18日 下午5:54:03 
	 * @Title: initializeServer 
	 * @Description: 启动服务器
	 */
	public static void initializeServer(){
		try {
			int port = 8088;
			int nThreads = 50;
			SocketServer socketServer = new SocketServer(port, nThreads);
			socketServer.startSocketServer();
		} catch (Exception e) {
			System.out.println("服务器启动失败" + e.getMessage());
			e.printStackTrace();
		}
	}
}
