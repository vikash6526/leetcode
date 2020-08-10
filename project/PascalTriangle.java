package leetcode.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		list.get(0).add(1);
		List<Integer> rowIndex = new ArrayList<>();
		for (int i = 1; i < numRows; i++) {
			List<Integer> childList = new ArrayList<>();
			List<Integer> preRow = list.get(i - 1);
			childList.add(1);
			for (int j = 1; j < i; j++) {
				childList.add((preRow.get(j - 1) + preRow.get(j)));
			}
			childList.add(1);
			list.add(childList);
		}
		return list;
	}

	public static List<Integer> getRow(int rowIndex) {

		List<List<Integer>> list = new ArrayList<>();
		List<Integer> rowIndexList = new ArrayList<>();
		if (rowIndex == 0) {
			rowIndexList.add(1);
			return rowIndexList;
		}
		list.add(new ArrayList<>());
		list.get(0).add(1);
		for (int i = 1; i <= rowIndex; i++) {
			List<Integer> childList = new ArrayList<>();
			List<Integer> preRow = list.get(i - 1);
			childList.add(1);
			for (int j = 1; j < i; j++) {
				childList.add((preRow.get(j - 1) + preRow.get(j)));
			}
			childList.add(1);
			list.add(childList);
			if (i == rowIndex)
				rowIndexList = childList;
		}
		return rowIndexList;

	}

	public static List<Integer> getRowRecursion(int i) {
		if (i < 0)
			return new ArrayList();
		if (i == 0)
			return Arrays.asList(1);
		if (i == 1)
			return Arrays.asList(1, 1);

		List<Integer> op = getRow(i - 1);
		List<Integer> last = new ArrayList<>(Arrays.asList(1));
		for (int j = 0; j < op.size() - 1; j++) {
			last.add(op.get(j) + op.get(j + 1));
		}
		last.add(1);
		return last;
	}

	public static void main(String[] args) {
		// generate(5);
		getRow(3);

	}

}
