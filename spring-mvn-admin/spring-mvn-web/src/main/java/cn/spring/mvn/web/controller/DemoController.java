package cn.spring.mvn.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tk.mybatis.mapper.entity.Example;
import cn.spring.mvn.basic.entity.SystemTransactionInformation;
import cn.spring.mvn.basic.entity.service.SystemTransactionInformationService;
import cn.spring.mvn.basic.ibatis.IBatisTParam;
import cn.spring.mvn.basic.ibatis.IBatisTResult;
import cn.spring.mvn.core.amain.entity.CoreMain;
import cn.spring.mvn.core.amain.entity.service.AccountService;
import cn.spring.mvn.core.amain.entity.service.CoreMainService;
import cn.spring.mvn.core.amain.entity.service.ProductService;
import cn.spring.mvn.core.deposit.entity.service.CoreDepositEntityService;
import cn.spring.mvn.core.fund.entity.service.CoreFundEntityService;
import cn.spring.mvn.core.loan.entity.Student;
import cn.spring.mvn.core.loan.entity.dao.StudentDao;
import cn.spring.mvn.core.loan.entity.service.CoreLoanEntityService;
import cn.spring.mvn.core.loan.entity.service.StudentService;
import cn.spring.mvn.socket.server.SocketOperatorImpl;
/**
 * @author LiuTao @date 2018年11月9日 下午8:03:53
 * @ClassName: DemoController 
 * @Description: MyBatis 的疯狂探索
 */
@Controller("DemoController")
@RequestMapping(value="/test")
public class DemoController {
	@Autowired
	private SystemTransactionInformationService s;
	@Autowired
	private AccountService a;
	@Autowired
	private ProductService p;
	@Autowired
	private CoreDepositEntityService d;
	@Autowired
	private CoreFundEntityService f;
	@Autowired
	private CoreLoanEntityService l;
	@Autowired
	private CoreMainService m;
	@Autowired
	private StudentService st;
	@Autowired
	private StudentDao sd;
	
	/**
	 * @author LiuTao @date 2018年11月13日 下午4:36:14 
	 * @Title: Test006 
	 * @Description: 测试IBatisTParam的运用
	 * @param request
	 * @param response
	 */
	@RequestMapping("/test006")
	public void Test006(HttpServletRequest request, HttpServletResponse response) {
		Student t = new Student();
//		t.setAge(28);
		IBatisTParam<Student> iBatisParam = new IBatisTParam<Student>(t, 0, 5, null, null);
		IBatisTResult<Student> ibts = st.selectPageEntitiesWithCountByCondition(iBatisParam);//st.selectEntitiesWithCount(t);
		Long count = ibts.getCount();
		List<Student> ls = ibts.getResultList();
		System.out.println(count);
		for (Student student : ls) {
			System.out.println(student);
		}
	}
	/**
	 * @author LiuTao @date 2018年11月12日 下午8:44:36 
	 * @Title: Test005 
	 * @Description: 测试自己设计的 BINGO
	 * @param request
	 * @param response
	 */
	@RequestMapping("/test005")
	public void Test005(HttpServletRequest request, HttpServletResponse response) {
		Student student = new Student();
		student.setAge(28);
		List<Student> list = st.selectEntities(student);
		for (Student entity : list) {
			System.out.println(entity);
		}
		student.setBirth(new Date());
		student.setId(119L);
		student.setName("杨过");
		student.setNo("9925");
		student.setPhone("18982598359");
		student.setSex('M');
		st.insertEntity(student);
	}
	
