package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;
import javax.swing.JOptionPane;

public class _01_IntroToStack {
	static int smaller;
	static int bigger;

	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> doubles = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int i=0; i<100; i++) {
			Random ran = new Random();
			Double ranInt = 0+100*ran.nextDouble();
			doubles.push(ranInt);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String string1 = JOptionPane.showInputDialog("Enter number between 0 and 100: ");
		int int1 = Integer.parseInt(string1);
		String string2 = JOptionPane.showInputDialog("Enter number between 0 and 100: ");
		int int2 = Integer.parseInt(string2);
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		if (int1 <= int2) {
			smaller = int1;
			bigger = int2;
		}
		else {
			smaller = int2;
			bigger = int1;
		}
		System.out.println("Elements between " + smaller + " and " + bigger);
		for (int i=0; i<doubles.size();) {
			Double popped = doubles.pop();
			if ((popped > smaller) && (popped < bigger)) {
				System.out.println(popped);
			}
		}
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
