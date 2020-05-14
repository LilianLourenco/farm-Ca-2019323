package ie.cct.farmCa2019323;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptable extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1486162109004200424L;
	
	public NotAcceptable(String msg) {
		super(msg);
	}

}
