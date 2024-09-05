package business;

import data.StudentsData;
import domain.Menus;
import domain.Student;

public class LogicRequestService {

	public LogicRequestService() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean makeService(Menus menu,Student student) {
		double price = student.getAvailableMoney() - menu.getPrice();
		if(price>=0) {
		Student s = student;
		StudentsData.removeStudent(student);
		s.setAvailableMoney(s.getAvailableMoney()-menu.getPrice());
		StudentsData.saveStudent(s);
		return true;
		}else {
			return false;
		}
	}
	
	
}
