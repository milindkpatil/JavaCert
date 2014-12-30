package ocpjp;

import java.io.*;

/*

 Classes that require special handling during the serialization and deserialization process must implement special methods with these exact signatures:

 private void writeObject(java.io.ObjectOutputStream out)  throws IOException

 private void readObject(java.io.ObjectInputStream in)  throws IOException, ClassNotFoundException;

 private void readObjectNoData()  throws ObjectStreamException;

 The writeObject method is responsible for writing the state of the object for its particular class so that the corresponding readObject method can restore it. 
 The default mechanism for saving the Object's fields can be invoked by calling out.defaultWriteObject. The method does not need to concern itself with the state belonging to its superclasses or subclasses. 
 State is saved by writing the individual fields to the ObjectOutputStream using the writeObject method or by using the methods for primitive data types supported by DataOutput.

 The readObject method is responsible for reading from the stream and restoring the classes fields. It may call in.defaultReadObject to invoke the default mechanism 
 for restoring the object's non-static and non-transient fields. The defaultReadObject method uses information in the stream to assign the fields of the object 
 saved in the stream with the correspondingly named fields in the current object. This handles the case when the class has evolved to add new fields. 
 The method does not need to concern itself with the state belonging to its superclasses or subclasses. State is saved by writing the individual fields
 to the ObjectOutputStream using the writeObject method or by using the methods for primitive data types supported by DataOutput.

 The readObjectNoData method is responsible for initializing the state of the object for its particular class in the event that the serialization stream does 
 not list the given class as a superclass of the object being deserialized. This may occur in cases where the receiving party uses a different version 
 of the deserialized instance's class than the sending party, and the receiver's version extends classes that are not extended by the sender's version. 
 This may also occur if the serialization stream has been tampered; hence, readObjectNoData is useful for initializing deserialized objects properly despite a "hostile" or incomplete source stream.

 Serializable classes that need to designate an alternative object to be used when writing an object to the stream should implement this special method with the exact signature:

 ANY-ACCESS-MODIFIER Object writeReplace() throws ObjectStreamException;

 This writeReplace method is invoked by serialization if the method exists and it would be accessible from a method defined within the class of the object being serialized. 
 Thus, the method can have private, protected and package-private access. Subclass access to this method follows java accessibility rules.

 Classes that need to designate a replacement when an instance of it is read from the stream should implement this special method with the exact signature.

 ANY-ACCESS-MODIFIER Object readResolve() throws ObjectStreamException;

 This readResolve method follows the same invocation rules and accessibility rules as writeReplace.

 The serialization runtime associates with each serializable class a version number, called a serialVersionUID, which is used during deserialization to verify that 
 the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. 
 If the receiver has loaded a class for the object that has a different serialVersionUID than that of the corresponding sender's class, then deserialization will result
 in an InvalidClassException. A serializable class can declare its own serialVersionUID explicitly by declaring a field named "serialVersionUID" that must be static, final, and of type long:

 ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L;

 If a serializable class does not explicitly declare a serialVersionUID, then the serialization runtime will calculate a default serialVersionUID value 
 for that class based on various aspects of the class, as described in the Java(TM) Object Serialization Specification. However, it is strongly recommended
 that all serializable classes explicitly declare serialVersionUID values, since the default serialVersionUID computation is highly sensitive to class details
 that may vary depending on compiler implementations, and can thus result in unexpected InvalidClassExceptions during deserialization. 
 Therefore, to guarantee a consistent serialVersionUID value across different java compiler implementations, a serializable class must declare an explicit serialVersionUID value.
 It is also strongly advised that explicit serialVersionUID declarations use the private modifier where possible, since such declarations apply only to the immediately 
 declaring class--serialVersionUID fields are not useful as inherited members. Array classes cannot declare an explicit serialVersionUID, so they always have
 the default computed value, but the requirement for matching serialVersionUID values is waived for array classes.
 */

public class SerializationHandler {

	public static void main(String[] args) {
		String fileName = "subclass.ser";

		SubClass subClass = new SubClass();
		subClass.setId(10);
		subClass.setValue("Data");
		subClass.setName("Milind");

		try {
			SerializationUtil.serialize(subClass, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		try {
			SubClass subNew = (SubClass) SerializationUtil
					.deserialize_single_object(fileName);
			System.out.println("SubClass read = " + subNew);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}

class SuperClass {

	private int id;
	private String value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

class SubClass extends SuperClass implements Serializable,
		ObjectInputValidation {

	private static final long serialVersionUID = -1322322139926390329L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SubClass{id=" + getId() + ",value=" + getValue() + ",name="
				+ getName() + "}";
	}

	// /BIG NOTE: throws IOException is optional in all following four methods.

	// adding helper method for serialization to save/initialize super class
	// state
	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {

		System.out
				.println("Called: private void readObject(ObjectInputStream ois)");
		ois.defaultReadObject();

		// notice the order of read and write should be same
		setId(ois.readInt());
		setValue((String) ois.readObject());
	}

	// adding helper method for de-serialization to set proper super class
	// state.
	private void writeObject(ObjectOutputStream oos) throws IOException {
		System.out
				.println("Called: private void writeObject(ObjectOutputStream oos)");
		oos.defaultWriteObject();
		oos.writeInt(getId());
		oos.writeObject(getValue());
	}

	private Object writeReplace() throws IOException {
		System.out.println("Called: private Object writeReplace()");
		return this;
	}

	private Object readResolve() throws IOException {
		System.out.println("Called: private Object readResolve()");
		return this;
	}

	@Override
	public void validateObject() throws InvalidObjectException {
		// validate the object here
		if (name == null || "".equals(name))
			throw new InvalidObjectException("name can't be null or empty");
		if (getId() <= 0)
			throw new InvalidObjectException("ID can't be negative or zero");
	}

}