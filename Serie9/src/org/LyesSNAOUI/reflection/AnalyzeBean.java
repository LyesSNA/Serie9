package org.LyesSNAOUI.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AnalyzeBean {


	public String getClassName(Object o) {
		return o.getClass().getName();
	}

	public Object getInstance(String className) {
		try {
			Class<?> clas = Class.forName(className);
			return clas.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getProperties(Object o){

		List<String> methods = new ArrayList<String>();


		for (Method method : o.getClass().getMethods() ) {
			if (method.getName().startsWith("get") 
					&& method.getParameterCount()==0
					&& Modifier.isPublic(method.getModifiers()))

				methods.add(method.getName().substring(3));

			else if(method.getName().startsWith("is")&& method.getParameterCount()==0
					&& Modifier.isPublic(method.getModifiers()))
				methods.add(method.getName().substring(2));
		} 

		return methods;
	}

	public Object get(Object bean, String property)  throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field field = bean.getClass().getDeclaredField(property);
		field.setAccessible(true);
		return 	field.get(bean);
	}

	public void set(Object bean, String property, Object value) throws NoSuchFieldException, SecurityException,
	IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException{

		Class<?> cls = bean.getClass();

		if (cls == Class.forName("org.LyesSNAOUI.reflection.Person")) {

			Field field = cls.getDeclaredField(property);
			field.setAccessible(true);

			String methodName = "set" + property.substring(0,1).toUpperCase() + property.substring(1).toLowerCase();
			System.out.println(methodName);

			bean.getClass().getMethod(methodName, String.class).invoke(bean, value);
		}
		else {
			Field field = cls.getSuperclass().getDeclaredField(property);
			field.setAccessible(true);

			String methodName = "set" + property.substring(0,1).toUpperCase() + property.substring(1).toLowerCase();
			System.out.println(methodName);

			bean.getClass().getSuperclass().getMethod(methodName, String.class).invoke(bean, value);
		}



	}

	public void setage(Object bean, String property, Object value) throws NoSuchFieldException, SecurityException,
	IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException{

		Class<?> cls = bean.getClass();
		
		if (cls == Class.forName("org.LyesSNAOUI.reflection.Person")) {
			Field field = cls.getDeclaredField(property);
			field.setAccessible(true);

			String methodName = "set" + property.substring(0,1).toUpperCase() + property.substring(1).toLowerCase();
			System.out.println(methodName);

			bean.getClass().getMethod(methodName, int.class).invoke(bean, value);
		}
		else {
			Field field = cls.getSuperclass().getDeclaredField(property);
			field.setAccessible(true);

			String methodName = "set" + property.substring(0,1).toUpperCase() + property.substring(1).toLowerCase();
			System.out.println(methodName);

			bean.getClass().getSuperclass().getMethod(methodName, int.class).invoke(bean, value);
		}
		}
	
	public void setSalary(Object bean, String property, Object value) throws NoSuchFieldException, SecurityException,
	IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException{

		Class<?> cls = bean.getClass();
		Field field = cls.getDeclaredField(property);
		field.setAccessible(true);

		String methodName = "set" + property.substring(0,1).toUpperCase() + property.substring(1).toLowerCase();
		System.out.println(methodName);

		bean.getClass().getMethod(methodName, int.class).invoke(bean, value);
		
	}
		
	
}






