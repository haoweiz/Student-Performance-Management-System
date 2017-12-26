package com.group8.grades;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InitialScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jf = new JFrame("InitialScreen");
	private JPanel panel= new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JLabel label2 = new JLabel("Did you enter the grades earlier?");
	private JRadioButton radiobutton = new JRadioButton("Yes");
	private JRadioButton radiobutton2 = new JRadioButton("No");
	private ButtonGroup group = new ButtonGroup();
	private JLabel label = new JLabel("Number of Team Members");
	private SpinnerModel spinnerModel = new SpinnerNumberModel(2,2,7,1);
	private JSpinner spinner = new JSpinner(spinnerModel);
	private JButton button1 = new JButton("Enter/UpdateGrades");
	private JButton button3 = new JButton("FinalGrades");
	private JButton button2 = new JButton("Exit"); 
	private Grades g;
	private static final int GRADE_CATEGORIES = 3;
	public InitialScreen(){
		ActionListener radioaction = new ActionListener(){
			public void actionPerformed(ActionEvent a){
				if(radiobutton.isSelected())
					spinner.setEnabled(false);
				if(radiobutton2.isSelected())
					spinner.setEnabled(true);
			}
		};
		group.add(radiobutton);
		group.add(radiobutton2);
		panel3.add(label2);
		radiobutton.addActionListener(radioaction);
		radiobutton2.addActionListener(radioaction);
		radiobutton2.setSelected(true);
		panel3.add(radiobutton);
		panel3.add(radiobutton2);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(radiobutton2.isSelected())
				    g = new Grades((int) spinner.getValue());
				if(radiobutton.isSelected() && g != null)
					g.jf.setVisible(true);
				if(radiobutton.isSelected() && g == null){
					JOptionPane.showMessageDialog(null, "You haven't input grades!");
				}
			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
//				System.out.println("Hi! testing:: Button 3");
				if(radiobutton.isSelected() && g == null){
					JOptionPane.showMessageDialog(null, "Oops!No grades found");
				}
				if(radiobutton2.isSelected()){
					JOptionPane.showMessageDialog(null, "Oops!Input the grades");
				}
				if(radiobutton.isSelected() && g!=null) {
					ArrayList<GradeOfOne> gradesList = g.getListOfGrades();
					ArrayList<String> namesList = g.getList();
					int teamMembers = gradesList.size();
					double [][] scores = new double [teamMembers][GRADE_CATEGORIES];
//					System.out.println("Hi! testing:: gradesList" + gradesList.toString());
					for(int i=0; i<teamMembers; i++) {
						GradeOfOne gone = gradesList.get(i);
						scores[i][0] = gone.MP;
						scores[i][1] = gone.PS;
						scores[i][2] = gone.WE;
					}
					NormalisePoints norm = new NormalisePoints();
					double[] normalizedScore = norm.normalisePoints(scores);
					String grades = "";
					StringBuilder stringBuilder = new StringBuilder(1000);
					stringBuilder.append("Final Grades\n");
					for(int i=0; i<normalizedScore.length; i++) {
						System.out.println("Final Grades:: "  + normalizedScore[i]);
						stringBuilder.append(namesList.get(i) + " : " + String.valueOf(normalizedScore[i]));
						stringBuilder.append("\n");
					}
					
					JOptionPane.showMessageDialog(null, stringBuilder.toString());
					
				}
			}
		});
		
		Container container = jf.getContentPane();
		panel.add(label);
		panel.add(spinner);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		container.add(panel,BorderLayout.NORTH);
		container.add(panel3,BorderLayout.CENTER);
		container.add(panel2,BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new InitialScreen();
	}
}
