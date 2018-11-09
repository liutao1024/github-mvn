package cn.spring.mvn.basic.ibatis;

import java.util.List;

//import org.apache.ibatis.session.RowBounds;

import tk.mybatis.mapper.common.Mapper;

//import org.apache.ibatis.annotations.Select;

/**
 * @author LiuTao @date 2018年11月9日 下午4:40:34
 * @ClassName: MyBatisMapperDao 
 * @Description:	<p>1.表名默认使用类名,驼峰转下划线(只对大写字母进行处理),如UserInfo默认对应的表名为user_info.<p>
 * 					<p>2.对不符合第一条默认规则的可以通过@Table(name = "tableName")的方式进行指定表名<p>
 * 					<p>3.字段默认和@Column一样,都会作为表字段,表字段默认为Java对象的Field名字驼峰转下划线形式<p>
 * 					<p>4.可以使用@Column(name = "fieldName")指定不符合第3条规则的字段名<p>
 * 					<p>5.使用@Transient注解可以忽略字段,添加该注解的字段不会作为表字段使用<p>
 * 					<p>6.建议一定是有一个@Id注解作为主键的字段,可以有多个@Id注解的字段作为联合主键<p>
 * 					<p>7.如果是MySQL的自增字段,加上@GeneratedValue(generator = "JDBC")即可.如果是其他数据库,可以参考官网文档<p>
 * @Note: Mapper3接口有两种形式,一种是提供了一个方法的接口.还有一种是不提供方法,但是继承了多个单方法的接口,一般是某类方法的集合.
 * 			例如SelectMapper<T>是一个单方法的接口,BaseSelectMapper<T>是一个继承了4个基础查询方法的接口.
 * 		基础接口
 * Select
 * 接口:SelectMapper<T>
 * 方法:List<T> select(T record);
 * 说明:根据实体中的属性值进行查询,查询条件使用等号
 * 
 * 接口:SelectByPrimaryKeyMapper<T>
 * 方法:T selectByPrimaryKey(Object key);
 * 说明:根据主键字段进行查询,方法参数必须包含完整的主键属性,查询条件使用等号
 * 
 * 接口:SelectAllMapper<T>
 * 方法:List<T> selectAll();
 * 说明:查询全部结果,select(null)方法能达到同样的效果
 * 
 * 接口:SelectOneMapper<T>
 * 方法:T selectOne(T record);
 * 说明:根据实体中的属性进行查询,只能有一个返回值,有多个结果是抛出异常,查询条件使用等号
 * 
 * 接口:SelectCountMapper<T>
 * 方法:int selectCount(T record);
 * 说明:根据实体中的属性查询总数,查询条件使用等号
 * 
 * Insert
 * 接口:InsertMapper<T>
 * 方法:int insert(T record);
 * 说明:保存一个实体,null的属性也会保存,不会使用数据库默认值
 * 
 * 接口:InsertSelectiveMapper<T>
 * 方法:int insertSelective(T record);
 * 说明:保存一个实体,null的属性不会保存,会使用数据库默认值
 * 
 * Update
 * 接口:UpdateByPrimaryKeyMapper<T>
 * 方法:int updateByPrimaryKey(T record);
 * 说明:根据主键更新实体全部字段,null值会被更新
 * 
 * 接口:UpdateByPrimaryKeySelectiveMapper<T>
 * 方法:int updateByPrimaryKeySelective(T record);
 * 说明:根据主键更新属性不为null的值
 * 
 * Delete
 * 接口:DeleteMapper<T>
 * 方法:int delete(T record);
 * 说明:根据实体属性作为条件进行删除,查询条件使用等号
 * 
 * 接口:DeleteByPrimaryKeyMapper<T>
 * 方法:int deleteByPrimaryKey(Object key);
 * 说明:根据主键字段进行删除,方法参数必须包含完整的主键属性
 * 
 * base 组合接口
 * 接口:BaseSelectMapper<T>
 * 方法:包含上面Select的4个方法
 * 
 * 接口:BaseInsertMapper<T>
 * 方法:包含上面Insert的2个方法
 * 
 * 接口:BaseUpdateMapper<T>
 * 方法:包含上面Update的2个方法
 * 
 * 接口:BaseDeleteMapper<T>
 * 方法:包含上面Delete的2个方法
 * 
 * CRUD 组合接口
 * 接口:BaseMapper<T>
 * 方法:继承了base组合接口中的4个组合接口,包含完整的CRUD方法
 * 
 * Example 方法
 * 接口:SelectByExampleMapper<T>
 * 方法:List<T> selectByExample(Object example);
 * 说明:根据Example条件进行查询
 * 重点:这个查询支持通过Example类指定查询列,通过selectProperties方法指定查询列
 * 
 * 接口:SelectCountByExampleMapper<T>
 * 方法:int selectCountByExample(Object example);
 * 说明:根据Example条件进行查询总数
 * 
 * 接口:UpdateByExampleMapper<T>
 * 方法:int updateByExample(@Param("record") T record, @Param("example") Object example);
 * 说明:根据Example条件更新实体record包含的全部属性,null值会被更新
 * 
 * 接口:UpdateByExampleSelectiveMapper<T>
 * 方法:int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);
 * 说明:根据Example条件更新实体record包含的不是null的属性值
 * 
 * 接口:DeleteByExampleMapper<T>
 * 方法:int deleteByExample(Object example);
 * 说明:根据Example条件删除数据
 * 
 * Example 组合接口
 * 接口:ExampleMapper<T>
 * 方法:包含上面Example中的5个方法
 * 
 * Condition 方法
 * Condition方法和Example方法作用完全一样,只是为了避免Example带来的歧义,提供的的Condition方法
 * 
 * 接口:SelectByConditionMapper<T>
 * 方法:List<T> selectByCondition(Object condition);
 * 说明:根据Condition条件进行查询
 * 
 * 接口:SelectCountByConditionMapper<T>
 * 方法:int selectCountByCondition(Object condition);
 * 说明:根据Condition条件进行查询总数
 * 
 * 接口:UpdateByConditionMapper<T>
 * 方法:int updateByCondition(@Param("record") T record, @Param("example") Object condition);
 * 说明:根据Condition条件更新实体record包含的全部属性,null值会被更新
 * 
 * 接口:UpdateByConditionSelectiveMapper<T>
 * 方法:int updateByConditionSelective(@Param("record") T record, @Param("example") Object condition);
 * 说明:根据Condition条件更新实体record包含的不是null的属性值
 * 
 * 接口:DeleteByConditionMapper<T>
 * 方法:int deleteByCondition(Object condition);
 * 说明:根据Condition条件删除数据
 * 
 * Condition 组合接口
 * 接口:ConditionMapper<T>
 * 方法:包含上面Condition中的5个方法
 * 
 * RowBounds
 * 默认为内存分页,可以配合PageHelper实现物理分页
 * 
 * 接口:SelectRowBoundsMapper<T>
 * 方法:List<T> selectByRowBounds(T record, RowBounds rowBounds);
 * 说明:根据实体属性和RowBounds进行分页查询
 * 
 * 接口:SelectByExampleRowBoundsMapper<T>
 * 方法:List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);
 * 说明:根据example条件和RowBounds进行分页查询
 * 
 * 接口:SelectByConditionRowBoundsMapper<T>
 * 方法:List<T> selectByConditionAndRowBounds(Object condition, RowBounds rowBounds);
 * 说明:根据example条件和RowBounds进行分页查询,该方法和selectByExampleAndRowBounds完全一样,只是名字改成了Condition
 * 
 * RowBounds 组合接口
 * 接口:RowBoundsMapper<T>
 * 方法:包含上面RowBounds中的前两个方法,不包含selectByConditionAndRowBounds
 * 
 * special 特殊接口
 * 这些接口针对部分数据库设计,不是所有数据库都支持
 * 
 * 接口:InsertListMapper<T>
 * 方法:int insertList(List<T> recordList);
 * 说明:批量插入,支持批量插入的数据库可以使用,例如MySQL,H2等,另外该接口限制实体包含id属性并且必须为自增列
 * 
 * 接口:InsertUseGeneratedKeysMapper<T>
 * 方法:int insertUseGeneratedKeys(T record);
 * 说明:插入数据,限制为实体包含id属性并且必须为自增列,实体配置的主键策略无效
 * 
 * MySQL 专用
 * 接口:MySqlMapper<T>
 * 继承方法:int insertList(List<T> recordList);
 * 继承方法:int insertUseGeneratedKeys(T record);
 * 说明:该接口不包含方法,继承了special中的InsertListMapper<T>和InsertUseGeneratedKeysMapper<T>
 * 
 * SqlServer 专用
 * 由于sqlserver中插入自增主键时,不能使用null插入,不能在insert语句中出现id.
 * 
 * 注意SqlServer的两个特有插入方法都使用了注解@Options(useGeneratedKeys = true, keyProperty = "id")
 * 这就要求表的主键为id,且为自增,如果主键不叫id可以看高级教程中的解决方法.另外这俩方法和base中的插入方法重名,
 * 不能同时存在！如果某种数据库和SqlServer这里类似,也可以使用这些接口(需要先测试)
 * 
 * 接口:InsertMapper
 * 方法:int insert(T record);
 * 说明:插入数据库,null值也会插入,不会使用列的默认值
 * 
 * 接口:InsertSelectiveMapper
 * 方法:int insertSelective(T record);
 * 说明:插入数据库,null的属性不会保存,会使用数据库默认值
 * 
 * 接口:SqlServerMapper
 * 说明:这是上面两个接口的组合接口.
 * 
 * Ids 接口
 * 通过操作ids字符串进行操作,ids 如"1,2,3"这种形式的字符串,这个方法要求实体类中有且只有一个带有@Id注解的字段,否则会抛出异常.
 * 
 * 接口:SelectByIdsMapper
 * 方法:List<T> selectByIds(String ids)
 * 说明:根据主键字符串进行查询,类中只有存在一个带有@Id注解的字段
 * 
 * 接口:DeleteByIdsMapper
 * 方法:int deleteByIds(String ids)
 * 说明:根据主键字符串进行删除,类中只有存在一个带有@Id注解的字段
 * 
 * Ids 组合接口
 * 接口:IdsMapper<T>
 * 方法:包含上面Ids中的前两个方法
 * 
 * Mapper<T> 接口
 * 接口:Mapper<T>
 * 该接口兼容Mapper2.x版本,继承了BaseMapper<T>, ExampleMapper<T>, RowBoundsMapper<T>三个组合接口.
 * 
 * @Attention:
 * @Tipc: 	<p>1.Example的方法参数不能是实体类必须是Example类.<p>
 * 			<p>2.PrimaryKey的方法是根据实体类entity的属性上的注解@Id进行匹配的<p>
 * @Notice: 从Mapper继承下来的接口不需要在本接口中重写否则在运用这个接口时会抛异常,
 * 			而且在IBatisMapper.xml中也不能再定义这些同名的sqlStamens
 * @param <T>
 */
