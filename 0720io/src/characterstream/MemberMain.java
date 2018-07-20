package characterstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MemberMain {

	public static void main(String[] args) {
		// Ű����κ��� �� ������ �Է¹��� �� �ִ� Ŭ������ ������ ���� ����
		// finally������ close�� �� �� �ֵ��� try �ۿ��� ���� ����
		BufferedReader br = null;
		try {
			// Ű����κ��� �Է¹��� �� �ִ� �ν��Ͻ� ����
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("�̸�: ");
			// ���ڿ� �� ���� �о����
			String name = br.readLine();

			System.out.print("����: ");
			String age = br.readLine();

			System.out.print("Ű: ");
			String height = br.readLine();

			// 3���� �����͸� �ϳ��� �����ϱ� ���� �ν��Ͻ� ����
			Member member = new Member();
			member.setName(name);
			// ������ ��ȯ�ؼ� ����
			member.setAge(Integer.parseInt(age));
			// �Ǽ��� ��ȯ�ؼ� ����
			member.setHeight(Double.parseDouble(height));

			// ���� �̿��ؼ� ����
			Map<String, Object> map = new HashMap<>();
			map.put("name", name);
			map.put("age", Integer.parseInt(age));
			map.put("height", Double.parseDouble(height));

			// ����� ���� VOŬ������ Map�̳� �� ���� ����.
			System.out.println(member);
			System.out.println(map);

			// �ν��Ͻ� ���� �� .�� ������ getAge�� �ٷ� �����µ� map���� ���� key���� ���� �Է������ �ش� �����͸� ������ �� ����.
			member.getAge();
			map.get("age");

			// ����� ���� ���� �ٸ���. ���̸� 1�� ���غ���. VOŬ������ ���������Ϳ��� �ٷ� ������ ���� �� �ִ�.
			int r = member.getAge() + 1;
			// Map������ �����͸� �����ͼ� ����� ���� ���� ����ȯ�� �ؾ� �Ѵ�.
			// r = map.get("age") + 1; // �� �ڵ�� ���������� �߻��Ѵ�.
			r = (Integer) map.get("age") + 1;

			
		} catch (Exception e) {
			System.out.println("����: " + e.getMessage());
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
