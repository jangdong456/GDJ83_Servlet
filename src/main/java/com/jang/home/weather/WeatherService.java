package com.jang.home.weather;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherService {
	
	private StringBuffer sb;
	
	public WeatherService() {
		this.sb = new StringBuffer();

		this.sb.append("서울 , 29.3 - 맑음 - 60");
		this.sb.append("-부산 , 33.3 - 흐림 - 90");
		this.sb.append("-제주 , 1.3 - 눈 - 30");
		this.sb.append("-광주 , 9.3 - 태풍 - 10");
	}
	
	
	public List<WeatherDTO> getWeathers() {
		String info = sb.toString();
		info = info.replace(",", "-");

		StringTokenizer st = new StringTokenizer(info, "-");
		
		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();
		
		while(st.hasMoreTokens()) {
			WeatherDTO weatherDto = new WeatherDTO();
			weatherDto.setCity(st.nextToken().trim());
			weatherDto.setGion(Double.parseDouble(st.nextToken().trim()));
			weatherDto.setStaus(st.nextToken().trim());
			weatherDto.setHuminity(Integer.parseInt(st.nextToken().trim()));
			
			ar.add(weatherDto);
		}
		return ar;
	}
}

// 1. 각 url에 맞는 jsp로 연결
// 2. /weather/list/getWeatheres 실행
// 3. 실행하면 테이블에 위에내용 도시 온도 상태 습도 정보 보이게하기 | 4행 / 4열