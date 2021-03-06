package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> text = new Stack<String>();
	Stack<String> deleted = new Stack<String>();
	String popped;
	boolean delete;
	
	public _02_TextUndoRedo() {
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
	}
	
	public static void main(String[] args) {
		_02_TextUndoRedo t = new _02_TextUndoRedo();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			label.setText(label.getText().substring(0, label.getText().length()-1));
			popped = text.pop();
			deleted.push(popped);
			delete = true;
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_ALT) {
			if (delete == true) {
				label.setText(label.getText() + deleted.pop());
			}
			else {
				text.pop();
				label.setText(label.getText().substring(0, label.getText().length()-1));
			}
		}
		else {
			char character = e.getKeyChar();
			String string = "" + character;
			label.setText(label.getText()+text.push(string));
			delete = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
