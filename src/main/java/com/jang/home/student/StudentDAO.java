package com.jang.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	//파일을 읽어와야됨
	
	public List<StudentDTO> getStudentDAO() throws Exception {
		File file = new File("C:\\study\\student.txt");
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		
		boolean flag = true;
		
		while(flag) {
			String s = br.readLine();
	
			if(s == null) {
				break;
			}
			
			StudentDTO studentdto = new StudentDTO();
			String[] ar = s.split("-");
			
			studentdto.setNum(Integer.parseInt(ar[0].trim()));
			studentdto.setName(ar[1].trim());
			studentdto.setKor(Integer.parseInt(ar[2].trim()));
			studentdto.setEng(Integer.parseInt(ar[3].trim()));
			studentdto.setMath(Integer.parseInt(ar[4].trim()));
			studentdto.setTotal(Integer.parseInt(ar[5].trim()));
			studentdto.setAvg(Double.parseDouble(ar[6].trim()));
			
			list.add(studentdto);
		}
		br.close();
		fr.close();

		return list;
	}
	
	//인자갑을 받아와서 맞는지 확인하고 그 정보를 넘겨주기
	public StudentDTO getInfoDAO(StudentDTO name) throws Exception {
		// 무엇과 비교?? -> StudnetDTO 와 인자값
		// DTO에 담겨져 있는 곳은 ? -> arraylist
		List<StudentDTO> ar = this.getStudentDAO();
		
		StudentDTO sDto = null;
		
		for(StudentDTO s : ar) {
			if(s.getName() == name.getName()) {
				sDto = s;
				break;
			}
		}
		return sDto;
	}
}