public interface IBatisDao<T> extends Mapper<T>{
	/**
	 * 保存一个实体,null的属性也会保存,不会使用数据库默认值
	 */
//	@Override
//	int insert(T arg0);
	
	/**
	 * 保存一个实体,null的属性不会保存,会使用数据库默认值
	 */
//	@Override
//	int insertSelective(T arg0);
	
	/**
	 * 根据主键字段判断是否存在
	 */
//	@Override
//	boolean existsWithPrimaryKey(Object arg0);
	
	/**
	 * 查询全部结果,select(null)方法能达到同样的效果
	 */
//	@Override
//	List<T> selectAll();
	
	/**
	 * 根据实体中的属性值进行查询,查询条件使用等号
	 */
//	@Override
//	List<T> select(T arg0);
	
	/**
	 * 根据实体中的属性进行查询,只能有一个返回值,有多个结果是抛出异常,查询条件使用等号
	 */
//	@Override
//	T selectOne(T arg0);
	
	/**
	 * 根据Example条件进行查询,只能有一个返回值,有多个结果是抛出异常
	 * 		(Expected one result (or null) to be returned by selectOne(), but found: 17)
	 */
//	@Override
//	T selectOneByExample(Object arg0);
	
	/**
	 * 根据Example条件进行查询,这个查询支持通过Example类指定查询列,通过selectProperties方法指定查询列
	 */
//	@Override
//	List<T> selectByExample(Object arg0);
	
