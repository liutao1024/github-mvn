package cn.spring.mvc.core.service.tset;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.spring.mvc.base.util.BaseUtil;
import cn.spring.mvc.batch.QuartzManager;
import cn.spring.mvc.batch.entity.SystemBatchTaskDispathControl;
import cn.spring.mvc.batch.entity.service.SystemBatchTaskDispathControlService;
import cn.spring.mvc.batch.task.BatchJobGroup10001;
import cn.spring.mvc.batch.tools.BatchTools;
import cn.spring.mvc.comm.tools.FileTool;
import cn.spring.mvc.comm.tools.MD5Tool;
import cn.spring.mvc.comm.util.CommUtil;
import cn.spring.mvc.server.SocketHandlerImpl;
import cn.spring.mvc.web.entity.SysDict;
import cn.spring.mvc.web.entity.SysRole;
import cn.spring.mvc.web.entity.SysUser;
import cn.spring.mvc.web.entity.service.SysRoleAuthService;
import cn.spring.mvc.web.entity.service.SysAuthService;
import cn.spring.mvc.web.entity.service.SysRoleService;
import cn.spring.mvc.web.entity.service.SysUserRoleService;
import cn.spring.mvc.web.entity.service.SysUserService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-hibernate.xml" })
public class SpringMVCHeibrntTest {
	private static final Logger LOGGER = Logger.getLogger(SpringMVCHeibrntTest.class);
	@Autowired
	private SysUserService sysUserServiceImpl;
	@Autowired
	private SysRoleService sysRoleServiceImpl;
	@Autowired
	private SysRoleAuthService sysRoleAuthServiceImpl;
	@Autowired
	private SysUserRoleService sysUserRoleServiceImpl;
	@Autowired 
	private SysAuthService sysAuthServiceImpl;
	@Autowired
	private SystemBatchTaskDispathControlService systemBatchTaskDispathControlImpl;
	/**
	 * @Test
	 */
	
	
	
	@Test
	public void TestClient(){
		
	}
	
	
	@Test
	public void TestListSize(){
		SysRole s = sysRoleServiceImpl.selectOneByPrimeKey("001", "1", "120");
		System.out.println(s);
		s.setRole_name("你好");
		sysRoleServiceImpl.saveOrUpdate(s);
	}

	
	@Test
	public void TestImpl(){
		Map<String, Object> requestMap = new HashMap<String, Object>();
		
		Map<String, Object> sysMap = new HashMap<String, Object>();
		Map<String, Object> commMap = new HashMap<String, Object>();
		Map<String, Object> srcMap = new HashMap<String, Object>();
		sysMap.put("cropno", "001");
		sysMap.put("servtp", "01");
		sysMap.put("servno", "02");
		
		commMap.put("corecd", "opcust");
		commMap.put("asktyp", "Q");//请求类型:Q--查询(返回的是一个list),D--执行(返回的是一个结果)
		
		srcMap.put("idtftp", "01");
		srcMap.put("idtfno", "511024199112030398");
		srcMap.put("custna", "渣渣辉");
		requestMap.put("sys", sysMap);
		requestMap.put("comm", commMap);
		requestMap.put("request", srcMap);		
		
		JSONObject obj = new JSONObject(requestMap);
		String str = SocketHandlerImpl.callInterface(obj.toString());
		System.out.println(str);
	}
	
	
	
	
	@Test
	public void TestSelectAllByPage(){
		String hqlStr = "from SysUser";
		int page = 10;
		int size = 10;
		Map<String, Object> map= sysUserServiceImpl.findAllByHqlPageSizeWithCount(hqlStr, page, size);
		@SuppressWarnings("unchecked")
		List<SysUser> list = (List<SysUser>) map.get("result");
		long count = (long) map.get("count");
		System.out.println(list.size());
		System.out.println(count);
		for (SysUser sysUser : list) {
			System.out.println(sysUser.getUserid());
		}
	}
	
	@Test
	public void TestQuartz(){
		String jobName = "测试";
		long time = 2000;
		QuartzManager.addJobByTime(BatchJobGroup10001.class, jobName, "triggerGroupName", "jobGroupName", time);
	}
	
