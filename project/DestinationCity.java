package leetcode.project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {

	public static String destCity(List<List<String>> paths) {
		Set<String> source = new HashSet<>();
		Set<String> destination = new HashSet<>();
		String dest = "";
		for (List<String> list : paths) {
			int i = 0;
			for (String path : list) {
				if (i == 0) {
					source.add(path);
				} else {
					destination.add(path);
				}
				i++;
			}
		}
		for (String d : destination) {
			if (!source.contains(d))
				dest = d;
		}

		return dest;
	}

	public static void main(String[] args) {
		// String str = '["jMgaf WaWA","iinynVdmBz"],["
		// QCrEFBcAw","wRPRHznLWS"],["iinynVdmBz","OoLjlLFzjz"],["OoLjlLFzjz","
		// QCrEFBcAw"],["IhxjNbDeXk","jMgaf WaWA"],["jmuAYy vgz","IhxjNbDeXk"]';
		List<List<String>> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		list1.add("jMgaf WaWA");
		list1.add("Z");
		list.add(list1);
		List<String> list2 = new ArrayList<>();
		list2.add("D");
		list2.add("B");
		list.add(list2);
		List<String> list3 = new ArrayList<>();
		list3.add("C");
		list3.add("A");
		list.add(list3);

		System.out.println(destCity(list));

	}

}
