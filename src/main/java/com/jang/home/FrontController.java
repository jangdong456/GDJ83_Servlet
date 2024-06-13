package com.jang.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jang.home.student.StudentController;
import com.jang.home.weather.WeatherController;

/**
 * Servlet implementation class HomeController
 */
// 모든 url 요청은 FrontController 로 간다 | 왜 ? web.xml에서 url이 오면 여기로 오라고 서블릿으로 지정해놔서
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("실행 됨");
		
		String uri = request.getRequestURI();
		String method = request.getMethod();
		
		
		if(!uri.equals("/favicon.ico")) {
			String[] p = uri.split("/");
//			System.out.println(uri);
//			System.out.println(method);
			
//			1.substring 이용방식
//			String path = uri.substring(1,uri.lastIndexOf("/"));
			
//			2.split 이용방식

			
			String path = "";
			Action action = new Action();
			
			if(uri.equals("/")) {
				action.setFlag(true);
				action.setPath("/WEB-INF/views/index.jsp");
//				path = "WEB-INF/views/index.jsp";
				
			}else if (p[1].equals("student")) {
				StudentController sc = new StudentController();
				action = sc.start(request);

			}else if (p[1].equals("weather")) {
				WeatherController wc = new WeatherController();
				action = wc.start(request);

			} 
			
			//jsp 정보로 넘기는 코드 | action.getPath() -> jsp경로
			if(action.isFlag()) {
				RequestDispatcher view = request.getRequestDispatcher(action.getPath()); 
				view.forward(request, response);
			} else {
				response.sendRedirect(action.getPath());
			}
		} 
		
		//  여긴 무조건 절대경로 써야함 getRequestDispatcher -> jsp로 이동하자 라는 의미
//		RequestDispatcher view = request.getRequestDispatcher(action.getPath());
		
		//forward를 이용해서 "/WEB-INF/views/index.jsp" 경로에있는 데이터를 가져옴 -> jsp가 html로 만들어서 응답으로 요청한거에 보냄
//		view.forward(request, response);
			
//			3.StringTokenizer 이용방식
//			StringTokenizer infoUri = new StringTokenizer(uri,"/");
//			
////			String path = "";
//			
//			Action action = new Action();
//				
//				String ui = infoUri.nextToken();
//	
//				if(ui.equals("student")) {
//					StudentController sc = new StudentController();
//					action = sc.start(request);
//					
//					sc.start(request);
////					path = "/WEB-INF/views/student/list.jsp";
//					
//					
//				}else if(ui.equals("weather")){
//					WeatherController wc = new WeatherController();
////					action = wc.start(request);
//					
////					path = "/WEB-INF/views/weather/list.jsp";
////					wc.start(request);
//					
//					
//				}else if(ui.equals("/")) {
//					action.setFlag(true);
//					action.setPath("WEB-INF/views/index.jsp");
//				
////					path = "/WEB-INF/views/index.jsp";
//				}
				
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