	/**
	 * 根据主键字段进行查询,方法参数必须包含完整的主键属性,查询条件使用等号
	 */
//	@Override
//	T selectByPrimaryKey(Object arg0);
	
	/**
	 * 根据实体属性和RowBounds进行分页查询
	 * (实质上是内存分页[sql执行后返回的所有复合条件的记录但是在这些记录中按RowBounds的offset和limit进行分页返回])
	 */
//	@Override
//	List<T> selectByRowBounds(T arg0, RowBounds rowBounds);
	
	/**
	 * 根据example条件和RowBounds进行分页查询
	 * new RowBounds(int ofset, int limit),offset 表示第几条开始,limit表示显示几条
	 */
//	@Override
//	List<T> selectByExampleAndRowBounds(Object arg0, RowBounds rowBounds);
	
	/**
	 * 根据实体中的属性查询总数,查询条件使用等号
	 */
//	@Override
//	int selectCount(T arg0);
	
	/**
	 * 根据Example条件进行查询总数
	 */
//	@Override
//	int selectCountByExample(Object arg0);
	
	/**
	 * 根据Example条件更新实体record包含的全部属性,null值会被更新
	 */
//	@Override
//	int updateByExample(T arg0, Object arg1);
	
	/**
	 * 根据Example条件更新实体record包含的不是null的属性值
	 */
//	@Override
//	int updateByExampleSelective(T arg0, Object arg1);
	
