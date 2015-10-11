package com.jar.web.formbean;

import java.util.HashMap;
import java.util.Map;


import com.jar.dao.impl.UserDaoImpl;

public class RegisterForm {

	private String name;
	private String password;
	private String password2;
	private String cellphone;
	private String email;
	private String address;
	private String position;
	private String limitation;
	private String client_checkcode;
	private String server_checkcode;
	
	private Map errors = new HashMap();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLimitation() {
		return limitation;
	}

	public void setLimitation(String limitation) {
		this.limitation = limitation;
	}

	public String getClient_checkcode() {
		return client_checkcode;
	}

	public void setClient_checkcode(String client_checkcode) {
		this.client_checkcode = client_checkcode;
	}

	public String getServer_checkcode() {
		return server_checkcode;
	}

	public void setServer_checkcode(String server_checkcode) {
		this.server_checkcode = server_checkcode;
	}

	public Map getErrors() {
		return errors;
	}

	public void setErrors(Map errors) {
		this.errors = errors;
	}
	
	
	
	//表单的验证
	//用户名不能为空，并且要是3-8位字母
		//密码不能为空，并且是3-8位数字
		//确认密码不能为空，并且要和一次一致
		//电子邮箱不能为空，并且要是一个格式合法的邮箱
		//昵称不可以为空，并且要是汉字
		public boolean validate(){
			boolean isOK = true;
			
			if(this.name==null || this.name.trim().equals("")){
				isOK = false;
				errors.put("name", "用户名不能为空");
			}else{
				if(!this.name.matches("[A-Za-z]{3,8}")){
					isOK = false;
					errors.put("name", "用户名必须要是3-8位字母");
				}
				
				if(new UserDaoImpl().find(name)){
					errors.put("name","用户名存在");
				}
			}
			
			
			if(this.password==null || this.password.trim().equals("")){
				isOK = false;
				errors.put("password", "密码不能为空");
			}else{
				if(!this.password.matches("\\d{3,8}")){
					isOK = false;
					errors.put("password", "密码必须要是3-8位数字");
				}
			}
			
			if(this.password2==null || this.password2.trim().equals("")){
				isOK = false;
				errors.put("password2", "确认密码不能为空");
			}else{
				if(!this.password.equals(this.password2)){
					isOK = false;
					errors.put("password2", "两次密码要一致");
				}
			}
			
			
			//手机号验证
			if(this.cellphone==null || this.cellphone.trim().equals("")){
				isOK = false;
				errors.put("cellphone", "手机号不能为空");
			}else{
				if(!this.cellphone.matches("\\d{3,8}")){
					isOK = false;
					errors.put("cellphone", "手机必须要是3-8位数字");
				}
			}
			
		
			
			
			//电子邮箱不能为空，并且要是一个格式合法的邮箱
			if(this.email==null || this.email.trim().equals("")){
				isOK = false;
				errors.put("email", "邮箱不能为空");
			}else{
				// aaa@sina.com  aaa@sina.com.cn   aa_bb.cc@sina.com.cn
				//  \\w+@\\w+(\\.\\w+)+
				if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
					isOK = false;
					errors.put("email", "邮箱格式不对");
				}
			}
			
			
			//地址不可以为空，并且要是汉字
			if(this.address==null || this.address.trim().equals("")){
				isOK = false;
				errors.put("address", "地址不能为空");
			}else{  //[^\u4e00-\u9fa5]*
				if(!this.address.matches("^([\u4e00-\u9fa5]+)$")){
					isOK = false;
					errors.put("address", "地址必须是汉字");
				}
			}
			
			
			//职位不可以为空，并且要是汉字
			if(this.position==null || this.position.trim().equals("")){
				isOK = false;
				errors.put("position", "职位不能为空");
			}else{  //[^\u4e00-\u9fa5]*
				if(!this.position.matches("^([\u4e00-\u9fa5]+)$")){
					isOK = false;
					errors.put("position", "职位必须是汉字");
				}
			}
			
			//验证码
			if(client_checkcode==null || this.client_checkcode.trim().equals("")){
				isOK = false;
				errors.put("client_checkcode", "验证码不能为空");
			}else{
				if(!this.client_checkcode.equals(this.server_checkcode.trim())){
					isOK = false;
					System.out.println(client_checkcode);
					System.out.println(server_checkcode);
					errors.put("client_checkcode", "验证码错误");
				}
			}
			return isOK;
		}
	
}
