import java.util.Collection;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import com.app.dto.InputData;
import com.app.utils.chipper.ChipperUtils;
import com.app.utils.data.BasicTextReader;
import com.app.utils.data.DataReader;


public class BasicTest {
	
	private static final String PATH="D:/test_text";

    @Test
    @Ignore
    public void testReader() {
        DataReader reader = new BasicTextReader();
        Collection<InputData> data = reader.read(PATH);
        Assert.assertTrue(!data.isEmpty() && data.size() >0);
        
    }

    @Test
    @Ignore
    public void testChipperUtils()
    {
   
    	String testString = "OFBBMUFDICCSO".toLowerCase();
    	int chipperKey =5;
    	String actual =ChipperUtils.decodedString(testString, chipperKey);
    	System.out.println(actual);
    	
    }
    
 
   @Test
   @Ignore
    public void testmain()
    {
    	String[] s ={PATH};
    	GeekTrust.main(s);
    }
}
