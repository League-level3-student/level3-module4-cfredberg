package _00_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */

	JFrame frame = new JFrame("The Best Text Editor in the World!!! ;-)");
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	Stack<String> stack = new Stack<String>();
	
	public static void main(String[] args) {
		_02_TextUndoRedo method = new _02_TextUndoRedo();
		method.run();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 250));
		frame.add(panel);
		frame.pack();
		
		panel.add(label);
		
		frame.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	boolean ctrl = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			String text = label.getText();
			label.setText("");
			for (int i = 0; i < text.length(); i++) {
				if (i == text.length()-1) {
					stack.push(text.charAt(i) + "");
				}else {
					label.setText(label.getText() + text.charAt(i));
				}
			}
		}else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			
		}else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			ctrl = true;
		}else {
			if (ctrl) {
				if (e.getKeyCode() == KeyEvent.VK_Z) {
					if (!stack.isEmpty()) {
						label.setText(label.getText() + stack.pop());
					}
				}else if (e.getKeyCode() == KeyEvent.VK_E) {
					int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to empty the clipboard?");
					if (result == 0) {
						stack.removeAllElements();
					}
				}
			}else {
				label.setText(label.getText() + e.getKeyChar());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			ctrl = false;
		}
	}
}
