package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamMain {

	public static void main(String[] args) {
		// try-catch-finally는 각각의 블럭
		// 파일에 바이트 단위로 기록할 수 있는 스트림 변수 생성
		FileOutputStream fos = null;
		try {
			// 예외가 발생할 가능성이 있는 구문
			// 현재 프로젝트 디렉토리에 파일을 생성
			// '새로 만들기' 작업에 해당하는 코드
			// "src./0720byte.txt라고 했으면 src 폴더에 만들어졌을 것이다.
			// 파일 경로 뒤에 , true를 주면 fos.write() 안의 내용을 바꿨을 때 뒤쪽에 이어쓰기로 진행된다.
			// 아무것도 주지 않으면, 내용을 바꿀 경우 원본이 지워지고 새로 써짐.
			fos = new FileOutputStream("./0720byte.txt");
			// 파일에 1바이트 기록
			// 프로그램에 일반적으로 입력할 때 이루어지는 코드
			// fos.write(98);

			// 파일에 바이트 배열을 기록하기
			// byte []ar = {97, 98, 99, 100, 101};
			// fos.write(ar);

			// 문자열을 바이트 배열로 변환해서 기록하기
			// (getBytes 이용.....***중요***)
			String str = "안녕하세요";
			fos.write(str.getBytes());

			// 버퍼의 내용 비우기
			fos.flush();
		} catch (Exception e) {
			// 예외가 발생했을 때 수행할 구문
			System.out.println("파일 입출력 예외: " + e.getMessage());
			// 현재 날짜와 시간 그리고 예외 내용을 로깅한다.
			// 파일에 기록하거나 네트워크를 통해서 서버에 전달한다.
		} finally {
			// 예외 발생 여부에 상관없이 수행
			// 파일에 기록하는 문제면 finally를 작성하고, 그렇지 않을 경우 finally구문은 작성하지 않아도 된다.
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./0720byte.txt");
			// 1바이트 읽어오기
			// int r = fis.read();
			// System.out.println(r);

			// 4바이트 읽기
			// byte [] b = new byte[4];
			// fis.read(b);
			// System.out.println(b);

			// 4바이트씩 전체를 읽기
			// read에 바이트 배열을 대입하면 읽은 개수를 리턴한다
			// 0보다 작거나 같은 값을 리턴하면 읽을 데이터가 없는 것이다.
			while(true) {
				byte [] b = new byte[4];
				int r = fis.read(b);
				// 배열은 toString이 재정의되어있지 않아서 해시코드가 출력된다.
				// System.out.println(b);
				
//				// 코드를 각각 출력한다.(숫자로)
//				for(byte imsi : b) {
//					System.out.println(imsi);
//				}
				
				//문자열로 변환해서 출력하기: new String에 바이트배열을 주면 됨.(**이것도 중요**)
				 System.out.println(new String(b));
				
				if(r <= 0) {
					break;
					// 이렇게 해 주면 4바이트씩 다 읽음.
				}
			}

		} catch (Exception e) {
			System.out.println("파일 읽기 예외 :" + e.getMessage());
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
