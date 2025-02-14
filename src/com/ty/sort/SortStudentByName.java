package com.ty.sort;
import java.util.Comparator;

import com.ty.Studentdb.Student;


public class SortStudentByName  implements Comparator<Student> {

		@Override
		public int compare(Student x , Student y) {
			// TODO Auto-generated method stub
			return x.getName().compareTo(y.getName());
		}//compare Method: Compares two Student objects based on their age. Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
		

	}



