package characterstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DataMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\503-20\\Desktop\\access_log.txt"));
			// 접속한 아이피를 중복 상관없이 저장하기 위한 자료구조
			ArrayList<String> iplist = new ArrayList<>();
			// 중복 없이 저장하기 위한 Set 만들기
			Set<String> ipset = new HashSet<String>();
			while (true) {
				// 한 줄 읽기
				String line = br.readLine();
				// 읽은 데이터가 없으면 반복문 종료
				if (line == null) {
					break;
				}
				// 공백으로 분할
				String[] ar = line.split(" ");

				iplist.add(ar[0]);
				ipset.add(ar[0]);
				// 중복 아이피가 있는 상태
//				for (String ip : iplist) {
//					System.out.println(ip);
//				}
				// 중복된 아이피는 제거된 상태
				for (String ip : ipset) {
					System.out.println(ip);
				}
			}
		} catch (Exception e) {
			System.out.println("예외 발생: " + e.getMessage());
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
