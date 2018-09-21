package cn.spring.mvn.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LiuTao @date 2018年6月12日 下午1:53:19
 * @ClassName: ServerManager 
 * @Description: 监听外部的消息,获取接口报文,并将处理结果已Json报文的形式返回给调用端
 */
public class SocketServer {
	/**
	 * 共同的是将接口定义在本工程中去调用其所依赖的工程的service实现数据库的操作似乎可行,
	 * 	也就是说这个项目也需要是spring+heibrnt项目,置于是否需要用到mvc好像就不一定了,
	 * 	而且还是需要通过tomcat进行发布,现在的问题是,如何实现java源码在linux环境中编译成class,
	 * 	tomcat可以指向这些class和jsp实现低依赖高耦合哈哈哈哈自己都不晓得在说什么了
	 * 几种猜想
	 * 1.继承HttpServlet,由调用端输入服务所在IP和端口号进行连接,解析客户端的请求报文,
	 * 		匹配数据库中是否有对应的接口信息,有则调用相应的接口实现方法完成功能
	 * 
	 * 2.使用传统的Socket通讯完成获取外部的消息接受,也根据请求报文完成后续步骤,
	 * 	        这个就要看看达内传奇老师的dmb项目了
	 * 
	 * 3.WebService的使用似乎是一个不错的选择,但是网上找的东西都不对且不全面,那个逼博主没有邮件估计不会看到我们的评论了
	 */
	
	//ServerSocket
	private ServerSocket serverSocket;
	// 线程池
	private ExecutorService threadPool;
	
	/**
	 * <p>Title:ServerManager构造函数 </p> 
	 * <p>Description: 实例化对象</p> 
	 * @throws Exception 存在异常时抛出异常
	 */
	public SocketServer(int port, int nThreads) throws Exception{
		this.serverSocket = new ServerSocket(port);
		//创建一个大小为30条线程的线程池 -----针对多线程访问大的设计
		this.threadPool = Executors.newFixedThreadPool(nThreads);
	}
	/**
	 * @author LiuTao @date 2018年6月13日 上午9:23:19 
	 * @Title: startSocketServer 
	 * @Description: TODO(Describe) 
	 * @throws Exception
	 */
	public void startSocketServer() throws Exception{
		while (true) {
			System.out.println("等待客户端连接...");
			Socket socket = serverSocket.accept();
			SocketHandler socketHandler = new SocketHandler(socket);
			threadPool.execute(socketHandler);
			System.out.println("一个客户端连接成功...");
		}
	}
}
