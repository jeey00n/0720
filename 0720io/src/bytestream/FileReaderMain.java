package bytestream;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {

	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("C:\\Users\\503-20\\eclipse-workspace\\0720io\\0720.txt");
			char[] buf = new char[30];
//			fr.read(buf);
//			for(char ch : buf) {
//				System.out.println(ch);
//			}
//			System.out.println(new String(buf));

			while (true) {
				// buf의 크기만큼 읽어서 buf에 저장하고, 읽은 개수를 r에 저장한다.
				int r = fr.read(buf);
				if (r <= 0) {
					break;
				}
				// 배열에서 0번째부터 r만큼만 문자열로 변환해서 출력
				System.out.println(new String(buf, 0, r));
			}

		} catch (Exception e) {
			System.out.println("예외: " + e.getMessage());
		} finally {
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
