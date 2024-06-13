package com.jang.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

// DAO ?? : 데이타 접근 객체

public class WeatherDAO {

	public List<WeatherDTO> getWeathers() throws Exception {
		//파일의 날씨정보들을 읽어와서 파싱한 다음 dto에 담아서 리턴
		System.out.println("WeatherDAO 입니다");
		File file = new File("C:\\study", "weather.txt");
							
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
	
		ArrayList<WeatherDTO> list = new ArrayList<WeatherDTO>();

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}
			WeatherDTO weatherDTO = new WeatherDTO();
			
			// replace() : 변경할 값 , 변경될 값 | , -> -  쉼표에서 막대기로  
			s = s.replace(",", "-");
			String[] ar = s.split("-");
			weatherDTO.setNum(Long.parseLong(ar[0].trim()));
			weatherDTO.setCity(ar[1].trim());
			weatherDTO.setGion(Double.parseDouble(ar[2].trim()));
			weatherDTO.setStatus(ar[3].trim());
			weatherDTO.setHuminity(Integer.parseInt(ar[4].trim()));
			list.add(weatherDTO);
		}
		br.close();
		fr.close();
		
		return list;	
	}
	
	// detail  요청한 값을 받아서 찾는 정보를 꺼내와서 리턴
	// 인자값(weatherDTO)을 받은것은 WeatherDTO.num 값이다 그래서 이 값을 비교 
	// 즉 인자값은 데이터타입을 참고해서 코드를 활용할수 있음.
	public WeatherDTO getDetail (WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		
		// null면 없는거 null이 아니면 찾는 정보가 있는거
		WeatherDTO result = null;
		
		for(WeatherDTO w : ar) {
			if(w.getNum()== weatherDTO.getNum()) {
				result = w;
				break;
			}
		}
		return result;

	}
}


//      boolean flag = true;		
//		while(flag) {
//			String info = br.readLine();
//			info = info.replace(",", "-");
//			
//			if(info == null) {
//				break;
//			}
//		
//			StringTokenizer st = new StringTokenizer(info,",");
//			
//			WeatherDTO wDto = new WeatherDTO();
//			
//			while(st.hasMoreTokens()) {
//				wDto.setNum(Long.parseLong(st.nextToken().trim()));
//				wDto.setCity(st.nextToken().trim());
//				wDto.setGion(Double.parseDouble(st.nextToken().trim()));
//				wDto.setStatus(st.nextToken().trim());
//				wDto.setHuminity(Integer.parseInt(st.nextToken().trim()));
//				
//				list.add(wDto);
//			}
		//br.close();
		//fr.close();
		//
		//return list;
//		}



