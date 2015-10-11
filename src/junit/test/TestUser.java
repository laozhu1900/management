package junit.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.jar.dao.UserDao;
import com.jar.dao.impl.UserDaoImpl;
import com.jar.domain.User;
import com.jar.service.UserService;
import com.jar.service.impl.UserServiceImpl;

public class TestUser {

	@Test
	public void testadd(){
		
		User user = new User();
		
		user.setId("1104");
		user.setName("zzh");
		user.setPassword("222222");
		user.setCellphone("222222");
		user.setEmail("222222@qq.com");
		user.setAddress("¹þ¹þ");
		user.setPosition("Ô±¹¤");
		user.setLimitation("aa");
		
		UserDaoImpl userdao = new UserDaoImpl();
		userdao.add(user);
	}
	
	
	@Test
	public void testgetAll(){
		
			List<User> list = new ArrayList<User>();
			
			UserDao userdao = new UserDaoImpl();
			
			list = userdao.getAll();
			
			for(User user:list){
				System.out.println(user.getName() );
			}
	}
	
	@Test
	public void testgetalluser(){
		List<User> list = new ArrayList<User>();
		UserService service = new UserServiceImpl();
		list = service.getAllUser();
		
		for(User user:list){
			System.out.println(user.getName() );
		}
	}
	
	@Test
	public void testupdate(){
		
		UserService service = new UserServiceImpl();
		User u = new User();
		u.setAddress("1");
		u.setId("1111");
		u.setName("zzw");
		service.updateUser(u);
		
	}
	
	
	
}






