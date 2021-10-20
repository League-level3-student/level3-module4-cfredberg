package _03_Hangman;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.*;

public class Hangman implements KeyListener {
	public static void main(String[] args) {
		Hangman h = new Hangman();
		h.run();
	}
	Stack<String> stack = new Stack<String>();
	JFrame frame = new JFrame("Hangman");
	JPanel panel = new JPanel();
	JLabel dLives = new JLabel();
	JLabel dWord = new JLabel();
	int lives;
	String tempWord;
	String displayWord ="";
	
	public void run() {
		String count = JOptionPane.showInputDialog("Select the number of words you would like to try to guess. (1-266)");
		lives = Integer.parseInt(count) * 8;
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.setPreferredSize(new Dimension(250, 150));
		for (int i = 0; i < Integer.parseInt(count); i++) {
			String randomLine = Utilities.readRandomLineFromFile("dictionary.txt");
			if (stack.contains(randomLine)) {
				i--;
			}else {
				stack.push(randomLine);
			}
		}
		tempWord = stack.pop();
		for (int i = 0; i < tempWord.length(); i++) {
			displayWord = displayWord + "_";
		}
		
		updatePanel();
	}
	
	public void updatePanel() {
		dLives.setText("Lives: " + lives);
		dWord.setText(displayWord);
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.add(dLives);
		panel.add(dWord);
		frame.add(panel);
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		boolean updated = false;
		for (int i = 0; i < tempWord.length(); i++) {
			if (e.getKeyChar() == tempWord.charAt(i)) {
				String tdWord = displayWord;
				displayWord = "";
				updated = true;
				for (int j = 0; j < tempWord.length(); j++) {
					if (j == i) {
						displayWord = displayWord + tempWord.charAt(i);
					}else {
						displayWord = displayWord + tdWord.charAt(j);
					}
				}
				i = tempWord.length();
			}
		}
		if (!updated) {
			lives = lives - 1;
		}
		updatePanel();
	}
}
