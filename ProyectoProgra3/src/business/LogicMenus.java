package business;

import java.util.ArrayList;
import java.util.List;

import data.MenuBreakfastData;
import data.MenuLunchData;
import domain.Menus;

public class LogicMenus {

	public LogicMenus() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static List<Menus> getMenu(int index,boolean schedule){
		List<Menus> menus =new ArrayList<Menus>();
		switch (index) {
		case 0:	
			if(schedule) {
				menus = MenuBreakfastData.getMenuList(MenuBreakfastData.fileNameMondayBreakfast);
			}else{
				menus =MenuLunchData.getMenuList(MenuLunchData.fileNameMondayLunch);
				}
		
			break; 
		case 1:
			if(schedule) {
				menus =MenuBreakfastData.getMenuList(MenuBreakfastData.fileNameTuesdayBreakfast);
			}else{
				menus =MenuLunchData.getMenuList(MenuLunchData.fileNameTuesdayLunch);
				}
			break;
		case 2:
			if(schedule) {
				menus =MenuBreakfastData.getMenuList(MenuBreakfastData.fileNameWednesdayBreakfast);
			}else{
				menus =MenuLunchData.getMenuList(MenuLunchData.fileNameWednesdayLunch);
				}
			break;
		case 3:
			if(schedule) {
				menus =MenuBreakfastData.getMenuList(MenuBreakfastData.fileNameThurdsdayBreakfast);
			}else{
				menus=MenuLunchData.getMenuList(MenuLunchData.fileNameThurdsdayLunch);
			}
			break;
		case 4:
			if(schedule) {
				menus =MenuBreakfastData.getMenuList(MenuBreakfastData.fileNameFridayBreakfast);
			}else{
				menus =MenuLunchData.getMenuList(MenuLunchData.fileNameFridayLunch);
				}
			break;
			
		default:
			return null;
		}
		return menus;
	}
	
	
	public static boolean setAliments(Menus menu,int index,boolean schedule) {
		switch (index) {
		
		case 0:	
			if(schedule) {
				MenuBreakfastData.saveMenu(menu,MenuBreakfastData.fileNameMondayBreakfast);
			}else{
				MenuLunchData.saveMenu(menu,MenuLunchData.fileNameMondayLunch);
				}
		
			break; 
		case 1:
			if(schedule) {
				MenuBreakfastData.saveMenu(menu,MenuBreakfastData.fileNameTuesdayBreakfast);
			}else{
				MenuLunchData.saveMenu(menu,MenuLunchData.fileNameTuesdayLunch);
				}
			break;
		case 2:
			if(schedule) {
				MenuBreakfastData.saveMenu(menu,MenuBreakfastData.fileNameWednesdayBreakfast);
			}else{
				MenuLunchData.saveMenu(menu,MenuLunchData.fileNameWednesdayLunch);
				}
			break;
		case 3:
			if(schedule) {
				MenuBreakfastData.saveMenu(menu,MenuBreakfastData.fileNameThurdsdayBreakfast);
			}else{
				MenuLunchData.saveMenu(menu,MenuLunchData.fileNameThurdsdayLunch);
				}
			break;
		case 4:
			if(schedule) {
				MenuBreakfastData.saveMenu(menu,MenuBreakfastData.fileNameFridayBreakfast);
			}else{
				MenuLunchData.saveMenu(menu,MenuLunchData.fileNameFridayLunch);
				}
			break;
			
		default:
			return false;
		}
		return true;
	}
}
