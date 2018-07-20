package characterstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MemberMain {

	public static void main(String[] args) {
		// 키보드로부터 줄 단위로 입력받을 수 있는 클래스의 참조형 변수 선언
		// finally절에서 close를 할 수 있도록 try 밖에서 변수 선언
		BufferedReader br = null;
		try {
			// 키보드로부터 입력받을 수 있는 인스턴스 생성
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("이름: ");
			// 문자열 한 줄을 읽어오기
			String name = br.readLine();

			System.out.print("나이: ");
			String age = br.readLine();

			System.out.print("키: ");
			String height = br.readLine();

			// 3개의 데이터를 하나로 저장하기 위한 인스턴스 생성
			Member member = new Member();
			member.setName(name);
			// 정수로 변환해서 저장
			member.setAge(Integer.parseInt(age));
			// 실수로 변환해서 저장
			member.setHeight(Double.parseDouble(height));

			// 맵을 이용해서 저장
			Map<String, Object> map = new HashMap<>();
			map.put("name", name);
			map.put("age", Integer.parseInt(age));
			map.put("height", Double.parseDouble(height));

			// 출력할 때는 VO클래스나 Map이나 별 차이 없다.
			System.out.println(member);
			System.out.println(map);

			// 인스턴스 생성 시 .을 찍으면 getAge가 바로 나오는데 map같은 경우는 key값을 직접 입력해줘야 해당 데이터를 가져올 수 있음.
			member.getAge();
			map.get("age");

			// 사용할 때는 조금 다르다. 나이를 1씩 더해보자. VO클래스의 정수데이터에는 바로 정수를 더할 수 있다.
			int r = member.getAge() + 1;
			// Map에서는 데이터를 가져와서 사용할 때는 강제 형변환을 해야 한다.
			// r = map.get("age") + 1; // 이 코드는 구문에러가 발생한다.
			r = (Integer) map.get("age") + 1;

			
		} catch (Exception e) {
			System.out.println("예외: " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
