package junit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jar.dao.impl.CustomerDaoImpl;
import com.jar.domain.Customer;
import com.jar.service.CustomerService;
import com.jar.service.impl.CustomerServiceImpl;

public class TestCustomer {

	@Test
	public void testfind(){
		
		CustomerService service = new CustomerServiceImpl();
		Customer c = service.findCustomer("ÍÛ¹þ¹þ");
		System.out.println(c.getCellphone());
	} 
	
	
	@Test
	public void testadd(){
		CustomerDaoImpl dao = new CustomerDaoImpl();
		
		Customer c = new Customer();
		
		c.setId("1002");
		c.setName("zhuhzu");
		c.setLevel("vip");
		c.setType("persion");
		c.setCellphone("11111");
		
		dao.add(c);
		
	}
	
	@Test
	public void testdelete(){
		CustomerService service = new CustomerServiceImpl();
		service.delete("ÍÛ¹þ¹þ");
	}
	
	@Test
	public void testfindbytype(){
		CustomerService service = new CustomerServiceImpl();
		List<Customer> list = new ArrayList<Customer>();
		list = service.getAllCustomerByLevel("vip");
		
		for(Customer c:list){
			System.out.println(c.getName() );
		}
	}
	
	
	
}
