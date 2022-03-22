package com.mashery.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class TestDataStructures {

	public static boolean verifyCharSeq(String s) {
		String str = s;
		// Stack<Character> st = new Stack<Character>();
		Deque<Character> st = new ArrayDeque<Character>();

		for (int i = 0; i <= str.length() - 1; i++) {
			char c = str.charAt(i);
			if (c == '[' || c == '(' || c == '{') {

				st.push(c);

			}

			if (st.isEmpty()) {
				return false;
			}

			char ch;

			switch (c) {
			case '}':

				ch = (char) st.pop();
				if (ch == '(' || ch == '[') {
					return false;

				}
				break;
			case ')':
				ch = (char) st.pop();
				if (ch == '{' || ch == '[') {
					return false;

				}
				break;
			case ']':
				ch = (char) st.pop();
				if (ch == '{' || ch == '(') {
					return false;

				}
				break;
			}

		}
		return true;

	}

	public static void verifyDuplicateChar(String str) {

		String s = str;
		Map<Character, Integer> mChar = new HashMap<Character, Integer>();

		for (int i = 0; i <= s.length() - 1; i++) {
			char c = s.charAt(i);

			if (mChar.containsKey(c)) {
				mChar.put(c, 1 + mChar.get(c));
			} else {
				mChar.put(c, 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : mChar.entrySet()) {

			if (entry.getValue() > 1) {
				System.out.println(entry.getKey());
			}
		}

	}

	public static void main(String args[]) {

		 System.out.println(verifyCharSeq("])}"));

		// verifyDuplicateChar("palendrome");
	}

}
