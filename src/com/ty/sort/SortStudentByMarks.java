package com.ty.sort;

import java.util.Comparator;

import com.ty.Studentdb.Student;

public class SortStudentByMarks implements Comparator<Student> {

	@Override
	public int compare(Student x , Student y) {
		// TODO Auto-generated method stub
		return x.getMarks()-(y.getMarks());
	}
	

}