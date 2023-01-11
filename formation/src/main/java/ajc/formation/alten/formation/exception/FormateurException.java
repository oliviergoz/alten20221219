package ajc.formation.alten.formation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FormateurException extends RuntimeException {
	public FormateurException() {

	}

	public FormateurException(String message) {
		super(message);
	}
}
