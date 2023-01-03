package musique.beans;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import musique.exception.FausseNoteException;

@Component
@Aspect
public class Spectateur {

	@Autowired
	@Qualifier("pianiste")
	private Musicien pianiste;

	@Pointcut("execution(* musique.beans.Musicien.jouerInstrument())")
	public void jouerMusicien() {

	}

	@Pointcut("execution(* musique.beans.Pianiste.jouerInstrument())")
	public void jouerPianiste() {

	}

	@After("jouerPianiste()")
	public void allumerTelephone() {
		System.out.println("telephone allume");
	}

	@Pointcut("execution(* musique.beans.Guitariste.jouerInstrument())")
	public void jouerGuitariste() {

	}

	@After("jouerGuitariste()")
	public void onDemandeLePianiste() {
		pianiste.jouerInstrument();
	}

	@Before("jouerGuitariste()")
	public void couperTelephone() {
		System.out.println("telephone eteind");
	}

	@AfterReturning(pointcut = "jouerMusicien()")
	public void applaudir() {
		System.out.println("bravo");
	}

	@AfterThrowing(pointcut = "jouerMusicien()", throwing = "musique.exception.FausseNoteException")
	public void siffler() {
		System.out.println("bouhh");
	}
}