	/**
	 * @author LiuTao @date 2018年11月9日 下午7:52:19 
	 * @Title: Test004 
	 * @Description: 对TKMapper接口中Example的探索 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/test004")
	public void Test004(HttpServletRequest request, HttpServletResponse response){
		/**
		 * 1.Example的方法参数不能是实体类必须是Example类.
		 * 2.PrimaryKey的方法是根据实体类entity的属性上的注解@Id进行匹配的
		 */
		Student student = new Student();
		Example example = new Example(Student.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andAllEqualTo("");
		RowBounds rowBounds = new RowBounds(4, 2);//new RowBounds(int ofset, int limit),offset 表示第几条开始,limit表示显示几条
		sd.deleteByExample(example);
		sd.selectByRowBounds(student, rowBounds);
		
	}
	/**
	 * @author LiuTao @date 2018年11月9日 下午7:51:15 
	 * @Title: Test003 
	 * @Description: 对TKMapper接口的探索
	 * @param request
	 * @param response
	 */
	@RequestMapping("/test003")
	public void Test003(HttpServletRequest request, HttpServletResponse response){
		Student student = new Student();
//		student.setId(911L);
//		student.setNo("9528");
//		student.setName("删除我");
		student.setAge(28);
//		student.setSex('F');
//		student.setPhone("15928435556");
		/**
		 * 1.Example的方法参数不能是实体类必须是Example类.
		 * 2.PrimaryKey的方法是根据实体类entity的属性上的注解@Id进行匹配的
		 */
//		Example example = new Example(Student.class);
//		Example.Criteria criteria = example.createCriteria();
//		RowBounds rowBounds = new RowBounds(4, 2);//new RowBounds(int ofset, int limit),offset 表示第几条开始,limit表示显示几条
		
//		int r1 = sd.insert(student);//保存一个实体,null的属性也会保存,不会使用数据库默认值
//		int r2 = sd.insertSelective(student);//保存一个实体,null的属性不会保存,会使用数据库默认值
//		boolean r3 = sd.existsWithPrimaryKey(student);//根据主键字段判断是否存在
//		List<Student> r4 = sd.selectAll();//查询全部结果,select(null)方法能达到同样的效果
//		List<Student> r5 = sd.select(student);//根据实体中的属性值进行查询,查询条件使用等号
//		Student r6 = sd.selectOne(student);//根据实体中的属性进行查询,只能有一个返回值,有多个结果是抛出异常,查询条件使用等号
//		Student r7 = sd.selectOneByExample(example);//根据Example条件进行查询,只能有一个返回值,有多个结果是抛出异常(Expected one result (or null) to be returned by selectOne(), but found: 17)
		
//		List<Student> r8 = sd.selectByExample(example);//根据Example条件进行查询,这个查询支持通过Example类指定查询列,通过selectProperties方法指定查询列
//		Student r9 = sd.selectByPrimaryKey(student);//根据主键字段进行查询,方法参数必须包含完整的主键属性,查询条件使用等号
//		List<Student> r10 = sd.selectByRowBounds(student, rowBounds);//根据实体属性和RowBounds进行分页查询(实质上是内存分页[sql执行后返回的所有复合条件的记录但是在这些记录中按RowBounds的offset和limit进行分页返回])
//		List<Student> r11 = sd.selectByExampleAndRowBounds(example, rowBounds);//根据example条件和RowBounds进行分页查询
//		int r12 = sd.selectCount(student);//根据实体中的属性查询总数,查询条件使用等号
//		int r13 = sd.selectCountByExample(example);//根据Example条件进行查询总数
//		int r14 = sd.updateByExample(student, example);//根据Example条件更新实体record包含的全部属性,null值会被更新
//		int r15 = sd.updateByExampleSelective(student, example);//根据Example条件更新实体record包含的不是null的属性值
//		int r16 = sd.updateByPrimaryKey(student);//根据主键更新实体全部字段,student的null值会被更新
//		int r17 = sd.updateByPrimaryKeySelective(student);//根据主键更新属性不为null的值
//		
//		int r18 = sd.delete(student);//根据实体属性作为条件进行删除,查询条件使用等号,
//		int r19 = sd.deleteByExample(example);//根据Example条件删除数据
//		int r20 = sd.deleteByPrimaryKey(student);//根据主键字段进行删除,方法参数必须包含完整的主键属性
//		
		
		List<Student> list = st.selectStudents();
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
	
	
	@RequestMapping("/test002")
	public void Test002(HttpServletRequest request, HttpServletResponse response){
		CoreMain entity = new CoreMain();
		entity.setId("1002");
		entity.setName("渣渣灰");
		m.insertEntity(entity);
		List<CoreMain> list = m.selectEntityList("1002");
		for (CoreMain coreMain : list) {
			System.out.println(coreMain);
		}
		List<CoreMain> thlist = m.selectAll(entity); 
		for (CoreMain coreMain : thlist) {
			System.out.println(coreMain);
		}
	}
	/**
	 * @author LiuTao @date 2018年11月9日 下午8:32:43 
	 * @Title: Test001 
	 * @Description: Hibernat的测试 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/test001")
	public void Test001(HttpServletRequest request, HttpServletResponse response){
		SystemTransactionInformation sti = new SystemTransactionInformation();
		List<SystemTransactionInformation> list = s.findAll(sti);
		for (SystemTransactionInformation systemTransactionInformation : list) {
			System.out.println(systemTransactionInformation.getSerialNumber());
		}
	}
	/**
	 * @author LiuTao @date 2018年11月9日 下午8:33:28 
	 * @Title: Test000 
	 * @Description: SocketOperatorImpl的测试 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/test000")
	public void Test000(HttpServletRequest request, HttpServletResponse response){
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
			String s = SocketOperatorImpl.call(str, "127.0.0.1");
//			response.s
			System.out.println("==================="+s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
