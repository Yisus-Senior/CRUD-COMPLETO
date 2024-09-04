package business;

import java.util.ArrayList;
import java.util.List;

import data.StudentsData;
import domain.Student;
import domain.StudentRecharge;

public class LogicStudents {

	public LogicStudents() {
		
	}
	
	public boolean isAlreadyAdded(String id) {
		List<Student> studentList = StudentsData.getStudentsList();
		if(studentList!=null) {
			for(int i=0;i<studentList.size();i++) {
				if(studentList.get(i)!=null) {
					if(studentList.get(i).getCarnet().equals(id)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean validRecharge(int recharge) {
		if(recharge >= 1000 && recharge <= 10000) {
			return true;
		}
		return false;
	}
	
	public static boolean existCarnet(String carnet){
		for(Student e : StudentsData.getStudentsList()) {
			if(e.getCarnet().equals(carnet)) {
				return true;
			}
		}
		return false;
	}
	//renueva el estudiante con el nuevo dinero disponible
	public static void makeRecharge(StudentRecharge studentRecharge) {
		for(Student student : StudentsData.getStudentsList()) {
			
			if(student.getCarnet().equals(studentRecharge.getCarnet())) {
				
				Student studentoUpdate=new  Student();
				studentoUpdate=student;
				StudentsData.removeStudent(student);
				studentoUpdate.setAvailableMoney(student.getAvailableMoney()+studentRecharge.getAmount());
				StudentsData.saveStudent(studentoUpdate);
				
				break;
			}
		}
	}
	
	public static Student getStudent(String carnet){
		for(Student e : StudentsData.getStudentsList()) {
			if(e.getCarnet().equals(carnet)) {
				return e;
			}
		}return null;
	}
}
