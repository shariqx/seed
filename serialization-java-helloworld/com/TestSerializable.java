package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializable
{
	public static void main(String[] args) throws Exception 
	{
		SerializableClass sc = new SerializableClass(); 
		FileOutputStream fos = new FileOutputStream("serialTest.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(sc);
		
		FileInputStream fis = new FileInputStream("serialTest.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SerializableClass deserialized = (SerializableClass) ois.readObject();
		System.out.println(deserialized.readSb()); 
		//deserialized.close()
		ois.close(); 
		fos.close();
	}
	
	
}
