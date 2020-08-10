package leetcode.project;

import java.util.ArrayList;
import java.util.List;

public class DesignBrowserHistory {
	List<String> browser = new ArrayList<>();
	int current = -1;
	int last = -1;

	public void BrowserHistory(String homepage) {
		browser.add(homepage);
		current++;
		last++;
	}

	public void visit(String url) {
		if (current < last) {
			while (current != last)
				browser.remove(last--);
		}
		browser.add(url);
		current++;
		last++;
	}

	public String back(int steps) {
		current = current - steps;
		if (current < 0)
			current = 0;
		return browser.get(current);
	}

	public String forward(int steps) {
		current = current + steps;
		if (current >= browser.size())
			current = last;
		return browser.get(current);
	}

	public static void main(String[] args) {
		DesignBrowserHistory dbh = new DesignBrowserHistory();
		dbh.BrowserHistory("zav.com");
		dbh.visit("kni.com");
		System.out.println(dbh.back(7));
		System.out.println(dbh.back(7));
		System.out.println(dbh.forward(5));
		System.out.println(dbh.forward(1));
		dbh.visit("pwrrbnw.com");
		dbh.visit("mosohif.com");
		System.out.println(dbh.back(9));

	}

}
