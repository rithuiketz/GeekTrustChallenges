package com.app.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.utils.KINGDOM;

public class KingdomUtils 
{
	private static final Map<String, KINGDOM> kingDoms = new HashMap<String, KINGDOM>();
	static {
		System.out.println("####Loading Kingdoms####");
		for (KINGDOM kingDom : KINGDOM.values()) {
			kingDoms.put(kingDom.getKingDom(), kingDom);
		}

	}

	public static List<KINGDOM> getAllKingdoms() {
		return Arrays.asList(KINGDOM.values());
	}

	public static KINGDOM getKingdomByName(String name) {
		return kingDoms.get(name);
	}

}
