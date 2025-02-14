package com.ty.Studentdb;
import java.util.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.Set;
import com.ty.sort.*;
import com.ty.exception.InvalidChoiceException;
import com.ty.exception.StudentNotFoundException;

public class StudentManagement implements StudentDbManagement {
       Scanner sc=new Scanner(System.in);
       Map<String,Student> db= new LinkedHashMap<String,Student>();
//       Map<String, Student> db: A LinkedHashMap to store student records with the student id as the key and the Student object as the value. 
//       LinkedHashMap maintains insertion order, which can be useful for displaying records.
	
	 @Override
	 public void addStudent() {
		System.out.println("Enter the student Name");
		String name= sc.next();		
		System.out.println("Enter the student Age");
		int age= sc.nextInt();		
		System.out.println("Enter the student Marks");
		int marks= sc.nextInt();	
		Student student=new Student(name, age, marks);
		db.put(student.getId(), student);
//		Adds the newly created Student object to the db map with the student id as the key.
		System.out.println("Student id is :" +student.getId());
		
		System.out.println("Student record inserted Successfully");
		
	 }
	@Override
	public void displayStudent() {
		System.out.println("Enter the student Id");
		String id= sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
//		Checks if the id exists in the db map.
		{
			Student std=db.get(id);//if id is present then gets the details.
			System.out.println("Id : "+std.getId());
			System.out.println("Name : "+std.getName());
			System.out.println("Age : "+std.getAge());
			System.out.println("Marks : "+std.getMarks());
		}
		else {
			try {
				String message="Student not found with the id"+id;
				throw new StudentNotFoundException(message);
			}catch(Exception e){
                System.out.println(e.getMessage());				
			}
		}
	}

	@Override
	public void displayAllStudent() {
		if(db.size()!=0) //if not empty proceeds to display the student details
		{
			System.out.println("Student Details are as follows:");
			System.out.println("...............................");
			Set<String> keys =db.keySet();
			
		for(String key:keys) {
			Student std=db.get(key);
			System.out.println(std);
		}
		}
		else {
			try {
				String message="Student databasse is empty to display";
				throw new StudentNotFoundException(message);
			}catch(Exception e){
                System.out.println(e.getMessage());				
			}
		}
	
		
	}

	@Override
	public void removeStudent() {
		
		System.out.println("Enter the student Id");
		String id= sc.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("Student Record found");
			System.out.println(db.get(id));
			db.remove(id);//used to delete the student record
			System.out.println("Student record deleted successfully");
		}
		else {
			try {
				String message="Student not found with the id"+id;
				throw new StudentNotFoundException(message);
			}catch(Exception e){
                System.out.println(e.getMessage());				
			}
		}
	}


	@Override
	public void removeAllStudent() {
		if(db.size()!=0) {
			System.out.println("Student Record Available:"+db.size());
			db.clear();//used to clear all the records from dbmap.
			System.out.println("All record deleted");
			System.out.println("Student Record Available:"+db.size());
			
		
		}
		else {
			try {
				String message="Student Database Empty ,NOthing to Delete";
				throw new StudentNotFoundException(message);
			}catch(Exception e){
                System.out.println(e.getMessage());				
			}
		}
	
		
		
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter the student Id");
		String id= sc.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1:Update Name\n2:Update Age\n3:Update marks");
			System.out.println("Enter your Choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Name");
				String name=sc.next();
				std.setName(name);
				break;
			case 2:
				System.out.println("Enter Age");
				int age=sc.nextInt();
				std.setAge(age);
				break;
			case 3:
				System.out.println("Enter Marks");
				int marks=sc.nextInt();
				std.setMarks(marks);
				break;
				default:
					String message="Invalid Choice";
					try {
					throw new InvalidChoiceException(message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			}
		}
		else {
			try {
				String message="Student Database Empty ,NOthing to Delete";
				throw new StudentNotFoundException(message);
			}catch(Exception e){
                System.out.println(e.getMessage());				
			}
		}
	}
	

	@Override
	public void sortStudent() {
		Set<String> keys =db.keySet();
		List<Student>list=new ArrayList<Student>();//Retrieves all Student objects from the db map and adds them to an ArrayList named list
		for(String key:keys) {
			list.add(db.get(key));
		}
		System.out.println("1:Sort by Id\n2:Sort by Name\n3:Sort by Age\n4:Sort by Marks");
		System.out.println("Enter Choice: ");
		int choice=sc.nextInt();
		switch(choice) //Uses the Collections.sort() method along with custom comparator classes (SortStudentById, SortStudentByName, SortStudentByAge, SortStudentByMarks) to sort the list based on the selected attribute.

		{
		case 1:
			Collections.sort(list,new SortStudentById());
			  display(list);
			break;
		
	case 2:
		Collections.sort(list,new SortStudentByName());
		    display(list); //to print the sorted list.
		break;
		
	case 3:
		Collections.sort(list,new SortStudentByAge());
	 	display(list);
		break;
	
   case 4:
	Collections.sort(list,new SortStudentByMarks());
	display(list);
	break;
  default:
	String message="Invalid Choice";
	try {
	throw new InvalidChoiceException(message);
    }catch(Exception e) {
    System.out.println(e.getMessage());
 }

  }

		
	}

	public static void display (List<Student> list) {
		for(Student student:list)
		{
			System.out.println(student);
		}
	}//Iterates over the List<Student> and prints each student using the overridden toString() method.
	@Override
	public void countStudent() {
	System.out.println("No of Student Records :\t "+db.size());
	}//Uses the size() method of the db map to get the count and prints it.

	@Override
	public void highestMarkStudent() {
		Set<String> keys =db.keySet();
		List<Student>list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());//Sorts the list using the SortStudentByMarks comparator in ascending order.
		System.out.println(list.get(list.size()-1));//the last element (list.size() - 1) will have the highest marks.
	}

	@Override
	public void lowestMarkStudent() {
		Set<String> keys =db.keySet();
		List<Student>list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(0));	//Since the list is sorted in ascending order, the first element (list.get(0)) will have the lowest marks. Prints this student.
	}
	
	

}

