package com.jang.home.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jang.home.Action;


public class StudentController {
	
	private StudentService studentService;
	
	//내부 이용방법
	public StudentController() {
		this.studentService = new StudentService();
	}
	
	//외부 매개변수 이용방법
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	//action을 리턴 
	//action : 경로리턴 하는 값
	public Action start(HttpServletRequest request) {
		
		String path = request.getRequestURI();
		
		// substring() : 으로 인덱스 번호로 문자열을 가져옴  | lastIndexOf()로 마지막 어떤걸 가져올거냐 라는 메서드 
		// aaaa/bbbb/cccc/ddd => /ddd 에서 /는 0번 인덱스 ddd는 1번 인덱스
		path = path.substring(path.lastIndexOf("/")+1);
		
		Action action = new Action();
		action.setFlag(true);
		
		//request.getMethod()는 무조건String 으로 온다.
		String method = request.getMethod();
		
		
		// 경로가 맞으면 jsp 경로를 반환하고, 값을 request에 보내려고 만든 if문
		if(path.equals("list")) {
			List<Student> ar = studentService.getStudents();
			
			// jsp 페이지로 넘겨주기 위해서 request.setAttribute("이름", 보내줄 값) 를 사용한다.
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/student/list.jsp");
			
			
		}else if (path.equals("add")) {
			// toUpperCase() : 대문자로 변경
			if(method.toUpperCase().equals("POST")) {
				Student student = new Student();
				
//				System.out.println("학생등록 데이터를 꺼내야함");
				//client 받은 파라미터 값을 받아서 -> dto를 넣는다. | set이용
				String name = request.getParameter("name");
				String num = request.getParameter("num");
				String avg = request.getParameter("avg");
				
				//Integer.parseInt | Double.parseDouble 로 String 값을 형변환 시켜준다. 
				student.setName(name);
				student.setNum(Integer.parseInt(num));
				student.setAvg(Double.parseDouble(avg));
				
//				System.out.println(request.getParameter("ch"));
//				System.out.println(request.getParameter("mobile"));

				
				//dto에 잘 담겼나 프린트
//				System.out.println(student.getName());
				
				// 값이 여러개 있을떄 배열 사용
				// getParameterValues() : client에서 보낸 Parameter 값이 무엇인지 꺼내려고 하는 메서드 
				// "ch2"는 { key, value } 형태로 오는데 key의 이름을 임의로 정한거다.
				String[] ch2 = request.getParameterValues("ch2");
				
				//향상된 for문 
				// for(데이터타입 변수명(아무거나): for문 돌릴 값){}
				for(String s: ch2) {
					System.out.println(s+"aaaaaaaaaaa");
				}
				
				action.setFlag(true);
				action.setPath("./list");
				
			}else {
				action.setPath("/WEB-INF/views/student/add.jsp");
				
			}
			
		}else if (path.equals("detail")) {
			
			Student stduent = this.studentService.makeStudent();
//			request.setAttribute(s, student)
			request.setAttribute("student", stduent);
			action.setPath("/WEB-INF/views/student/detail.jsp");
//			request.setAttribute("name", name);
//			request.setAttribute("avg", avg);
			
		} else {
			
		}
		
		return action;
	
	} 
	
	
	
	
	
//	public Action start(HttpServletRequest request) {
//		// boolean / string = action타입
//		// /student/???
//		// list -> 학생정보전체출력
//		// add  -> 학생한명정보추가
//		// delete -> 학생한명삭제
//		// detail -> 학생한명정보 출력
//		
////		System.out.println(request.getRequestURI());
//		
//		
//		
//		String path = request.getRequestURI();
//		
////		path = path.substring(path.lastIndexOf("/")+1);
//		
//		StringTokenizer st = new StringTokenizer(path, ("/")+1);
//		
//		Action action = new Action();
//		action.setFlag(true);
//		
//		while(st.hasMoreTokens()) {
//			String ui = st.nextToken();
//
//			if(ui.equals("list")) {
//				System.out.println("여긴 list");
//				action.setPath("/WEB-INF/views/student/list.jsp");
//			}else if(ui.equals("add")) {
//				System.out.println("여긴 add");
//				action.setPath("/WEB-INF/views/student/add.jsp");
//			}else if(ui.equals("delete")) {
//				System.out.println("여긴 delete");
//			}else if(ui.equals("detail")) {
//				System.out.println("여긴 detail");
//				action.setPath("/WEB-INF/views/student/detail.jsp");
//			}break;
//			
//		}
//		
//		return action;
//
//
//	}
}
