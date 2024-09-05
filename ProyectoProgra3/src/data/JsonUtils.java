package data;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//clase generica para leer y escribir cualquier objeto en jSon
public class JsonUtils<T> {
	//Manejo de Json
	private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
	//Constructor
	public JsonUtils() {
	}
	
	public void saveElement(T t,String fileP) throws IOException {
		List<T> temp = getElement((Class<T>) t.getClass(),fileP); 

		temp.add(t);
		mapper.writeValue(new File(fileP), temp);
	}
	//devuelve la lista de elementos de el documento especificado por parametro
	public List<T> getElement(Class<T> temp,String fileP) throws IOException{
		File file = new File(fileP);
		if(!file.exists()) {
			return new ArrayList<>();
		}
		return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, temp));
	}
	
	public void updateElement(T t,T tSecond,String filePath) throws IOException {
		
		List<T> objects = getElement((Class<T>) t.getClass(),filePath);
		
		for( int i = 0;i<objects.size();i++) {
			if(objects.get(i).equals(tSecond)) {
				objects.remove(i);
				break;
			}
			
		}
		objects.add(tSecond);
		mapper.writeValue(new File(filePath), objects);
	}
	
	public void removeElement(T t,String filePath) throws IOException {
		List<T> objects = getElement((Class<T>) t.getClass(),filePath);
		System.out.println("FAJKOWEHFIUJHAWE");
		
		for( int i = 0;i<objects.size();i++) {
			if(objects.get(i).equals(t)) {
				objects.remove(i);
				break;
			}
			
		}
		
		mapper.writeValue(new File(filePath), objects);
	}
	
}