package org.LyesSNAOUI.reflection;

import java.io.BufferedReader;
import org.LyesSNAOUI.reflection.AnalyzeBean;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonReader extends FileReader{

	private FileReader fr;

	public PersonReader (FileReader fr) {
		super(FileDescriptor.in);
		this.fr =fr;
	}


	public List<Object> readObjects(){

		List<Object> obj = new ArrayList<>();
		AnalyzeBean ab = new AnalyzeBean();

		try(FileReader fr = this.fr;
				BufferedReader br = new BufferedReader(fr)){

			String line = br.readLine();
			

			while (line != null ) {

				
				if (!line.startsWith("#")) {
					
					System.out.println("this");
					if (line.split("=")[0].equals("bean.name")){
						String name = line.split("=")[1];

						String className = br.readLine().split("=")[1];
						Class<?> clas = Class.forName(className);
						Object bean = clas.getConstructor().newInstance();
						
						
						ab.set(bean, "lname", br.readLine().split("=")[1]);
						ab.set(bean, "fname", br.readLine().split("=")[1]);
						ab.setint(bean, "age", Integer.parseInt(br.readLine().split("=")[1]));	
						System.out.println("this" + bean);

						obj.add(bean);
					}
				}

				line = br.readLine();	
			}
			

		} catch (NoSuchFieldException | IOException | ClassNotFoundException | 
				InstantiationException | IllegalAccessException | IllegalArgumentException | 
				InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}

		return obj;
	}

}
