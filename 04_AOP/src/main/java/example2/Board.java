package example2;

public class Board {
	
	public void board() {
		String msg = "�Խù� ���";
		
		/*
		 * Login l = new Login(); 
		 * l.login(msg);
		 */
		Login.login(msg); // static���� �Ǿ��־ ����
		
		System.out.println(msg+"�ϱ�");
		
		Logout.logout(msg);
	}
}