package playground;

import java.util.ArrayList;

public class CatalogMaker {
	ArrayList<LeagueItems> list;
	public CatalogMaker() {
		list = new ArrayList<LeagueItems>();
		list.add(new LeagueItems("Infinity Edge", 3400, "resources/infinityedge.png"));
		list.add(new LeagueItems("Statikk Shiv", 2600, "resources/statshiv.png"));
	}

	public static void main(String[] args) {
		CatalogMaker catalog = new CatalogMaker();
		System.out.println(catalog.getCSVContent());

	}
	
	public String getCSVContent() {
		String data = "";
		for (LeagueItems item : list) {
			data += item + "\n";
		}
		return data;
	}

}
