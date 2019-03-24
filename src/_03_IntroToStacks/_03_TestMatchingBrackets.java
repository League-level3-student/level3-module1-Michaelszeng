package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {
	String bracket;

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<String> brackets = new Stack<String>();
		for (int i=0; i<b.length(); i++) {
			bracket = b.substring(i, i+1);
			if (bracket.equals("{")) {
				brackets.push(bracket);
			}
			else {
				if (brackets.size() == 0) {
					return false;
				}
				brackets.pop();
			}
		}
		if (brackets.size() > 0) {
			return false;
		}
		return true;

	}

}