package com.jang.home.weather;

import java.util.List;

public class WeatherService {
	// Service : 데이타 전처리 후처리 하는 작업
	private WeatherDAO weatherDAO;
	
	public WeatherService() {
		weatherDAO = new WeatherDAO();
	}
	
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
}

// 1. 각 url에 맞는 jsp로 연결
// 2. /weather/list/getWeatheres 실행
// 3. 실행하면 테이블에 위에내용 도시 온도 상태 습도 정보 보이게하기 | 4행 / 4열