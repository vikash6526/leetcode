package leetcode.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			char[] tempString = strs[i].toCharArray();
			Arrays.sort(tempString);
			String sort1=new String(tempString);
			boolean added = false;
			for (List<String> ls : list) {
				if (!ls.isEmpty()) {
					char[] tString = ls.get(0).toCharArray();
					Arrays.sort(tString);
					String sort2=new String(tString);
					if (sort1.equalsIgnoreCase(sort2)) {
						ls.add(strs[i]);
						added = true;
					}
				}
			}
			if (!added) {
				List<String> ChildList = new ArrayList<>();
				ChildList.add(strs[i]);
				list.add(ChildList);
			}
		}
		return list;
	}

	public static List<List<String>> groupAnagrams1(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		Map<String,List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] tempString = strs[i].toCharArray();
			Arrays.sort(tempString);
			String sort=new String(tempString);
			if(map.containsKey(sort)) {
				map.get(sort).add(strs[i]);			
			}
			else {
				map.put(sort, new ArrayList<String>());
				map.get(sort).add(strs[i]);
			}
		}
		for(String childList: map.keySet()) {
			list.add(map.get(childList));
		}
		return list;
	}

	public static void main(String[] args) {
		 groupAnagrams1(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
		//test();

	}

}
