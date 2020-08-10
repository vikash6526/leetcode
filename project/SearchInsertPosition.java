package leetcode.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;

public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
		int index = Arrays.binarySearch(nums, target);
		return index >= 0 ? index : Math.abs(index) - 1;
	}

	public int searchInsert1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
			else if (nums[i] > target)
				return i;
		}
		return nums.length;
	}

	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		for (int j = 0; j < 2; j++) {
			JSONObject category = new JSONObject();
			category.put("header", "category_header");
			for (int i = 0; i < 2; i++) {
				JSONObject feature = new JSONObject();
				feature.put("id", "feature_ID");
				List<Boolean> list = new ArrayList<>();
				list.add(true);
				list.add(false);
				list.add(false);
				feature.put("data", list);
				feature.put("highlight", true);
				category.put("feature" + i, feature);
			}
			obj.put("category" + j, category);
		}
		String str = "dfs:Products/Credit-Cards/Category/Rewards/unlimmitedRewards";
		System.out.println(str.substring(str.lastIndexOf("/")+1, str.length()));

		String[] str1=new String[] {"hello","vikash","kumar"};
		List<String> listString=Arrays.asList(str1);
		
		System.out.println(listString.contains("hello"));

	}

}
