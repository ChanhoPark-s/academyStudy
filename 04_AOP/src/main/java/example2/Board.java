package example2;

public class Board {
	
	public void board() {
		String msg = "게시물 등록";
		
		/*
		 * Login l = new Login(); 
		 * l.login(msg);
		 */
		Login.login(msg); // static으로 되어있어서 가능
		
		System.out.println(msg+"하기");
		
		Logout.logout(msg);
	}
}
