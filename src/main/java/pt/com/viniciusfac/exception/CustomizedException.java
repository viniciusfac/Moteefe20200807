package pt.com.viniciusfac.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomizedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CustomizedException(String exception) {
		super(exception);
	}
	
}
