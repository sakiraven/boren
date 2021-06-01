package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CookBookDao;
import dao.PostDao;
import dao.UserInfoDao;

import entity.CookBook;
import entity.Post;
import entity.UserInfo;

public class Test01 {
	
	public static void main(String[] args) {
		ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*PostDao postDao = (PostDao) ct.getBean("postDao");
		List<Post> postList = postDao.postLoveQuery();
		for (Post post : postList) {
			System.out.println(post.getPostUserId());
		}*/
		/*CookBookDao cookBookDao= (CookBookDao) ct.getBean("cookBookDao");
		List<CookBook> cookBookList = cookBookDao.queryCookBook();
		System.out.println(cookBookList.size());*/
		UserInfo userInfo = new UserInfo();
		userInfo.setAcctId(12);
		UserInfoDao userInfoDao= (UserInfoDao) ct.getBean("userInfoDao");
		List<UserInfo> getlt = userInfoDao.queryOneInfo(userInfo);
		System.out.println(getlt.size());
	}
}
 