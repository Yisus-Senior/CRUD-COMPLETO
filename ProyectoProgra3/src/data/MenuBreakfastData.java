package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.Menus;

public class MenuBreakfastData {
	public static Menus menuTemp;
	
	public static List<Menus> menuListMondayBreakfast = new ArrayList<Menus>();
	public static List<Menus> menuListTuesdayBreakfast = new ArrayList<Menus>();
	public static List<Menus> menuListWednesdayBreakfast = new ArrayList<Menus>();
	public static List<Menus> menuListThursdayBreakfast = new ArrayList<Menus>();
	public static List<Menus> menuListFridayBreakfast = new ArrayList<Menus>();
	
	public static final String fileNameMondayBreakfast = "monday_breakfast.json";
	public static final String fileNameTuesdayBreakfast = "tuesday_breakfast.json";
	public static final String fileNameWednesdayBreakfast = "wednesday_breakfast.json";
	public static final String fileNameThurdsdayBreakfast = "thursday_breakfast.json";
	public static final String fileNameFridayBreakfast = "friday_breakfast.json";
	
	private static JsonUtils<Menus> jsonUtils = new JsonUtils<Menus>(); 
	
	public static boolean saveMenu(Menus menu,String filePath) {
		try {
			jsonUtils.saveElement(menu,filePath);
			return true;
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		return false;
		
	}
	
	public static List<Menus> getMenuList(String filePath){
		try {
			return  jsonUtils.getElement(Menus.class,filePath);
		}catch (IOException e) {
			return null;
		}
	}
	
	public static boolean updatedMenu(Menus menuSecond,String filePath) {
		try {
			jsonUtils.updateElement(menuTemp,menuSecond,filePath);
			menuSecond=null;

			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	
	}
	
//	public static List<Menus> getMenu(int index){
//		
//	}
//	
	
}
