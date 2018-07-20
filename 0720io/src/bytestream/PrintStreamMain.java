package bytestream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamMain {

	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("./0720print.txt"), true);
			ps.println("�ݰ����ϴ�.");
			ps.println("�ٷ� �ٷ� ó���մϴ�.");
			ps.println("append�� ���� true�����Դϴ�.");
			ps.flush();
		} catch (Exception e) {
			System.out.println("���� ���� ����: " + e.getMessage());
		} finally {
			if (ps != null)
				ps.close();
		}
	}
}
