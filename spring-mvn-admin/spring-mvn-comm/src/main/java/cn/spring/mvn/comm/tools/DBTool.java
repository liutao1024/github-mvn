package cn.spring.mvn.comm.tools;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.dbcp.BasicDataSource;

public class DBTool {

	/**DBCP 连接池*/
	private static BasicDataSource basicDataSource;
	/***/
	private static String driverName; 
	/***/
	private static String url;
	/***/
	private static String username;
	/***/
	private static String password;
	/**读取jdbc配置文件 --- java.util.Properties用来读取配置文件*/
	private static Properties properties = new Properties();
	static {
		try {
			// 通过文件流读取并解析配置文件内容
//			properties.load(new FileInputStream("./src/main/resources/jdbc.properties")); modified at 20180603
			properties.load(new FileInputStream("D:\\Eclipse\\eclipse-workspaces\\spring-maven\\spring-mvc-maven\\src\\main\\resources\\jdbc.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * String getProperty(String key) 根据配置文件中每一项的key("="左边的内容)
		 * 获取对应的值("="右边的内容)
		 */
		driverName = properties.getProperty("driverName");
		url = properties.getProperty("url");
		username = properties.getProperty("userName");
		password = properties.getProperty("password");
		// 最大连接数
		int maxActive = Integer.parseInt(properties.getProperty("maxActive"));
		// 最大等待时间
		int maxWait = Integer.parseInt(properties.getProperty("maxWait"));
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driverName);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		basicDataSource.setMaxActive(maxActive);// 连接池中的最大连接数
		basicDataSource.setMaxWait(maxWait);// 最大等待时间 getConnection时有效
	}
	/**
	 * @author LiuTao @date 2018年5月15日 下午9:02:43 
	 * @Title: getSingleConnection 
	 * @Description: TODO(获取一个数据库连接Connection) 
	 * @return
	 * @throws Exception
	 */
	public static Connection getSingleConnection() throws Exception {
		Connection connection = null;
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (Exception e) {
			throw e;// TODO Auto-generated catch block
		}
	}
	/**
	 * @author LiuTao @date 2018年4月18日 下午12:04:22
	 * @Title: getConnection
	 * @Description: TODO(获取一个数据库连接)
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		try {
			/**
			 * 连接池提供了一个方法: Connection getConnection() 该方法会将当前连接池中的一个空闲连接返回
			 * 由于连接池在创建时可以设置超时时间,该时间 的作用就在这里体现,当连接池中没有空闲连接 时,该方法会进入阻塞状态,等待控线连接,若
			 * 设置的超时时间经过后,连接池依然没有空闲连接 可用时,该方法会抛出超时异常。
			 */
			return basicDataSource.getConnection();
		} catch (Exception e) {
			System.out.println("连接数据库异常");
			throw e;
		}
	}

	/**
	 * @author LiuTao @date 2018年5月15日 下午5:37:59 
	 * @Title: callFunctions 
	 * @Description: TODO(根据传入的sqlStr执行存储过程) 
	 * @param sqlStr sqlStr和treeMap有对应关系,
	 * 					1.sqlStr严格按{? = call function_name(?,?,?...)}格式组成
	 * 					2.treeMap<Integer, Object>是有序的且是按key键的HashCode值排序,
	 * 						所以treeMap中必须有key值为1,且是连续的
	 * 							1--------?
	 * 							2--------?
	 * 							3--------?
	 * 						
	 * @param params
	 * @return 
	 * @throws Exception
	 */
	public static Object callFunctions(String sqlStr, TreeMap<Integer, Object> treeMap) throws Exception{
		Object theResult = null;
		try {
			Connection connection = getConnection();
			CallableStatement callableStatement  = connection.prepareCall(sqlStr);//"{? = call fn_calc_zzd_r1(?, ?)}")
			//获取treeMap的key值
			Set<Integer> keys = treeMap.keySet();
			for(Integer key : keys){//遍历Set
				if(key == 1){
//					callableStatement.registerOutParameter(1, (int) treeMap.get(1));
				}else {
					callableStatement.setObject(key, treeMap.get(key));
				}
			}
			//JDBC执行
			callableStatement.execute();
			theResult = callableStatement.getString(1);
			callableStatement.close();
			connection.close();
			return theResult;
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * @author LiuTao @date 2018年4月18日 下午12:04:10
	 * @Title: close
	 * @Description: TODO(DBUtil类中添加关闭数据库连接的代码)
	 * @param conn
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author LiuTao @date 2018年4月18日 下午12:04:01
	 * @Title: rollback
	 * @Description: TODO(回滚数据库事务)
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
