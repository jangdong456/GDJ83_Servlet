package com.jang.home.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentService {
	
	public List<Student> getStudents() {
		//학생들을 만들어서 리턴	
		ArrayList<Student> ar = new ArrayList<Student>();
		Random random = new Random();
		
		
		for(int i=0; i<5; i++) {
			Student student = new Student();
			student.setNum(i+1);
			student.setName("name"+i);
			student.setAvg(random.nextInt(100)+random.nextDouble());
			
			ar.add(student);
		}
		return ar;
	}
	
	
	public Student makeStudent() {
		Student student = new Student();
		
		//DB에 꺼내올 데이터
		student.setNum(1);
		student.setName("asd");
		student.setAvg(52.12);
		
		return student;
	}
}
