package com.jang.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// DAO ?? : 데이타 접근 객체

public class WeatherDAO {

	public List<WeatherDTO> getWeathers() throws Exception {
		//파일의 날씨정보들을 읽어와서 파싱한 다음 dto에 담아서 리턴
		System.out.println("WeatherDAO 입니다");
		File file = new File("C:\\study\\weather.txt");
							
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
	
	
//1,서울 , 29.3 - 맑음 - 60
//2,부산 , 33.3 - 흐림 - 90
//3,제주 , 1.3 - 눈 - 30
//4,광주 , 9.3 - 태풍 - 10
//5,대구, 11.1 - 폭염 - 90  
// UTF-8설정하기 -> 톰캣폴더 -> Conf폴더-> server.xml 파일 메모장으로 열어서 8080 으로 찾고 그밑에 파일수정
	
	
	
	public void add(WeatherDTO weatherDTO) throws Exception {
		//size 가져와서 이걸 번호로 입력 -> 순번
		List<WeatherDTO> ar = this.getWeathers();
		// 도시명-기온-상태-습도 가져오기
//		StringBuffer(); ->  문자열을 연결해주는 메서드 -> 사용하기위해 하나의 객체를 만들어 거기에 문자열을 연결해 담는다.
		// 이때 연결할때 append() 메서드를 사용한다.
		// 그리고 toString(); 으로 문자열을 만들어준다.
		StringBuffer sbffer = new StringBuffer();
		Calendar ca = Calendar.getInstance();
		sbffer.append(ca.getTimeInMillis());
		sbffer.append(ar.size()+1);
		sbffer.append("-");
		sbffer.append(weatherDTO.getCity());
		sbffer.append("-");
		sbffer.append(weatherDTO.getGion());
		sbffer.append("-");
		sbffer.append(weatherDTO.getStatus());
		sbffer.append("-");
		sbffer.append(weatherDTO.getHuminity());
		
		
		sbffer.toString();
		System.out.println(sbffer);
		
		// 받아온 StringBuffer로 파일을 저장한다
//		Scanner sc = new Scanner(System.in);
//		System.out.println("파일명을 입력");
		
		File file = new File("C:\\study\\weather.txt");
		
		FileWriter fw = null;
	
		
		try {
			// new FileWriter() | false : 덮어씌운다?? 새로만드는가 ? 알아봐야함 | true : 파일이 똑같은게 있으면 거기에 이어써준다 
			fw = new FileWriter(file, true);
			// \r -> buffer초기화 -> 버퍼에 담긴거 밀어내고 다시 담기위해 다시 뒤로 땡겨옴 -> 왜 ? buffer는 담는용량의 크기가 정해져 있어서
			// 캐리지리턴 : 커서위치를 맨앞에서 리턴시켜주는거 \r 을 안쓰면 커서가 뒤로 가있다.
			fw.write(sbffer + "\r\n");
			fw.flush();
			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
	
	// 파라미터 값 받아와서 해당 번호가 WeatherDTO 랑 맞으면 
	// 파일저장되어있는 num이 맞으면 그 해당 데이터 삭제후
	// 다시 파일 쓰기
	public void delete(WeatherDTO weatherDTO) throws Exception {
		// list불러와서
		// 지울려고 하는 num과 일치하는 것을 리스트에서 삭제
		// list를 파일에 다시 저장
		System.out.println("delete입니다");
		//num = long타입
		File file = new File("C:\\study\\weather.txt");
		
		StringBuffer stbuffer = new StringBuffer();
	
		List<WeatherDTO> ar = this.getWeathers();
		
		StringBuffer stbuffer2 = new StringBuffer();
		
		FileWriter fw = new FileWriter(file, false);
		
		for(WeatherDTO dto1 : ar) {
			if(dto1.getNum() == weatherDTO.getNum()) {
				ar.remove(dto1);
				break;
			}
		}
		
		//ar 을 파일에 작성
		StringBuffer stringBuffer = new StringBuffer();
		for(WeatherDTO dto1: ar) {
			stbuffer2.append(dto1.getNum());
			stbuffer2.append("-");
			stbuffer2.append(dto1.getCity());
			stbuffer2.append("-");
			stbuffer2.append(dto1.getGion());
			stbuffer2.append("-");
			stbuffer2.append(dto1.getStatus());
			stbuffer2.append("-");
			stbuffer2.append(dto1.getHuminity());
			stbuffer2.append("\r\n");
		}
		
		fw.write(stringBuffer.toString() + "\r\n");
		fw.flush();
		
//		FileWriter fw2 = null;
//		for(int i=0; i<ar.size(); i++) {
//			WeatherDTO wedto = ar.get(i);	
//	
//			if(weatherDTO.getNum() == wedto.getNum()) {
//				stbuffer.append(ar.size()+1);
//				stbuffer.append("-");
//				stbuffer.append(wedto.getCity());
//				stbuffer.append("-");
//				stbuffer.append(wedto.getGion());
//				stbuffer.append("-");
//				stbuffer.append(wedto.getStatus());
//				stbuffer.append("-");
//				stbuffer.append(wedto.getHuminity());
//				
//				stbuffer.toString();
//				
//				FileWriter fw = new FileWriter(file, false);
//				fw.write(stbuffer + "\r\n");
//				fw.flush();
//				fw.close();
//				
//				System.out.println("끝끝끝끝끝끝끝끝끝끝끝끝끝끝");
//				break;
//			}
//		}
//		
//		fw2 = new FileWriter(file, true);
//		fw2.write(stbuffer2 + "\r\n" + stbuffer + "\r\n");
//		fw2.flush();
//		fw2.close();
		
		System.out.println("종료종료종료");
	}
	
	public void update(WeatherDTO weatherDTO) {
		
		WeatherDTO wdto = new WeatherDTO();
		
		if(weatherDTO.getNum() == wdto.getNum()) {
			System.out.println("들어옴?");
			
		}
	}
}