	/**
	 * 根据主键更新实体全部字段,student的null值会被更新
	 */
//	@Override
//	int updateByPrimaryKey(Object arg0);
	
	/**
	 * 根据主键更新属性不为null的值
	 */
//	@Override
//	int updateByPrimaryKeySelective(Object arg0);
	
	/**
	 * 根据实体属性作为条件进行删除,查询条件使用等号
	 */
//	@Override
//	int delete(T arg0);
	
	/**
	 * 根据Example条件删除数据
	 */
//	@Override
//	int deleteByExample(Object arg0);
	
	/**
	 * 根据主键字段进行删除,方法参数必须包含完整的主键属性
	 */
//	@Override
//	int deleteByPrimaryKey(Object arg0);

	/**
	 * @author LiuTao @date 2018年11月8日 下午1:05:45 
	 * @Title: insertEntity 
	 * @Description: 插入一条记录
	 * @param t
	 * @return
	 */
	int insertEntity(T t);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:05:50 
	 * @Title: insertEntities 
	 * @Description: 批量插入记录
	 * @param list
	 * @return
	 */
	int insertEntities(List<T> list);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:05:54 
	 * @Title: updateEntity 
	 * @Description: 更新一条记录 
	 * @param t
	 * @return
	 */
	int updateEntity(T t);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:06:24 
	 * @Title: updateEntities 
	 * @Description: 批量更新记录 
	 * @param list
	 * @return
	 */
	int updateEntities(List<T> list);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:06:28 
	 * @Title: selectEntity 
	 * @Description: 查询一条记录
	 * @param t
	 * @return
	 */
	T selectEntity(T t);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:06:33 
	 * @Title: selectEntities 
	 * @Description: 查询list记录
	 * @param t
	 * @return
	 */
//	@Select("select * from core_main")
	List<T> selectEntities(T t);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:06:37 
	 * @Title: selectEntitiesCount 
	 * @Description: 查询记录数
	 * @param t
	 * @return
	 */
	int selectEntitiesCount(T t);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:06:41 
	 * @Title: selectEntitiesWithCount 
	 * @Description: 查询记录并返回记录数 
	 * @param BPEntity
	 * @return
	 */
	IBatisPageResult<T> selectEntitiesWithCount(IBatisPageEntity<T> BPEntity);
	/**
	 * @author LiuTao @date 2018年11月8日 下午1:10:19 
	 * @Title: selectPageEntitiesWithCount 
	 * @Description: 分页查询记录并返回记录数 
	 * @param BPEntity
	 * @return
	 */
	IBatisPageResult<T> selectPageEntitiesWithCount(IBatisPageEntity<T> BPEntity);
	
}
