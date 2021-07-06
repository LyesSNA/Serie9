package org.LyesSNAOUI.reflection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class Reflection {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException,
	IllegalArgumentException, IllegalAccessException, NoSuchMethodException,
	InvocationTargetException {


		Person p1 = new Person("Benzema", "Karim",33 );
		Employee e1 = new Employee("Emmanuel", "Macron", 40, 8000);

		AnalyzeBean beanAnalyzer = new AnalyzeBean();		
		//		System.out.println(beanAnalyzer.getClassName(p1));

		Object instance = beanAnalyzer.getInstance("org.LyesSNAOUI.reflection.Person");
		//		System.out.println(beanAnalyzer.getClassName(instance));

		System.out.println(beanAnalyzer.getProperties(p1));
		System.out.println(beanAnalyzer.getProperties(e1));
		//
		//		System.out.println(beanAnalyzer.get(p1, "fName"));
		//
		//		System.out.println("p1 before set   " + p1);
		//
		//		beanAnalyzer.set(p1, "age", 38);
		//
		//		System.out.println("p1 after set    " + p1);


		System.out.println("\n\n");

		List<String> lst = List.of("Youcef", "Zeg");
		List<Object> readObjects = new ArrayList<>();

		File f = new File ("files/people.txt");

		try(FileReader fr = new FileReader(f);){

			PersonReader pr = new PersonReader(fr);

			readObjects = pr.readObjects();


		} catch (IOException e) {
			e.printStackTrace();
		}

	File f2 = new File("files/peopleFromList.txt");

	try(FileWriter fw = new FileWriter(f2);){

		PersonWriter pw = new PersonWriter(fw);

		pw.writePeople(readObjects);
		System.out.println("write OK");
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}

}

