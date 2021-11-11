package portifolioOverLap.app;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import java.io.LineNumberReader;
import java.net.URISyntaxException;



import portifolioOverLap.pojo.Portifolio;
import portifolioOverLap.processor.CommandProcessor;
import portifolioOverLap.util.BasicCommandProcessor;
import portifolioOverLap.util.DataUtility;

public class Main 
{
	
	private static  CommandProcessor commandProcessor ;
	
	
	public Main(CommandProcessor cmdP) {
		super();
		commandProcessor = cmdP;
	}

	public Main() {
		commandProcessor = new BasicCommandProcessor();
	}




	public static void main(String[] args) {

		try {
			DataUtility.storeTestData();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String path ="C:\\Users\\Rithuik\\Documents\\test.txt";
		File file = new File(path);
		if (file.exists()) {
			LineNumberReader lnr = null;
			FileReader is = null;
			try 
			{
				is = new FileReader(file);
				lnr = new LineNumberReader(is);

				Portifolio portifolio = new Portifolio();

				lnr.lines().forEach(line -> {
					commandProcessor.processCmd(line, portifolio);

				});

			} catch (IOException exc) {
				exc.printStackTrace();
			} finally {
				try {
					if (lnr != null)
						lnr.close();
					if (is != null)
						is.close();
				} catch (Exception e) {

				}

			}
		}

	}

}
