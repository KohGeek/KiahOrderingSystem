package Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Testing1 {
	public static void main(String[] args) throws IOException {
		try {
//			ArrayList<student2> sArr = new ArrayList<student2>();

//			student s = new student("rickie", "12345");
//			sArr.add(new student2("rickie", "12345"));
//			sArr.add(new student2("jason", "99999"));

//			File obj = new File("student.txt");
			File obj = new File("student2.txt");
//			ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(obj));
//			objout.writeObject(sArr);
//			objout.close();

			ObjectInputStream objin = new ObjectInputStream(new FileInputStream(obj));
//			student instudent = null;
//			instudent = (student)objin.readObject();

			ArrayList<student2> studentArr = new ArrayList<student2>();
			studentArr = (ArrayList<student2>) objin.readObject();
//			System.out.println(instudent.name + " and " + instudent.regno);
			System.out.println(studentArr.get(0).name + " and " + studentArr.get(0).regno);
			System.out.println(studentArr.get(1).name + " and " + studentArr.get(1).regno);
			objin.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class student2 implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	String regno;

	public student2(String name, String regno) {
		super();
		this.name = name;
		this.regno = regno;
	}

}
