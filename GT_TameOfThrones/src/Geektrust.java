import java.util.ArrayList;
import java.util.Collection;

import com.app.componet.Ruler;
import com.app.dto.InputData;
import com.app.service.ApplicationService;
import com.app.service.ApplicationServiceImpl;
import com.app.service.messaging.MessageServiceImpl;
import com.app.utils.KINGDOM;
import com.app.utils.data.BasicTextReader;

public class Geektrust {

	public static void main(String[] args) {

		String path = args[0];
		Collection<InputData> inputData = new BasicTextReader().read(path);
		ApplicationService asc =  new ApplicationServiceImpl(new MessageServiceImpl());
		Ruler sender = new Ruler(KINGDOM.SPACE);
		Collection<Ruler> op = new ArrayList<>();
		for(InputData ipd :  inputData)
		{
			Ruler rcvr = new Ruler(ipd.getKingDom());
		    Ruler r =  asc.chekForKingDomDefeated(rcvr, sender, rcvr.getEmblem().length(), ipd.getMessage());
		    if(r !=null)
		    {
		    	op.add(r);
		    }
		}
	    if(op.size() > 2)
	    {
	    	StringBuilder sb =  new StringBuilder(sender.toString()+" ");
	    	for(Ruler r  :op )
	    	{
	    		sb.append(r.toString()+" ");
	    	}
	    	System.out.println(sb.toString());
	    }
	    else
	    {
		    System.out.println("NONE");
	    }
		
		

	}

}
