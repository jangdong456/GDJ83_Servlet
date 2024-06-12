package com.jang.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jang.home.Action;

public class WeatherController {
	// controller 역할 : 어떤 uri이 왔을때 어떤 jsp로 보낼것이냐
	
	private WeatherService weatherService;


	public WeatherController() {
		weatherService = new WeatherService();
	}
	
	
	public Action start(HttpServletRequest request) {			
		WeatherService ws = new WeatherService();
		
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);

		
		Action action = new Action();
		action.setFlag(true);
		
		if(uri.equals("list")) {
			List<WeatherDTO> ar = ws.getWeathers();
			
			
			request.setAttribute("list", ar);
			
			// jsp의 경로
			action.setPath("/WEB-INF/views/weather/list.jsp");
			System.out.println("list입니다.");

			
		}else if(uri.equals("add")) {
			action.setPath("/WEB-INF/views/weather/add.jsp");
			System.out.println("add입니다.");
		}else if(uri.equals("delete")) {
			System.out.println("delete입니다.");
		}else if(uri.equals("detail")) {
			
			action.setPath("/WEB-INF/views/weather/detail.jsp");
			System.out.println("detail입니다.");
		}else {
			
		}
		
		return action;

	}
	
	
}
