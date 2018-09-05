package cn.spring.mvn.batch.tools;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.spring.mvn.base.tools.BaseReflection;
import cn.spring.mvn.base.util.BaseUtil;
import cn.spring.mvn.batch.BatchManger;


@SuppressWarnings({"rawtypes", "unchecked"})
public class BatchTools {
	
	/**
	 * @author LiuTao @date 2018年6月4日 下午10:03:14 
	 * @Title: getAttributeByAutowiredAnnotation 
	 * @Description:获取子类的所有带@Autowired注解的属性并将webApplicationContext中对应的bean对象赋给子类对应的属性
	 * @param fileList
	 * @return
	 */
	public static List<Object> getAttributeByAutowiredAnnotation(List<String> fileList) throws Exception{
		List<String> subFileList = new ArrayList<String>();
		List<Object> subObjectList = new ArrayList<Object>();
		try {
			for(String classStr : fileList){
				//反射的得到子类
				if(BaseReflection.isChildClass(classStr, BatchManger.class)){
					subFileList.add(classStr);
				}
			}
			for(String subClassStr : subFileList){
				Class subClass = BaseReflection.getClassByClassName(subClassStr);
				Object obj = subClass.newInstance();
				Map<Type, Object> map = new HashMap<Type, Object>();
				map = BaseUtil.getAttributeAnnotationByReflectAutowired(obj);
				for (Entry<Type, Object> entry : map.entrySet()) {
					Class s = (Class) entry.getKey();
					Object object = entry.getValue();
					object = BatchManger.getService(s);
					subObjectList.add(object);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return subObjectList;
	}
}