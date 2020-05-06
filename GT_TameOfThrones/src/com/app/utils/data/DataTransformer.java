package com.app.utils.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.app.dto.InputData;
import com.app.utils.KingdomUtils;

public class DataTransformer {

	public static Collection<InputData> transformData(
			Collection<String> fileLines) {
		Collection<InputData> collection =new ArrayList<>();
		String[] splittedArr = new String[2];
		for (String s : fileLines) {
			splittedArr = s.split(" ");
			collection.add(new InputData(KingdomUtils
					.getKingdomByName(splittedArr[0]), splittedArr[1]));

		}
		return collection;
	}

}
