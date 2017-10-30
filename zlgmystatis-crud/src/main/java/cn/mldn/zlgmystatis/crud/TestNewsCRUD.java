package cn.mldn.zlgmystatis.crud;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

import cn.mldn.zlgmystatis.util.MyBatisSessionFactory;
import cn.mldn.zlgmystatis.vo.News;
import junit.framework.TestCase;

public class TestNewsCRUD {
	private static Random random=new Random();
	private static int rand;
	static {
		rand=random.nextInt(Integer.MAX_VALUE);
	}
	@Test
	public void testNewsAdd() {
		News vo=new News();
		vo.setTitle("新闻标题 - "+rand);
		vo.setPubdate(new Date());
		vo.setNote("新闻内容 - "+rand);
		int len=MyBatisSessionFactory.getSession().insert("cn.mldn.mapping.NewsNS.doCreate",vo);
		MyBatisSessionFactory.getSession().commit();//提交更新事物
		TestCase.assertEquals(len, 1);
		System.err.println(vo);
		MyBatisSessionFactory.close();
	}

}
