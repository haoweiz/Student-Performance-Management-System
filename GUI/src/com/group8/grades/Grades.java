package com.group8.grades;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Grades extends JFrame{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> list = new ArrayList<String>();
	private ArrayList<GradeOfOne> listOfGrades = new ArrayList<GradeOfOne>();
	public JFrame jf = new JFrame("Grades");
	private JPanel panel = new JPanel();
	private JButton button1 = new JButton("Save");
	private JButton button2 = new JButton("Leave");
//        private JButton button3 = new JButton("View");
	private JTable table;
	public Grades(int number){
		System.out.println("The number of members is "+number);

		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				list.clear();
				listOfGrades.clear();
				System.out.println("clear");
				for(int i = 0; i < number; i++){
					list.add((String) table.getValueAt(i+1, 0));
				}
				System.out.println(number);
				for(int j = 0; j < number; j++){
					GradeOfOne g = new GradeOfOne();
					if(table.getValueAt(j+1, 1) != null || Character.isDigit((char) table.getValueAt(j+1, 1)))
					    g.PS = Double.parseDouble((String) table.getValueAt(j+1, 1));
					if(table.getValueAt(j+1, 2) != null || Character.isDigit((char) table.getValueAt(j+1, 2)))
				   	    g.MP = Double.parseDouble((String) table.getValueAt(j+1, 2));
					if(table.getValueAt(j+1, 3) != null || Character.isDigit((char) table.getValueAt(j+1, 3)))
					    g.WE = Double.parseDouble((String) table.getValueAt(j+1, 3));
					listOfGrades.add(g);
					System.out.println(g.PS+ ","+g.MP+","+g.WE);
				}
				boolean success = true;
				for(int i = 0;i < listOfGrades.size();i++){
					double ps = listOfGrades.get(i).PS;
					double mp = listOfGrades.get(i).MP;
					double we = listOfGrades.get(i).WE;
					System.out.println(ps+" "+ mp+" "+we);
					if(ps > 5 || ps <0 || mp >5 || mp < 0 || we >5 || we <0){
						success = false;
						break;
					}
				}
                if(success){
                	JOptionPane.showMessageDialog(null, "Grades entered!");
    				jf.setVisible(false);
                }
				else{
					JOptionPane.showMessageDialog(null, "Incorrect Values!");
				}
			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
			}
		});
//                button3.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//                                new NormalisePoints();
//                        }
//                });

		Container container = jf.getContentPane();
		table = new JTable(number + 1,4);
		table.setValueAt("Group Members(Including Yourself)", 0, 0);
		table.setValueAt("Professionalism (Score 0-5)", 0, 1);
		table.setValueAt("Meeting Participation (Score 0-5)", 0, 2);
		table.setValueAt("Work Evaluation (Score 0-5)", 0, 3);
		panel.add(button1);
		panel.add(button2);
//                panel.add(button3);
		container.add(table,BorderLayout.CENTER);
		container.add(panel,BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	public ArrayList<GradeOfOne> getListOfGrades() {
		return listOfGrades;
	}
	public void setListOfGrades(ArrayList<GradeOfOne> listOfGrades) {
		this.listOfGrades = listOfGrades;
	}
	
}
