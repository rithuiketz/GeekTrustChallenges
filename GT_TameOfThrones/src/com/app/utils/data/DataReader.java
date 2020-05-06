package com.app.utils.data;

import java.util.Collection;
import java.util.List;

import com.app.dto.InputData;

public interface DataReader {
	
	public Collection<InputData> read(String path);
	

}
