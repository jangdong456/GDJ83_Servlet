package com.jang.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// DAO ?? : 데이타 접근 객체

public class WeatherDAO {

	public List<WeatherDTO> getWeathers() throws Exception {
		//파일의 날씨정보들을 읽어와서 파싱한 다음 dto에 담아서 리턴
		System.out.println("WeatherDAO 입니다");
		File file = new File("C:\\study", "weather.txt");
							
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();
		
		boolean flag = true;
		
		while(flag) {
			String info = br.readLine();
			info = info.replace(",", "-");
			
			if(info == null) {
				break;
			}
		
			StringTokenizer st = new StringTokenizer(info,",");
			
			WeatherDTO wDto = new WeatherDTO();
			
			while(st.hasMoreTokens()) {
//				wDto.setNum(Long.parseLong(st.nextToken().trim()));
				wDto.setCity(st.nextToken().trim());
				wDto.setGion(Double.parseDouble(st.nextToken().trim()));
				wDto.setStaus(st.nextToken().trim());
				wDto.setHuminity(Integer.parseInt(st.nextToken().trim()));
				
			}
			ar.add(wDto);
		}
		br.close();
		fr.close();
		
		return ar;	
	}
}
