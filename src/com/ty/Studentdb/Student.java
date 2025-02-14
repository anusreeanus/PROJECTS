package com.ty.Studentdb;

public class Student {
   private String name;
   private String id;
   private int age;
   private int marks;
   static int count =101;
public Student(String name, int age, int marks) {
	
	this.name = name;
	this.id = "JSP"+count;
	this.age = age;
	this.marks = marks;
	count++;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
//public void setId(String id) {
//	this.id = id;
//}
 public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}

@Override
public String toString() {
	return "Student [name=" + name + ", id=" + id + ", age=" + age + ", marks=" + marks + "]";
}
//a string representation of the Student object. This is useful for debugging, logging, or simply displaying the object's state.

//@Override Annotation: Indicates that this method overrides the toString method inherited from the Object class.
     
   
}
 