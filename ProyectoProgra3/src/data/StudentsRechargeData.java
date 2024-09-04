package data;

import java.io.IOException;
import java.util.List;

import business.LogicStudents;
import domain.StudentRecharge;

public class StudentsRechargeData {
	
	private static JsonUtils<StudentRecharge> jsonUtils = new JsonUtils<StudentRecharge>(); 
	public static final String fileName = "student_recharges.json";
	
	public static boolean  existStudent(String carnet) {
		return LogicStudents.existCarnet(carnet);
	}
	public static void makeRecharge(StudentRecharge sR) {
		LogicStudents.makeRecharge(sR);
	}
	
	public static boolean saveRecharge(StudentRecharge sR) {
		try {
			jsonUtils.saveElement(sR,fileName);
			return true;
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		return false;
		
	}
	
	public static List<StudentRecharge> getRechargeList(){
		try {
			return  jsonUtils.getElement(StudentRecharge.class,fileName);
		}catch (IOException e) {
			return null;
		}
	}
	
	
}
