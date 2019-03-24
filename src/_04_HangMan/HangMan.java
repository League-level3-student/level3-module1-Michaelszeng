package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan extends Utilities implements KeyListener{
	boolean guessTime;
	String word;
	String s;
	int lives;
	boolean finished;
	String playAgain;
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	
	public HangMan() {
		
		Stack<String> words = new Stack<String>();
		frame.add(panel);
		panel.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		
		String strNumWords = JOptionPane.showInputDialog("Welcome to Hangman!\nHow many words would you like to guess?");
		int numWords = Integer.parseInt(strNumWords);
		lives = numWords * 10;
		for (int i=0; i<numWords; i++) {
			while (true) {
				word = readRandomLineFromFile("dictionary.txt");
				System.out.println(word);
				if (words.contains(word) == false) {
					words.push(word);
					break; }}}
		
		for (int i=0; i<words.size(); i++) {
			String secretWord = words.pop();
			s = "";
			for (int j=0; j<secretWord.length(); j++) {
				s += "_";
			}
			s += " Lives Remaining: " + lives;
			label.setText(s);
			frame.pack();
			frame.setVisible(true);
			guessTime = true;
			if (finished) {
				JOptionPane.showMessageDialog(null, "Congratulations!");
			}
			
		}
	}
	
	public static void main(String[] args) {
		HangMan man = new HangMan();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char guess = e.getKeyChar();
		String newS = "";
		boolean guessedRight = false;
		
		if (guessTime) {
			for (int i=0; i<word.length(); i++) {
				if (word.charAt(i) != guess) {
					newS += label.getText().charAt(i);
				}
				else {
					newS += guess;
					guessedRight = true;
				}
			}
			if (guessedRight == false) {
				lives -= 1;
			}
			newS += " Lives Remaining: " + lives;
			label.setText(newS);
			finished = true;
			for (int j=0; j<label.getText().length(); j++) {
				if (label.getText().substring(j,  j+1) == "_") {
					finished = false;
				}
			}
			if (lives <= 0) {
				playAgain = JOptionPane.showInputDialog("Game Over!\nWould you like to play again?");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
