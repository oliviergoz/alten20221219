package springAspect.beans;

import org.springframework.stereotype.Component;

@Component
public class MonBean implements MonInterface {

	public String methodeDeMonBean() {
		System.out.println("dans la methode");
		// throw new IllegalArgumentException();
		return "hello world";
	}
}