	@Test
	public void TestTask(){
		String TRIGGER_GROUP_NUMBER = "10001";
		String JOB_EXECUTE_FLAG = "Y";
		String hqlStr_Flage_Y = "from SystemBatchTaskDispathControl where TRIGGER_GROUP_NUMBER = '" + TRIGGER_GROUP_NUMBER + "' and JOB_EXECUTE_FLAG = '"+ JOB_EXECUTE_FLAG +"'" ;
		List<SystemBatchTaskDispathControl> systemBatchTaskDispathControlList = 
				systemBatchTaskDispathControlImpl.findAllByHql(hqlStr_Flage_Y);
		System.out.println(systemBatchTaskDispathControlList.size());
		for (SystemBatchTaskDispathControl systemBatchTaskDispathControl : systemBatchTaskDispathControlList) {
			String jobGroupClassName = "cn.spring.mvc.global.comm.batch.task.impl." + systemBatchTaskDispathControl.getJobClassName();
			String jobGroupMethodName = systemBatchTaskDispathControl.getJobMethodName();
			System.out.println("jobGroupClassName:"+jobGroupClassName);
			System.out.println("jobGroupMethodName:"+jobGroupMethodName);
			//同样通过发射找到类调用对应的方法
			@SuppressWarnings("rawtypes")
			Class[] classes = {};
			Object[] objects = {};
			try {
				BatchTools.executeMethodByClassNameAndMethodName(jobGroupClassName, jobGroupMethodName, classes, objects);
				// TODO:登记执行成功信息
			} catch (Exception e) {
				// TODO:异常信息
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void TestToGetAMap(){
		SysDict object = new SysDict();
		object.setDictType("U_DDSDF");
		Map<String, Object> map = BaseUtil.getParamMapWithOutNullValueByReflectObject(object);
		System.out.println(map);
	}
	
	@Test
	public void TestAnnotation(){
		SysDict object = new SysDict();
		
		BaseUtil.getAttributeAnnotationByReflectColumn(object);
		BaseUtil.getAttributeAnnotationsByReflect(object);
		BaseUtil.getClassAnnotationsByReflect(object);
		BaseUtil.getMethodAnnotationsByReflect(object);
	}
	
	
	
	@Test
	public void TestToGet(){
		try {
			SysDict object = new SysDict();
			BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());  
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
			for (PropertyDescriptor property : propertyDescriptors) {  
				String key = property.getName();  
				// 过滤class属性  
				if (!key.equals("class")) {  
					// 得到property对应的getter方法  
					Method getter = property.getReadMethod();  
					Object value = getter.invoke(object); 
					if(CommUtil.isNotNull(value)){
						System.out.println("key"+ key+",value"+value); 
					}
				}  
				
			}  
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void TestSysDict(){
		Class<SysDict> c = SysDict.class;
		Field[]  f = c.getDeclaredFields();
		for (Field field : f) {
			boolean b = field.isAnnotationPresent(Column.class);
			if(b){
				Column x = field.getAnnotation(Column.class);
				System.out.println(field.getDeclaringClass());
				System.out.println("columnDefinition:" + x.columnDefinition());
				System.out.println("insertable:"+x.insertable());
				System.out.println("length"+x.length());
				System.out.println("name"+x.name());
				System.out.println("nullable"+x.nullable());
				System.out.println("precision"+x.precision());
				System.out.println("scale"+x.scale());
				System.out.println("table"+x.table());
				System.out.println("toString"+x.toString());
				System.out.println("unique"+x.unique());
				System.out.println("updatable"+x.updatable());
				System.out.println("annotationType"+x.annotationType());
				System.out.println("getClass"+x.getClass());
			}
		}
		Method[] arr = c.getMethods();
		AnnotatedType[] m = c.getAnnotatedInterfaces();
		for(AnnotatedType y : m){
			System.out.println(y);
		}
		Annotation[] n = c.getAnnotations();
		for (Annotation annotation : n) {
			System.out.println(annotation);
		}
		TypeVariable<Class<SysDict>>[] o = c.getTypeParameters();
		for (TypeVariable<Class<SysDict>> typeVariable : o) {
			System.out.println(typeVariable.getTypeName());
		}
//		c.getAnnotationsByType(String.class);
		for(Method a : arr){
			if(a.isAnnotationPresent(Column.class)){
				Column x = a.getAnnotation(Column.class);
				System.out.println("columnDefinition:" + x.columnDefinition());
				System.out.println("insertable:"+x.insertable());
				System.out.println("length"+x.length());
				System.out.println("name"+x.name());
				System.out.println("nullable"+x.nullable());
				System.out.println("precision"+x.precision());
				System.out.println("scale"+x.scale());
				System.out.println("table"+x.table());
				System.out.println("toString"+x.toString());
				System.out.println("unique"+x.unique());
				System.out.println("updatable"+x.updatable());
				System.out.println("annotationType"+x.annotationType());
				System.out.println("getClass"+x.getClass());
			}
		}
	}
	
	@Test
	public void TestSysRole(){
//		String hql = "from SysAuthRole";
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("role_cd", "3221");
//		List<SysAuthRole> list = sysAuthRoleServiceImpl.find(hql);
//		for (SysAuthRole sysRole : list) {
//			System.out.println(sysRole.toString());
//		}
		
	}
	
	@Test
	public void addSysUser() {
		String num = UUID.randomUUID().toString();
		SysUser sysUser = new SysUser();
		sysUser.setRegistCd("001");
		sysUser.setUserid("10001");
		sysUser.setUserna("古天乐");
		sysUser.setPasswd(MD5Tool.md5EncryptString("123456"));
		sysUser.setUserst("0");
		sysUser.setErrort(0);
		try {
			sysUser = sysUserServiceImpl.add(sysUser);
			LOGGER.info("-----0-----SUCCESS");
		} catch (Throwable e) {
			LOGGER.info("-----1-----" + e.getMessage());
		}
		LOGGER.info(num + JSON.toJSONString(sysUser));
	}
	
	@Test
	public void delet() {
		SysUser sysUser = sysUserServiceImpl.selectOneByPrimeKey("001", "709422963");
		sysUserServiceImpl.delete(sysUser);
	}
	
	@Test
	public void selectOne(){
		SysUser sysUser = sysUserServiceImpl.selectOneByPrimeKey("002", "709422963");
		System.out.println(sysUser.getUserid() + ", " + sysUser.getUserna() + ", " + sysUser.getPasswd());
	}
	
	@Test
	public void findAll(){
		List<SysUser> sysUserList = sysUserServiceImpl.selectAll();
		for(SysUser sysUser : sysUserList){
			System.out.println(sysUser.getUserid() + ", " + sysUser.getUserna() + ", " + sysUser.getPasswd());
		}
	}
	
	@Test
	public void count(){
		System.out.println(sysUserServiceImpl.count());
	}
	
	@Test
	public void update(){
		SysUser sysUser = sysUserServiceImpl.selectOneByPrimeKey("001", "709422963");
		sysUser.setUserna("张家辉");
		sysUser.setPasswd(MD5Tool.md5EncryptString("654321"));
		sysUserServiceImpl.update(sysUser);
	}
	@Test
	public void unZip(){
		try {
			FileTool.unZipToFile("D:\\usr\\files\\ht\\report\\txtReport\\temp\\201804.zip", "D:\\usr\\files\\ht\\report\\txtReport\\temp\\unzip\\");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void readFiles() {
		String srcFileStr = "D:\\usr\\files\\ht\\report\\txtReport\\temp\\unzip\\";
		delWithDataFile(srcFileStr, "GBK");
	}
	/**
	 * @author LiuTao @date 2018年5月14日 上午10:54:18 
	 * @Title: delWithDataFile 
	 * @Description: TODO(Describe) 
	 * @param srcFileStr
	 */
	public void delWithDataFile(String srcFileStr, String charSet) {
		 File srcFile = new File(srcFileStr);
		 if(srcFile.exists()){
			 if(srcFile.isFile()){
				 BufferedReader bufferedReader = null;
				 InputStreamReader inputStreamReader = null;
				 try {
					 inputStreamReader = new InputStreamReader(new FileInputStream(srcFileStr), charSet);
					 bufferedReader = new BufferedReader(inputStreamReader);
					//以行为单位读取文件内容,一次读一整行
					String tempString = null;
					int line = 1;
					// 一次读入一行,直到读入null为文件结束
					while ((tempString = bufferedReader.readLine()) != null) {
						// 显示行号
						System.out.println("line " + line + ": " + tempString);
						line++;
					}
					bufferedReader.close();
				 } catch (IOException e) {
					e.printStackTrace();
				 } finally {
					if (bufferedReader != null) {
						try {
							bufferedReader.close();
						} catch (IOException e1) {
						}
					}
				}
			 }else if(srcFile.isDirectory()){
				 File[] fileArr = srcFile.listFiles();
				 for(int i = 0; i < fileArr.length; i ++){
					 File str = fileArr[i];
					 delWithDataFile(str.toString(), charSet);
				 }
			 }
		 }
	}
}
