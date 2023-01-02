package springAspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonAspect {

	// @Pointcut("execution(public String
	// springAspect.beans.MonBean.methodeDeMonBean())")
	@Pointcut("execution(* springAspect.beans.*.methodeDeMonBean())")
	public void interceptMethodeDeMonBean() {

	}

	// execution(<scope optionel> <typeRetour> <NomClasseComplet>.<methode>(<args>)
	// )
	// @Before("execution(public void
	// springAspect.beans.MonBean.methodeDeMonBean())")
	@Before("interceptMethodeDeMonBean()")
	public void before(JoinPoint joinPoint) {
		// joinPoint.getTarget()
		System.out.println("avant execution");
	}

	// @After("execution(public void
	// springAspect.beans.MonBean.methodeDeMonBean())")
	@After("interceptMethodeDeMonBean()")
	public void after() {
		System.out.println("apres execution");
	}

	@AfterReturning(pointcut = "interceptMethodeDeMonBean()", returning = "nomDuParametreQuiVaRecupererLeRetour")
	public void apresSucces(String nomDuParametreQuiVaRecupererLeRetour) {
		// si pas d'exception
		System.out.println("ok, valeur recuperee:" + nomDuParametreQuiVaRecupererLeRetour);
	}

	@AfterThrowing("interceptMethodeDeMonBean()")
	public void apresException() {
		System.out.println("exception");
	}

	@Around("interceptMethodeDeMonBean()")
	public String around(ProceedingJoinPoint pJP) throws Throwable {
		// avant la methode
		// String texte="bonne annee";
		System.out.println("avant l'execution de la methode interceptee");
		// execution de la methode interceptee
		String texte = (String) pJP.proceed();
		return texte;
	}
}
