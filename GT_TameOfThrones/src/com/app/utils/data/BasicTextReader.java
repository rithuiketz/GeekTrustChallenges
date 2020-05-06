package com.app.utils.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.app.dto.InputData;

public class BasicTextReader implements DataReader {

	@Override
	public Collection<InputData> read(String path) {
	
		Collection<InputData> list = Collections.emptyList();
		FileReader reader=null;
		BufferedReader br = null;
		try
		{
			reader =new FileReader(path);
			br = new BufferedReader(reader);
			List<String> lines  = br.lines().collect(Collectors.toList());
			list = DataTransformer.transformData(lines);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(reader !=null)
				{
					reader.close();
				}
				if(br!=null)
				{
					br.close();
				}
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
		}
		
		return list;
	}

}
