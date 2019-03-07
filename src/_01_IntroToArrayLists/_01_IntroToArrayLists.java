package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		// 1. Create an array list of Strings
		// Don't forget to import the ArrayList class

		ArrayList<String> strings = new ArrayList<String>();

		// 2. Add five Strings to your list
		strings.add("string0");
		strings.add("string1");
		strings.add("string2");
		strings.add("streeng3");
		strings.add("string4");

		for (int i = 0; i < 5; i++) {
			System.out.println(strings.get(i));
		}
		System.out.println("");
		// 3. Print all the Strings using a standard for-loop

		// 4. Print all the Strings using a for-each loop
		for (String string : strings) {
			System.out.println(string);
		}
		System.out.println("");
		// 5. Print only the even numbered elements in the list.
		for (int i = 0; i < 5; i += 2) {
			System.out.println(strings.get(i));
		}
		// 6. Print all the Strings in reverse order.
		System.out.println("");
		for (int i = 4; i >= 0; i -= 1) {
			System.out.println(strings.get(i));
		}
		// 7. Print only the Strings that have the letter 'e' in them.
		System.out.println("");
		for (String string : strings) {
			if (string.contains("e")) {
				System.out.println(string);
			}
		}
	}
}
