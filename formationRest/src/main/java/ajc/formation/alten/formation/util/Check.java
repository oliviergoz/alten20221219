package ajc.formation.alten.formation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

public class Check {
	
	private final static Logger LOGGER=LoggerFactory.getLogger(Check.class);
	
	public static void checkBindingResulHasError(BindingResult br) {
		
		LOGGER.info(br.toString());
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
