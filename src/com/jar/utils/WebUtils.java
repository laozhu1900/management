package com.jar.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {

	public static <T> T request2Bean(HttpServletRequest request,
			Class<T> beanCalss) {

		try {
			// 1.����Ҫ��װ���ݵ�bean
			T bean = beanCalss.newInstance();

			// 2.��request�е���������bean��
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement(); // username password
														// email birthday
				String value = request.getParameter(name); // aaaa 123 aa@
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void copyBean(Object src, Object dest) {
		// ע������ת����
		ConvertUtils.register(new Converter() {
			public Object convert(Class type, Object value) {
				if (value == null) {
					return null;
				}
				String str = (String) value;
				if (str.trim().equals("")) {
					return null;
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// ����ȫ��Ψһ��id
	public static String generateID() {
		return UUID.randomUUID().toString();
	}

}
