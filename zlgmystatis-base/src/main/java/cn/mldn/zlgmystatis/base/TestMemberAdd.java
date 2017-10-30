package cn.mldn.zlgmystatis.base;

import java.io.InputStream;
import java.util.Date;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.mldn.zlgmystatis.vo.Member;

public class TestMemberAdd {
	private static Random random=new Random();
	private static int rand;
	static {
		rand=random.nextInt(Integer.MAX_VALUE);
	}
	@Test
	public void testAddMember() throws Exception {
		InputStream inputStream=Resources.getResourceAsStream("mybatis/mybatis.cfg.xml");
		//获取一个SqlSessionFactory接口对象，便是所有的 数据库连接处理
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		//通过SqlSessionFactory获取SqlSession接口，该接口主要用于进行数据库的操作
		SqlSession session=sessionFactory.openSession();//获取链接
		Member vo=new Member();
		vo.setMid("mldn - " +rand);
		vo.setName("你好 - "+rand);
		vo.setBirthday(new Date());
		vo.setSalary(1111111.4);
		vo.setNote("哈哈哈");
		//找到命名空间之中定义的具体的SQL语句，而后执行追加
		System.out.println(session.insert("cn.mldn.mapping.MemberNS.doCreate",vo));
		session.commit();//提交更新事物
		session.close();
		inputStream.close();
	}

}
