package ocpjp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializationBasics {
	public static void main(String args[]) {

		Dog bullDog = new Dog();
		Dog bullDog1 = new Dog(20);
		
		String fileName = "dog.ser";

		try {
			
			List<Object> objList = new ArrayList<>();
			objList.add(bullDog);
			objList.add(bullDog1);
			print(objList);
			SerializationUtil.serialize(objList, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		bullDog = null;
		Dog.DOG_BYTES = 222;
		
		try {
			List<Object> objList = SerializationUtil.deserialize(fileName);
			print(objList);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void print(List<Object> objList){
		System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		for (Object obj : objList)
			System.out.println(obj);
		System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
	}
}

class Animal {

	int animalInt = 7;
	double animalDouble = 7.12345678901234567890123456789;

	Animal() {
		System.out.println("Animal Constructor called");
	}

	Animal(int x) {
		System.out.println("Animal Constructor called with x: " + x);
	}

	@Override
	public String toString() {
		return ("animalInt:" + animalInt + ",\tanimalDouble:" + animalDouble);
	}
}

// It is ok serialize subclass for a super class that has not implemented Serializable.
class Dog extends Animal implements Serializable {

	private static final long serialVersionUID = 1L;

	int dogInt = 9;
	transient int dogTint = 10;
	volatile int dogVint = 11;
	final int dogFinalInt = 12;
	static int DOG_BYTES = 0;
	// Without transient both statements will throw runtime exception
	// java.io.NotSerialixableException
	// Wings noWings = new Wings();
	// Bat bat = new Bat()

	transient Bat bat = new Bat();
	transient Wings noWings = new Wings();

	Dog() {
		System.out.println("Default Dog Constructor called");
	}

	Dog(int x) {
		super(x);
		this.dogInt = 111;
		this.dogTint = 111;
		this.dogVint = 111;
		super.animalInt = 111;
		super.animalDouble = 111;
		DOG_BYTES = 111;
		
		System.out.println("Overloaded int Dog Constructor called.");
	}

	@Override
	public String toString() {
		return (super.toString())
				+ ("\nDOG_BYTES" + DOG_BYTES + ",\t dogInt:" + dogInt + ",\tdogTint:" + dogTint + ",\tdogFinalInt:" + dogFinalInt + ",\tdogVInt:" 
						+ dogVint + ",\tnoWings:" + noWings + ",\tbat:" + bat);
	}

}

// Warning : The serializable class Bat does not declare a static final serialVersionUID field of type long
class Bat extends Animal implements Serializable {
	Wings wing = new Wings();
}

class Wings {

}