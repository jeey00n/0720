package bytestream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamMain {

	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("./0720print.txt"), true);
			ps.println("반갑습니다.");
			ps.println("바로 바로 처리합니다.");
			ps.println("append가 현재 true상태입니다.");
			ps.flush();
		} catch (Exception e) {
			System.out.println("파일 쓰기 예외: " + e.getMessage());
		} finally {
			if (ps != null)
				ps.close();
		}
	}
}
