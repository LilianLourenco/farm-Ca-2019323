package ie.cct.farmCa2019323;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
//@ResponseStatus(Code = HttpStatus.NOT_ACCEPTABLE);
public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977025759903730969L;
	
	public NotFoundException(String msg) {
		super(msg);
	}
	

}
 