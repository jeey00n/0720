package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamMain {

	public static void main(String[] args) {
		// try-catch-finally�� ������ ��
		// ���Ͽ� ����Ʈ ������ ����� �� �ִ� ��Ʈ�� ���� ����
		FileOutputStream fos = null;
		try {
			// ���ܰ� �߻��� ���ɼ��� �ִ� ����
			// ���� ������Ʈ ���丮�� ������ ����
			// '���� �����' �۾��� �ش��ϴ� �ڵ�
			// "src./0720byte.txt��� ������ src ������ ��������� ���̴�.
			// ���� ��� �ڿ� , true�� �ָ� fos.write() ���� ������ �ٲ��� �� ���ʿ� �̾��� ����ȴ�.
			// �ƹ��͵� ���� ������, ������ �ٲ� ��� ������ �������� ���� ����.
			fos = new FileOutputStream("./0720byte.txt");
			// ���Ͽ� 1����Ʈ ���
			// ���α׷��� �Ϲ������� �Է��� �� �̷������ �ڵ�
			// fos.write(98);

			// ���Ͽ� ����Ʈ �迭�� ����ϱ�
			// byte []ar = {97, 98, 99, 100, 101};
			// fos.write(ar);

			// ���ڿ��� ����Ʈ �迭�� ��ȯ�ؼ� ����ϱ�
			// (getBytes �̿�.....***�߿�***)
			String str = "�ȳ��ϼ���";
			fos.write(str.getBytes());

			// ������ ���� ����
			fos.flush();
		} catch (Exception e) {
			// ���ܰ� �߻����� �� ������ ����
			System.out.println("���� ����� ����: " + e.getMessage());
			// ���� ��¥�� �ð� �׸��� ���� ������ �α��Ѵ�.
			// ���Ͽ� ����ϰų� ��Ʈ��ũ�� ���ؼ� ������ �����Ѵ�.
		} finally {
			// ���� �߻� ���ο� ������� ����
			// ���Ͽ� ����ϴ� ������ finally�� �ۼ��ϰ�, �׷��� ���� ��� finally������ �ۼ����� �ʾƵ� �ȴ�.
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
			// 1����Ʈ �о����
			// int r = fis.read();
			// System.out.println(r);

			// 4����Ʈ �б�
			// byte [] b = new byte[4];
			// fis.read(b);
			// System.out.println(b);

			// 4����Ʈ�� ��ü�� �б�
			// read�� ����Ʈ �迭�� �����ϸ� ���� ������ �����Ѵ�
			// 0���� �۰ų� ���� ���� �����ϸ� ���� �����Ͱ� ���� ���̴�.
			while(true) {
				byte [] b = new byte[4];
				int r = fis.read(b);
				// �迭�� toString�� �����ǵǾ����� �ʾƼ� �ؽ��ڵ尡 ��µȴ�.
				// System.out.println(b);
				
//				// �ڵ带 ���� ����Ѵ�.(���ڷ�)
//				for(byte imsi : b) {
//					System.out.println(imsi);
//				}
				
				//���ڿ��� ��ȯ�ؼ� ����ϱ�: new String�� ����Ʈ�迭�� �ָ� ��.(**�̰͵� �߿�**)
				 System.out.println(new String(b));
				
				if(r <= 0) {
					break;
					// �̷��� �� �ָ� 4����Ʈ�� �� ����.
				}
			}

		} catch (Exception e) {
			System.out.println("���� �б� ���� :" + e.getMessage());
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
