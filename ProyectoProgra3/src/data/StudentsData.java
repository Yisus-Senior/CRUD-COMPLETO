package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import business.LogicStudents;
import domain.Menus;
import domain.Student;
import domain.StudentRecharge; 

public class StudentsData {

	public static List<Student> studentList = new ArrayList<Student>();
	private static final String fileName = "Student.json";
	private static JsonUtils<Student> jsonUtils = new JsonUtils<Student>();
	
	public static Student getStudent(String carnet) {
		return LogicStudents.getStudent(carnet);
	}
	
	public static List<Student> getStudentsList(){
		try {
			return (ArrayList<Student>) jsonUtils.getElement(Student.class,fileName);
		}catch(IOException e) {
		}
		return null;
	}
	
	public static boolean saveStudent(Student s) {
		try {
			jsonUtils.saveElement(s,fileName);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updatedStudent(Student s,Student sSecond) {
		try {
			jsonUtils.removeElement(s, fileName);
			
			jsonUtils.saveElement(sSecond, fileName);
			
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	
	}
	
	public static void removeStudent(Student s) {
		try {
			jsonUtils.removeElement(s, fileName);
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
