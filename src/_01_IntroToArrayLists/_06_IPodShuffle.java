package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("Play random song");
	ArrayList<Song> songs = new ArrayList<Song>();

	public _06_IPodShuffle() {
		Song demo = new Song("demo.mp3");
		Song piano = new Song("pianoSong.mp3");
		songs.add(demo);
		songs.add(piano);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(button);
		button.addActionListener(this);
		frame.pack();
	}

	/**
	 * 2. Congratulations on completing the sound check! * Now we want to make an
	 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
	 * "Surprise Me!" button that will play a random song when it is clicked. * If
	 * you're really cool, you can stop all the songs, before playing a new one on
	 * subsequent button clicks.
	 */

	public static void main(String[] args) {
		_06_IPodShuffle pod = new _06_IPodShuffle();
		Song song = new Song("demo.mp3");
		song.play();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			Random ran = new Random();
			int choice = ran.nextInt(2);
			songs.get(choice).play();
		}

	}
}