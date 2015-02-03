package wholesaler.database;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiMenu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel label1;
	public JLabel label2;
	public JLabel label3;
	public JLabel label4;
	public JLabel label5;
	public JButton button;
	public JButton button2;
	public JTextField textField;
	public ImageIcon image;
	public JPanel northJPanel;
	public JPanel westPanel;
	public JPanel centerPanel;
	public JPanel eastPanel;
	public JPanel southPanel;

	private int x = 0, y = 0;

	public GuiMenu() {

		x = 0;
		y = 0;
		setLayout(new GridLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920, 1080);

		setTitle("Wholesaler, by K.Groszyk & B.Ko³akowski");

		setVisible(true);
		// JPanel northPanel = new JPanel();
		// add(northPanel);
		// northPanel.setBackground(Color.BLUE);
		// northPanel.setVisible(true);

		// JPanel northPanel = new JPanel();
		// JPanel westPanel = new JPanel();
		// JPanel centerPanel = new JPanel();
		// JPanel eastPanel = new JPanel();
		// JPanel southPanel = new JPanel();
		//

		// northPanel.setLayout(new GridLayout());
		// westPanel.setBackground(Color.BLUE);
		// centerPanel.setBackground(Color.GREEN);
		// eastPanel.setBackground(Color.ORANGE);
		// southPanel.setBackground(Color.CYAN);

		// add(westPanel, BorderLayout.WEST);
		// add(centerPanel, BorderLayout.CENTER);
		// add(eastPanel, BorderLayout.EAST);
		// add(southPanel, BorderLayout.SOUTH);

		// textField = new JTextField(15);
		// add(textField);

		// button2 = new JButton("remove display");
		// add(button2);

		// image = new ImageIcon(getClass().getResource("plane.jpg"));
		// label = new JLabel("label");
		// add(label);
		// Event e = new Event();
		// button.addActionListener(e);
		// Event2 e2 = new Event2();
		// button2.addActionListener(e2);

	}

	public class Event implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// if (x == 0) {
			// label.setText("added");
			// repaint();
			// label3 = new JLabel("Stock as of beginning of a day:");
			// add(label3);
			// label3.setVisible(true);
			// repaint();
			// x = 1;
			// y = 0;
			// }
		}

	}

	public class Event2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// if (y == 0) {
			// label.setText("removed");
			// repaint();
			// label3.setVisible(false);
			// repaint();
			// x = 0;
			// y = 1;
			// }

		}

	}

	public void welcomeLabel(int hcc, int day, int balance) {
		setLayout(new GridLayout());
		label1 = new JLabel("Welcome. It's day " + day + ". HCC: " + hcc
				+ ". Account balance: " + balance + ".");
		add(label1);
		label1.setVisible(true);
		repaint();
		revalidate();

	}

}