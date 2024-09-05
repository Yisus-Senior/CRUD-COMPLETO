package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.Menus;

public class MenuLunchData {
	public static Menus menuTemp;
	
//	public static List<Menus> menuListMondayLunch = new ArrayList<Menus>();
//	public static List<Menus> menuListTuesdayLunch = new ArrayList<Menus>();
//	public static List<Menus> menuListWednesdayLunch = new ArrayList<Menus>();
//	public static List<Menus> menuListThursdayLunch = new ArrayList<Menus>();
//	public static List<Menus> menuListFridayLunch = new ArrayList<Menus>();
//	
	public static final String fileNameMondayLunch = "monday_lunch.json";
	public static final String fileNameTuesdayLunch = "tuesday_lunch.json";
	public static final String fileNameWednesdayLunch = "wednesday_lunch.json";
	public static final String fileNameThurdsdayLunch = "thursday_lunch.json";
	public static final String fileNameFridayLunch = "friday_lunch.json";
	
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
	
	public static boolean removeMenu(Menus menuToRemove,String filePath) {
		try {
			jsonUtils.removeElement(menuToRemove, filePath);
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
