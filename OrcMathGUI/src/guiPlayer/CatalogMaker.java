package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;


public class CatalogMaker {
	ArrayList<LeagueItems> list;
	public CatalogMaker() {
		list = new ArrayList<LeagueItems>();
		//list.add(new LeagueItems("Infinity Edge", 3400, "resources/infinityedge.png"));
		list.add(new LeagueItems("Statikk Shiv", 2600, "resources/statshiv.png"));
	}

	public static void main(String[] args) {
		CatalogMaker catalog = new CatalogMaker();
		catalog.addItem();
		System.out.println(catalog.getCSVContent());
		
	}	
	
	public String getCSVContent() {
		String data = "";
		for (LeagueItems item : list) {
			data += item + "\n";
		}
		return data;
	}
	public void addItem() {
		Scanner in = new Scanner(System.in);
		System.out.println("What item do you want to add?");
		String item = in.nextLine();
		System.out.println("How much does it cost?");
		int price = in.nextInt();
		System.out.println("Source?");
		String link = "";
		while (link.equals("")) {
			link = in.nextLine();
		}
		list.add(new LeagueItems(item, price, link));
	}

}
