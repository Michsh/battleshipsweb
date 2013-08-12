package battleshipsweb.exceptions;

public class CannotSaveMultipartException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CannotSaveMultipartException() {
		
		super();
	}

	public CannotSaveMultipartException(String msg) {
		
		super(msg);
	}
	
	public CannotSaveMultipartException(Exception e) {
		
		super(e);
	}
}
