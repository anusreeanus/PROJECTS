package com.ty.Studentdb;

import java.util.Scanner;

import com.ty.exception.InvalidChoiceException;

public class Solution {
public static void main(String[] args) {
	System.out.println("Welcome to Student Management System\n.............................................");
	Scanner sc= new Scanner(System.in);
	StudentDbManagement sdm=new StudentManagement();
	while(true) {
	System.out.println("\n1:Add Student\n2:Display Student\n3:Display All Student\n4:Remove Student");
	System.out.println("5:Remove All Student\n6:Update Student\n7:Count Student\n8:Sort Student");
	System.out.println("9:Highest Mark Student\n10:Lowest Mark Student\n11:EXIT");
	System.out.println("\nEnter your Choice:\n");
	int choice=sc.nextInt();
	switch(choice) {
	case 1:
		sdm.addStudent();
		break;
	case 2:
		sdm.displayStudent();
		break;
	case 3:
		sdm.displayAllStudent();
		break;
	case 4:
		sdm.removeStudent();
		break;
	case 5:
		sdm.removeAllStudent();
		break;
	case 6:
		sdm.updateStudent();
		break;
	case 7:
		sdm.countStudent();
		break;
	case 8:
		sdm.sortStudent();
		break;
	case 9:
		sdm.highestMarkStudent();
		break;
	case 10:
		sdm.lowestMarkStudent();
		break;
	case 11:
		System.out.println("Exiting from Student Database");
		System.out.println("Thank you!..");
		System.exit(0);
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
	
}
}
