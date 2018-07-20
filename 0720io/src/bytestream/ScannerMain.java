package bytestream;

import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		//키보드로부터 입력받는 Scanner 인스턴스 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int x = sc.nextInt();
		System.out.println(x);
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.println(name);
		sc.close();
		//정수 입력 -> 정수 출력 -> 문자 입력 불가능.
	}

}
