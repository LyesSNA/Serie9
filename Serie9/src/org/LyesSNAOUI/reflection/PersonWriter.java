package org.LyesSNAOUI.reflection;

import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersonWriter extends FileWriter{

	private FileWriter fw; 
	
	
	public PersonWriter (FileWriter fw) {
		super(FileDescriptor.out);
		this.fw =fw;
	}
	
	
	public void writePeople(List<Object> bean ) {
		
		
		AnalyzeBean ab = new AnalyzeBean();
		int count = 0;
		
		try (BufferedWriter bw = new BufferedWriter(this);){
			
			bw.write("# Ceci est une ligne de commentaires");
			
			for (Object object : bean) {
				if(ab.getClassName(object) == "org.LyesSNAOUI.reflection.Person") {
					
					bw.newLine();
					bw.write("bean.name=p" + count);
					bw.newLine();
					bw.write("p"+count+".class=org.LyesSNAOUI.reflection.Person");
					bw.newLine();
					bw.write("p"+count+".lastName="+ ab.get(object, "lname"));
					bw.newLine();
					bw.write("p"+count+".firstName="+ ab.get(object, "fname"));
					bw.newLine();
					bw.write("p"+count+".age="+ ab.get(object, "age"));
				}
				else if ( ab.getClassName(object) == "org.LyesSNAOUI.reflection.Employee") {
					bw.newLine();
					bw.write("p"+count+".age="+ ab.getFromSuper(object, "age"));
					bw.newLine();
					bw.write("p"+count+".class=org.LyesSNAOUI.reflection.Employee");
					bw.newLine();
					bw.write("p"+count+".lastName="+ ab.getFromSuper(object, "lname"));
					bw.newLine();
					bw.write("p"+count+".firstName="+ ab.getFromSuper(object, "fname"));
					bw.newLine();
					bw.write("p"+count+".salary="+ ab.get(object, "salary"));
					
				}
				
				count ++;
				
			}

			bw.close();
			
		} catch (IOException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
