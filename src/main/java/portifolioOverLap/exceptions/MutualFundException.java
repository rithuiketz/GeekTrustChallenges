package portifolioOverLap.exceptions;

public class MutualFundException
{

	private static final long serialVersionUID = 1L;

	
	public static class MutualFundExistsException extends Exception
	{
	
		private static final long serialVersionUID = 1L;

		public String getMessage() {
			// TODO Auto-generated method stub
			return "Instrument Already Exists";
		}
	}
	
	public static class MutualFundNotExistsException extends Exception
	{
		
		private String fundName;
		
		
	
		public MutualFundNotExistsException(String fundName) {
			super();
			this.fundName = fundName;
		}
		
		public MutualFundNotExistsException() {
			super();
		}


		private static final long serialVersionUID = 1L;

		public String getMessage() {
			// TODO Auto-generated method stub
			return "FUND_NOT_FOUND";
		}
	}

	

}
