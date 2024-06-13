package com.jang.home.student;

public class TestMain {

	public static void main(String[] args) {
		StudentDAO sDao = new StudentDAO();
		StudentService sv = new StudentService();
		sv.getStudentList();
//		sv.getinfo();
		
		try {
			sDao.getStudentDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
