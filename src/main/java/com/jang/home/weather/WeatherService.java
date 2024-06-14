package com.jang.home.weather;

import java.util.List;

// Service : 데이타 전처리 후처리 하는 작업
public class WeatherService {
	
	
	//DAO 클래스를 이용하려고 밑에 생성자와 변수를 만듬
	private WeatherDAO weatherDAO;
	
	public WeatherService() {
		weatherDAO = new WeatherDAO();
	}
	
	// list 가져올 메서드
	public List<WeatherDTO> getWeathers() {
		List<WeatherDTO> ar = null;
		
		try {
			ar = weatherDAO.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return ar;
	}
	
	//detail parameter 값  WeatherDTO weatherDTO
	public WeatherDTO getDetail(WeatherDTO weatherDTO) {
		try {
			weatherDTO = weatherDAO.getDetail(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			weatherDTO = null;
		}
		
		return weatherDTO;
		
	}
	
	public void add(WeatherDTO weatherDTO) {
		try {
			weatherDAO.add(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

