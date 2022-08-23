package example1;

public class AOPMain {
	
	public static void main(String[] args) {
		
		Board b = new Board();
		
		Order o = new Order();
		
		b.board();
		System.out.println();
		o.order();
	}
	
	
}
