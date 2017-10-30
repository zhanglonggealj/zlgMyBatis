package cn.mldn.zlgmystatis.base;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

import cn.mldn.zlgmystatis.util.MyBatisSessionFactory;
import cn.mldn.zlgmystatis.vo.Member;

public class TestMemberAdd2 {
	private static Random random=new Random();
	private static int rand;
	static {
		rand=random.nextInt(Integer.MAX_VALUE);
	}
	@Test
	public void testAddMember() throws Exception {
		Member vo=new Member();
		vo.setMid("mldn - " +rand);
		vo.setName("你好 - "+rand);
		vo.setBirthday(new Date());
		vo.setSalary(1111111.4);
		vo.setNote("哈哈哈");
		System.out.println(MyBatisSessionFactory.getSession().insert("cn.mldn.mapping.MemberNS.doCreate",vo));
		MyBatisSessionFactory.getSession().commit();//提交更新事物
		MyBatisSessionFactory.close();
	}

}
