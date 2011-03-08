package com.outlandr.dynauth;

import java.util.ArrayList;
import java.util.List;

public class InfosManager {
	private static List<InfosProvider> infos = new ArrayList<InfosProvider>();
	static {
		infos.add(new InfosProvider("id1", "What is the name of street you grow in?"));
		infos.add(new InfosProvider("id2", "What is the name of your pet?"));
	}

	
	
	public static List<InfosProvider> getInfosProviders() {
		return infos;
		
	}

}
