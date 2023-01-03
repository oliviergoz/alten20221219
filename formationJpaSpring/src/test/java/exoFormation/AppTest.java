package exoFormation;

import exoFormation.util.JpaContext;

public class AppTest {
	public static void main(String[] args) {
		JpaContext.getEntityManagerFactory();
		JpaContext.destroy();
	}
}
