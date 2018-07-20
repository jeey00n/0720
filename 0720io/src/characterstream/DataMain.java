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
			// ������ �����Ǹ� �ߺ� ������� �����ϱ� ���� �ڷᱸ��
			ArrayList<String> iplist = new ArrayList<>();
			// �ߺ� ���� �����ϱ� ���� Set �����
			Set<String> ipset = new HashSet<String>();
			while (true) {
				// �� �� �б�
				String line = br.readLine();
				// ���� �����Ͱ� ������ �ݺ��� ����
				if (line == null) {
					break;
				}
				// �������� ����
				String[] ar = line.split(" ");

				iplist.add(ar[0]);
				ipset.add(ar[0]);
				// �ߺ� �����ǰ� �ִ� ����
//				for (String ip : iplist) {
//					System.out.println(ip);
//				}
				// �ߺ��� �����Ǵ� ���ŵ� ����
				for (String ip : ipset) {
					System.out.println(ip);
				}
			}
		} catch (Exception e) {
			System.out.println("���� �߻�: " + e.getMessage());
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
