package musique;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import musique.beans.Guitariste;
import musique.beans.Musicien;
import musique.config.AppConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		ctx.close();
	}
}
