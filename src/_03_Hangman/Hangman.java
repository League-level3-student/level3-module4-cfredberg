package _03_Hangman;

import java.awt.Dimension;
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
	JLabel lives = new JLabel();
	String tempWord;
	
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.add(panel);
		frame.setPreferredSize(new Dimension(250, 150));
		frame.pack();
		String count = JOptionPane.showInputDialog("Select the number of words you would like to try to guess. (1-266)");
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
			
		}
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
		
	}
}
