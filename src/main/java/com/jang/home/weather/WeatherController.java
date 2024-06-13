package com.jang.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jang.home.Action;

public class WeatherController {
	// controller 역할 : 어떤 uri이 왔을때 어떤 jsp로 보낼것이냐
	
	//Service 클래스를 이용하려고 밑에 생성자와 변수를 만듬
	private WeatherService ws;


	public WeatherController() {
		ws = new WeatherService();
		
	}
	
	
	public Action start(HttpServletRequest request) {			
		
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);

		Action action = new Action();
		action.setFlag(true);
		
		if(uri.equals("list")) {
				
			List<WeatherDTO> ar = ws.getWeathers();
			request.setAttribute("list", ar);
			// jsp의 경로
			action.setPath("/WEB-INF/views/weather/list.jsp");

		}else if(uri.equals("add")) {
			action.setPath("/WEB-INF/views/weather/add.jsp");
			
		}else if(uri.equals("delete")) {
			
		}else if(uri.equals("detail")) {
		
			// client에서 parmeter값을 꺼낸후 DTO에 저장
			String num = request.getParameter("num");
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setNum(Long.parseLong(num));
			
			weatherDTO = ws.getDetail(weatherDTO);
			
			if(weatherDTO != null) {
				request.setAttribute("dto", weatherDTO);
				action.setPath("/WEB-INF/views/weather/detail.jsp");
			}else {
				request.setAttribute("msg", "정보가 없습니다");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}
			
			
		}else {
			
		}
		
		return action;

	}
	
	
}
