package portifolioOverLap.processor;

import portifolioOverLap.pojo.Portifolio;

public interface CommandProcessor 
{
	public void processCmd(String line,Portifolio portifolio);
	
	public  void createMutualFund(String line); 
	
	public  void calculateOverlap(String line, Portifolio portifolio);
	
	public  void handleAddStock(String line);
	
	public  void handleCurrentPortifolio(String line, Portifolio portifolio);
}
