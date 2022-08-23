package myPkg3;

import org.springframework.stereotype.Component;

@Component("Morning")
public class Morning implements Car{

	public Morning() {
		System.out.println("Morning");
	}
	
	
	@Override
	public String drive() {
		return "Morning-drive";
	}

}
