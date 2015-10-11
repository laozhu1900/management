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
	
	
	
	//������֤
	//�û�������Ϊ�գ�����Ҫ��3-8λ��ĸ
		//���벻��Ϊ�գ�������3-8λ����
		//ȷ�����벻��Ϊ�գ�����Ҫ��һ��һ��
		//�������䲻��Ϊ�գ�����Ҫ��һ����ʽ�Ϸ�������
		//�ǳƲ�����Ϊ�գ�����Ҫ�Ǻ���
		public boolean validate(){
			boolean isOK = true;
			
			if(this.name==null || this.name.trim().equals("")){
				isOK = false;
				errors.put("name", "�û�������Ϊ��");
			}else{
				if(!this.name.matches("[A-Za-z]{3,8}")){
					isOK = false;
					errors.put("name", "�û�������Ҫ��3-8λ��ĸ");
				}
				
				if(new UserDaoImpl().find(name)){
					errors.put("name","�û�������");
				}
			}
			
			
			if(this.password==null || this.password.trim().equals("")){
				isOK = false;
				errors.put("password", "���벻��Ϊ��");
			}else{
				if(!this.password.matches("\\d{3,8}")){
					isOK = false;
					errors.put("password", "�������Ҫ��3-8λ����");
				}
			}
			
			if(this.password2==null || this.password2.trim().equals("")){
				isOK = false;
				errors.put("password2", "ȷ�����벻��Ϊ��");
			}else{
				if(!this.password.equals(this.password2)){
					isOK = false;
					errors.put("password2", "��������Ҫһ��");
				}
			}
			
			
			//�ֻ�����֤
			if(this.cellphone==null || this.cellphone.trim().equals("")){
				isOK = false;
				errors.put("cellphone", "�ֻ��Ų���Ϊ��");
			}else{
				if(!this.cellphone.matches("\\d{3,8}")){
					isOK = false;
					errors.put("cellphone", "�ֻ�����Ҫ��3-8λ����");
				}
			}
			
		
			
			
			//�������䲻��Ϊ�գ�����Ҫ��һ����ʽ�Ϸ�������
			if(this.email==null || this.email.trim().equals("")){
				isOK = false;
				errors.put("email", "���䲻��Ϊ��");
			}else{
				// aaa@sina.com  aaa@sina.com.cn   aa_bb.cc@sina.com.cn
				//  \\w+@\\w+(\\.\\w+)+
				if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
					isOK = false;
					errors.put("email", "�����ʽ����");
				}
			}
			
			
			//��ַ������Ϊ�գ�����Ҫ�Ǻ���
			if(this.address==null || this.address.trim().equals("")){
				isOK = false;
				errors.put("address", "��ַ����Ϊ��");
			}else{  //[^\u4e00-\u9fa5]*
				if(!this.address.matches("^([\u4e00-\u9fa5]+)$")){
					isOK = false;
					errors.put("address", "��ַ�����Ǻ���");
				}
			}
			
			
			//ְλ������Ϊ�գ�����Ҫ�Ǻ���
			if(this.position==null || this.position.trim().equals("")){
				isOK = false;
				errors.put("position", "ְλ����Ϊ��");
			}else{  //[^\u4e00-\u9fa5]*
				if(!this.position.matches("^([\u4e00-\u9fa5]+)$")){
					isOK = false;
					errors.put("position", "ְλ�����Ǻ���");
				}
			}
			
			//��֤��
			if(client_checkcode==null || this.client_checkcode.trim().equals("")){
				isOK = false;
				errors.put("client_checkcode", "��֤�벻��Ϊ��");
			}else{
				if(!this.client_checkcode.equals(this.server_checkcode.trim())){
					isOK = false;
					System.out.println(client_checkcode);
					System.out.println(server_checkcode);
					errors.put("client_checkcode", "��֤�����");
				}
			}
			return isOK;
		}
	
}
