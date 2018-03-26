package hackerearth.CGI;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CostOfString {

	private static Map<Character, Long> charNumberMap = new HashMap<>();
	private static Map<Long, List<String>> charNumberCostMap = new HashMap<>();

	public static void charToNumber() {
		for (int i = 'A'; i <= 'Z'; i++) {
			charNumberMap.put((char) i, (long) (i - 'A' + 0));
		}
	}

	public static void main(String[] args) {
		charToNumber();
		try(Scanner scanner = new Scanner(System.in);){
		int n = scanner.nextInt();
		String[] arr = new String[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = scanner.next();
			getCost(arr[arr_i]);
		}
		}
		printStringOfSameCost(charNumberCostMap);
	}

	private static void getCost(String arr) {
		long cost=0;
		char[] a = arr.toUpperCase().toCharArray();
		for(char character : a){
			cost+=charNumberMap.get(character).intValue();
		}
		addCost(cost,arr);
	}

	private static void printStringOfSameCost(Map<Long, List<String>> charNumberCostMap2) {
		for(Map.Entry<Long, List<String>> key :  charNumberCostMap2.entrySet()){
			List<?> valueList = key.getValue();
			if(valueList.size()>1){
				System.out.println("Cost : "+key+" value : "+valueList);
			}
		}
		
	}

	private static void addCost(long cost, String arr) {
		List<String> charList = new LinkedList();
		if(!charNumberCostMap.containsKey(cost)){
			charList.add(arr);
			charNumberCostMap.put(cost, charList);
		}else{
			charNumberCostMap.get(cost).add(arr);
		}
	}


}
