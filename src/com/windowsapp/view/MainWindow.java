package com.windowsapp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.windowsapp.controllers.MainController;
import com.windowsapp.model.ClassStorage;

public class MainWindow {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame();

		mainFrame.setTitle("Windows Sorting App");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(300, 250);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.add(sideSubPanel(), BorderLayout.WEST);
		mainFrame.add(sideSubPanel(), BorderLayout.EAST);
		mainFrame.add(windowPanel(), BorderLayout.CENTER);
		mainFrame.setVisible(true);
	}

	private static JPanel windowPanel() {
		JPanel mainPanel = new JPanel(new BorderLayout());

		mainPanel.add(northSubPanel(), BorderLayout.NORTH);
		mainPanel.add(centerSubPanel(), BorderLayout.CENTER);

		return mainPanel;
	}

	private static JPanel sideSubPanel() {
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.blue);
		leftPanel.add(Box.createHorizontalStrut(20));

		return leftPanel;
	}

	private static JPanel northSubPanel() {
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JLabel title = new JLabel("String Sort Pro");
		title.setFont(new Font("Arial", Font.BOLD, 25));

		northPanel.add(title);

		return northPanel;
	}

	private static JPanel centerSubPanel() {
		JPanel centerPanel = new JPanel(new GridBagLayout());

		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(120, 30));
		textField.setText("Enter String");

		JLabel output = new JLabel("Output:");
		JLabel textOutput = new JLabel();

		JLabel method = new JLabel("Sort Method:");

		String sortMethods[] = { "BubbleSort", "QuickSort", "MergeSort" };
		JComboBox comboBox = new JComboBox(sortMethods);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(1, 1, 10, 1);

		JButton submit = new JButton("Submit");

		ClassStorage func = ClassStorage.getInstance();
		func.setButton(submit);
		func.setComboBox(comboBox);
		func.setTextField(textField);
		func.setOutput(textOutput);

		MainController.startSort(submit);

		gbc.gridy = 0;
		gbc.gridx = 0;
		centerPanel.add(method, gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(comboBox, gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(textField, gbc);

		gbc.gridy = 2;
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		centerPanel.add(submit, gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		centerPanel.add(output, gbc);

		gbc.gridy = 4;
		gbc.gridx = 0;
		centerPanel.add(textOutput, gbc);

		return centerPanel;
	}

}
