package com.jang.home.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentService {
	
	private StudentDAO studentDAO;
	
	public StudentService() {
		studentDAO = new StudentDAO();
	}
	
	public List<StudentDTO> getStudents() {
		//학생들을 만들어서 리턴	
		ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();
		Random random = new Random();
		
		
		for(int i=0; i<5; i++) {
			StudentDTO student = new StudentDTO();
			student.setNum(i+1);
			student.setName("name"+i);
			student.setAvg(random.nextInt(100)+random.nextDouble());
			
			ar.add(student);
		}
		return ar;
	}
	
	public StudentDTO makeStudent() {
		StudentDTO student = new StudentDTO();
		
		//DB에 꺼내올 데이터
		student.setNum(1);
		student.setName("asd");
		student.setAvg(52.12);
		
		return student;
	}
	
	//정보를 받아와서 controller에 리턴
	public List<StudentDTO> getStudentList() {
		List<StudentDTO> ar = null;
		
		try {
			ar = studentDAO.getStudentDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
	
	//인자값 받은정보로 해당 정보 출력
	public StudentDTO getinfo(StudentDTO name) { 
		// dao 에서 정보를 받아와야함 
		try {
			name = studentDAO.getInfoDAO(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			name = null;
		}
		return name;
	}
}
