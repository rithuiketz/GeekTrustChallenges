package portifolioOverLap.exceptions;

public class DataStoreException extends Exception {

	private String message;

	public DataStoreException(String message) {

		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.getMessage();
	}

}
