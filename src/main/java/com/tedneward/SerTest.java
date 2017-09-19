package com.tedneward;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class SerTest {

	@Test
	public void serializeToDisk() {
		 try
	        {
	            com.tedneward.Person ted = new com.tedneward.Person("Ted", "Neward", 39);
	            com.tedneward.Person charl = new com.tedneward.Person("Charlotte",
	                "Neward", 38);

	            ted.setSpouse(charl); charl.setSpouse(ted);

	            FileOutputStream fos = new FileOutputStream("tempdata.ser");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(ted);
	            oos.close();
	        }
	        catch (Exception ex)
	        {
	            fail("Exception thrown during test: " + ex.toString());
	        }
	        
	        try
	        {
	            FileInputStream fis = new FileInputStream("tempdata.ser");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            com.tedneward.Person ted = (com.tedneward.Person) ois.readObject();
	            ois.close();
	            
	            assertEquals(ted.getFirstName(),"Ted");
	            assertEquals(ted.getSpouse().getFirstName(),"Charlotte");

	            // Clean up the file
	            new File("tempdata.ser").delete();
	        }
	        catch (Exception ex)
	        {
	            fail("Exception thrown during test: " + ex.toString());
	        }
	}

}
