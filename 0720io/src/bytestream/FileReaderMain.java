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
				// buf�� ũ�⸸ŭ �о buf�� �����ϰ�, ���� ������ r�� �����Ѵ�.
				int r = fr.read(buf);
				if (r <= 0) {
					break;
				}
				// �迭���� 0��°���� r��ŭ�� ���ڿ��� ��ȯ�ؼ� ���
				System.out.println(new String(buf, 0, r));
			}

		} catch (Exception e) {
			System.out.println("����: " + e.getMessage());
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
