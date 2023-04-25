

package WordOccurences;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.junit.Test;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Map;

/*
* This public class presents a Jframe in the process of being made from a reverse engineered tactic
*
*/


public class UserFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * @wbp.nonvisual location=130,21
	 * @AuthorKiMalesh
	 */
	
	private final JLabel lblWordOccurences = new JLabel("Word Occurences");
	private JTextField textField;
	private JTextField textNumOccurences;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Creates wordMap
		WordOccurences testWord = new WordOccurences();
		Map<String,Integer> wordMap = testWord.createWordMap();


		/*
		* Prints out the number of times the word "more" appears in the text file.
		* This focused on our testing phase when we are testing whether or not each word occurs the correct amount of times in both the word map and being pull indiviually based on the word chosen.
		*/
		
		
		System.out.println("     ");
		System.out.println("----System Testing Occurences---- ");
		    
		System.out.println(testWord.numberWords(wordMap, "the"));
		System.out.println(testWord.numberWords(wordMap, "or"));
		System.out.println(testWord.numberWords(wordMap, "raven"));
		System.out.println(testWord.numberWords(wordMap, "too"));
		System.out.println(testWord.numberWords(wordMap, "many"));

		// Runs the GUI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame for the window we are focusing on along with labels and dimensions
	 *
	 */
	
	public UserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Word?:");
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("# of Occurences:");
		contentPane.add(lblNewLabel_1);
		
		textNumOccurences = new JTextField();
		contentPane.add(textNumOccurences);
		textNumOccurences.setColumns(10);
		textNumOccurences.setText("0");
		
		JButton btnNewButton = new JButton("Compute");
		btnNewButton.setActionCommand("Compute");
		btnNewButton.addActionListener(new ComputeActionListener());
		contentPane.add(btnNewButton);
	}


	/** 
	* Private class that focuses on opening the actionlistener along with getting the text from orginal word occurences and implementing the word map
	*
	*/
	
	private class ComputeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("Compute")) {
				String word = textField.getText();
				WordOccurences testWord = new WordOccurences();
				Map<String,Integer> wordMap = testWord.createWordMap();		
				int num = testWord.numberWords(wordMap, word);
				textNumOccurences.setText(Integer.toString(num));
			}
		}
	}

	public static int numberWords(Map<String, Integer> wordMap, String string) {
		// TODO Auto-generated method stub
		return 0;
	}	

}

/*
 * Our userframe ends here
 *
 */ 