package hr.fer.oop.week10.gui;

import hr.fer.oop.topic10.db.CourseRecord;
import hr.fer.oop.topic10.db.Database;
import hr.fer.oop.topic10.db.EnrolmentRecord;
import hr.fer.oop.week9.db.StudentRecord;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

import javafx.scene.shape.Box;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;

public class StudentsFrame extends JFrame {

	private Database database;
	private JPanel contentPane;
	private JPanel innterJPanel;
	private JPanel studenJPanel;
	private JPanel courseJPanel;

	private JComboBox<StudentRecord> comboBox;
	private JTextField jmbagVar;
	private JTextField prezVar;
	private JTextField imeVar;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsFrame frame = new StudentsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public StudentsFrame() throws IOException {

		database = new Database("predmeti.txt", "upisaniPredmeti.txt",
				"database.txt");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.comboBox = new JComboBox<StudentRecord>();

		for (Map.Entry<String, StudentRecord> entry : (database
				.getStudentDatabase().getDataBase()).entrySet()) {
			StudentRecord record = entry.getValue();
			comboBox.addItem(record);
		}

		comboBox.addActionListener(new ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				StudentRecord rec = (StudentRecord) comboBox.getSelectedItem();
				updateJPanels(rec);

			}

			private void updateJPanels(StudentRecord rec) {

				imeVar.setText(rec.getFirstName());
				prezVar.setText(rec.getLastName());
				jmbagVar.setText(rec.getJmbag());

				studenJPanel.invalidate();
				
				courseJPanel.removeAll();
				
				StudentRecord currentRecord = (StudentRecord) comboBox
						.getSelectedItem();
				
				for (EnrolmentRecord record : database.getEnrolmentDatabase()
						.findByStudent(currentRecord.getJmbag())) {
					

					for (Map.Entry<String, CourseRecord> entry : (database
							.getCourseDatabase().getDataBase()).entrySet()) {
						
						CourseRecord courseRecord = entry.getValue();
						if (record.getCourseId().equals(courseRecord.getCourseId())) {
							Button button= new Button(courseRecord.getCourseName());
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									JOptionPane.showMessageDialog(courseJPanel,record.getGrade());
									
								}
							});
							courseJPanel.add(button);

							
						}
					}
				}
				
				courseJPanel.validate();
				
				

			}
		});

		contentPane.add(comboBox, BorderLayout.NORTH);

		this.innterJPanel = new JPanel();

		contentPane.add(innterJPanel, BorderLayout.CENTER);

		studenJPanel = new JPanel();

		innterJPanel.setLayout(new BorderLayout(0, 0));

		GroupLayout layout = new GroupLayout(studenJPanel);

		studenJPanel.setLayout(layout);

		innterJPanel.add(studenJPanel, BorderLayout.NORTH);

		StudentRecord rec = (StudentRecord) comboBox.getSelectedItem();

		jmbagVar = new JTextField(rec.getJmbag());
		jmbagVar.setEditable(false);
		prezVar = new JTextField(rec.getLastName());
		prezVar.setEditable(false);
		imeVar = new JTextField(rec.getFirstName());
		imeVar.setEditable(false);

		JLabel JMBAG = new JLabel("JMBAG: ");
		JLabel Prezime = new JLabel("Prezime: ");
		JLabel Ime = new JLabel("Ime: ");

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup().addComponent(JMBAG)
								.addComponent(jmbagVar))
				.addGroup(
						layout.createParallelGroup().addComponent(Prezime)
								.addComponent(prezVar))
				.addGroup(
						layout.createParallelGroup().addComponent(Ime)
								.addComponent(imeVar))

		);
		layout.setHorizontalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.TRAILING)
								.addComponent(JMBAG).addComponent(Prezime)
								.addComponent(Ime))
				.addGroup(
						layout.createParallelGroup().addComponent(jmbagVar)
								.addComponent(prezVar).addComponent(imeVar)));

		courseJPanel = new JPanel();

		innterJPanel.add(courseJPanel, BorderLayout.CENTER);

		BoxLayout boxLayout = new BoxLayout(courseJPanel,BoxLayout.Y_AXIS);
		courseJPanel.setBorder(BorderFactory
				.createTitledBorder("Upisani predmeti "));

		courseJPanel.setLayout(boxLayout);	

		StudentRecord currentRecord = (StudentRecord) comboBox
				.getSelectedItem();
		
		for (EnrolmentRecord record : database.getEnrolmentDatabase()
				.findByStudent(currentRecord.getJmbag())) {
			

			for (Map.Entry<String, CourseRecord> entry : (database
					.getCourseDatabase().getDataBase()).entrySet()) {
				
				CourseRecord courseRecord = entry.getValue();
				if (record.getCourseId().equals(courseRecord.getCourseId())) {
					Button button= new Button(courseRecord.getCourseName());
					button.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(courseJPanel,record.getGrade());
							
						}
					});
					courseJPanel.add(button);

					
				}
			}
		}

	}

}
