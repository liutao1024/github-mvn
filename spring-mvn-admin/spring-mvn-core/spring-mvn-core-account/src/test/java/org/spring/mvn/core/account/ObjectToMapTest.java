package org.spring.mvn.core.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import org.junit.Test;

import cn.spring.mvn.base.util.BaseUtil;
import cn.spring.mvn.core.account.Myinput;
import cn.spring.mvn.core.account.Myoutput;
import cn.spring.mvn.core.account.entity.CustUser;

public class ObjectToMapTest {

//	@Test
	public void Test() {
		Myinput i = new Myinput();
		i.setCustna("123");
		i.setIdtptf("01");

		List<CustUser> data = new ArrayList<CustUser>();
		CustUser user = new CustUser();
		user.setAddrcd("address");
		user.setCustna("liutao");
		data.add(user);
		user.setCustna("zhansan");
		data.add(user);
		Myoutput o = new Myoutput();
		o.setCount(12);
		o.setData(data);

		try {
			Map<String, Object> map = BaseUtil.recursionObjectToMap("YYYY-MM-dd HH:mm:ss", o, "");
			System.out.println(map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
