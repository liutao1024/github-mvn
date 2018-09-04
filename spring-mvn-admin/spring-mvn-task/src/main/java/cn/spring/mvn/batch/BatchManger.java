package cn.spring.mvn.batch;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class BatchManger {
	/**
	 * 批量的管理者
	 */
	static WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	/**
	 * @author LiuTao @date 2018年6月4日 下午8:02:18 
	 * @Title: getService 
	 * @Description: TODO(Describe) 
	 * @param theClass
	 * @return
	 */
	public static <T> T getService(Class<T> theClass){
		return webApplicationContext.getBean(theClass);
	}
	
}
