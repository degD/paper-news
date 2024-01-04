package dege.papernews;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;

public class PaperNewsGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField yearTextField;
	private JTextField monthTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private String selection;
	private Distributor distributor = new Distributor();
	private Vector<Journal> journalList;
	private Vector<Subscriber> subscriberList;
	
	
	private void setup() {
		distributor.addJournal(new Journal("j1", "1111", 6, 60));
		distributor.addJournal(new Journal("j2", "2222", 2, 40));
		distributor.addJournal(new Journal("j3", "3333", 4, 90));
		
		distributor.addSubscriber(new Individual("ali", "addres1"));
		distributor.addSubscriber(new Individual("veli", "addres3"));
		distributor.addSubscriber(new Corporation("corp1", "addres5"));
		distributor.addSubscriber(new Corporation("corp2", "addres7"));
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaperNewsGUI frame = new PaperNewsGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaperNewsGUI() {
		// Setup
		setup();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 169, 91);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel monthLabel = new JLabel("Month");
		monthLabel.setBounds(10, 11, 46, 14);
		panel.add(monthLabel);
		
		yearTextField = new JTextField();
		yearTextField.setBounds(66, 33, 86, 20);
		panel.add(yearTextField);
		yearTextField.setColumns(10);
		
		monthTextField = new JTextField();
		monthTextField.setBounds(66, 8, 86, 20);
		panel.add(monthTextField);
		monthTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Increment Month");
		btnNewButton.setBounds(10, 61, 142, 23);
		panel.add(btnNewButton);
		
		JLabel yearLabel = new JLabel("Year");
		yearLabel.setBounds(10, 36, 46, 14);
		panel.add(yearLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 169, 266);
		contentPane.add(scrollPane);
		
		DefaultListModel listModel = new DefaultListModel();
		JList dataList = new JList(listModel);
		scrollPane.setViewportView(dataList);
		
		JRadioButton subsButton = new JRadioButton("Subscribers");
		subsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// List subscriber names.
				listModel.clear();
				subscriberList = new Vector<Subscriber>();
				for (Subscriber subscriber : distributor.getSubscribers()) {
					listModel.addElement(subscriber.name);
					subscriberList.add(subscriber);
				}
				selection = "subscribers";
			}
		});
		buttonGroup.add(subsButton);
		subsButton.setBounds(6, 386, 109, 23);
		contentPane.add(subsButton);
		
		JRadioButton jourButton = new JRadioButton("Journals");
		jourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// List journal names.
				listModel.clear();
				journalList = new Vector<Journal>();
				for (Entry<String, Journal> journalEntry : distributor.getJournals().entrySet()) {
					String journalName = journalEntry.getValue().getName();
					listModel.addElement(journalName);
					journalList.add(journalEntry.getValue());
				}
				selection = "journals";
			}
		});
		buttonGroup.add(jourButton);
		jourButton.setBounds(6, 412, 109, 23);
		contentPane.add(jourButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(189, 11, 294, 266);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel detailsLabel = new JLabel("Details");
		detailsLabel.setBounds(10, 11, 46, 14);
		panel_1.add(detailsLabel);
		
		JTextArea detailsText = new JTextArea();
		detailsText.setEditable(false);
		detailsText.setLineWrap(true);
		detailsText.setBounds(10, 36, 274, 219);
		panel_1.add(detailsText);
		
		dataList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				if (e.getValueIsAdjusting() == false) {
					
					if (dataList.getSelectedIndex() == -1) {
						// Clear details area.
						
					} else {
						// Clear the text area.
						detailsText.setText(null);
						
						// Write selection details.
						int i = (int) dataList.getSelectedIndex();
						if (selection == "subscribers") {
							Subscriber subscriber = subscriberList.get(i);
							
							// Type of selection.
							if (subscriber instanceof Individual)
								detailsText.append("Individual\n");
							else if (subscriber instanceof Corporation)
								detailsText.append("Corporation\n");
							
							detailsText.append(subscriber.getName() + "\n" + subscriber.getAddress() + "\n");
							detailsText.append(subscriber.getBillingInformation());
						}
						else if (selection == "journals") {
							Journal aJournal = journalList.get(i);
							detailsText.append(aJournal.fancyToString());							
						}
					}
				}
			}
		});
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
