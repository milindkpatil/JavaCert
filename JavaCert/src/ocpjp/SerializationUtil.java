package ocpjp;

import java.beans.DesignMode;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationUtil {

	// deserialize to Object from given file
	public static List<Object> deserialize(String fileName) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = null;
		List<Object> objList = new ArrayList<>();

		while (true) {
			try {
				obj = ois.readObject();
				objList.add(obj);
			} catch (Exception e) {
				break;
			}
		}

		ois.close();
		return objList;
	}

	// serialize the given object and save it to file
	public static void serialize(List<Object> objList, String fileName)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		for (Object obj : objList)
			oos.writeObject(obj);

		fos.close();
	}
	
	public static void serialize(Object obj, String fileName) throws IOException{
		List<Object> objList = new ArrayList<Object>();
		objList.add(obj);
		serialize(objList, fileName);
	}

	public static Object deserialize_single_object(String fileName) throws ClassNotFoundException, IOException {
		return deserialize(fileName).get(0);
	}
	
	

}
