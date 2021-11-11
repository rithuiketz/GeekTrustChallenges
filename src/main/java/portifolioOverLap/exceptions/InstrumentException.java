package portifolioOverLap.exceptions;

public class InstrumentException
{

	private static final long serialVersionUID = 1L;

	
	public static class InstrumentExistsException extends Exception
	{
	
		private static final long serialVersionUID = 1L;

		public String getMessage() {
			// TODO Auto-generated method stub
			return "Instrument Already Exists";
		}
	}
	
	public static class InstrumentAlreadyMappedException extends Exception
	{
	
		private static final long serialVersionUID = 1L;

		public String getMessage() {
			// TODO Auto-generated method stub
			return "Instrument Already Associated with Mf";
		}
	}
	
	public static class InstrumentDoesntExistsException extends Exception
	{
	
		private static final long serialVersionUID = 1L;

		public String getMessage() {
			// TODO Auto-generated method stub
			return "InstrumentDoesntExistsException";
		}
	}
	

}
