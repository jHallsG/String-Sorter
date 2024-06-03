package com.windowsapp.model;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClassStorage {

	private static ClassStorage instance;
	private JButton button;
	private JTextField textField;
	private JComboBox comboBox;
	private JLabel output;

	private ClassStorage() {

	}

	public JButton getButton() {
		return button;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JLabel getOutput() {
		return output;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public void setOutput(JLabel output) {
		this.output = output;
	}

	public static ClassStorage getInstance() {
		if (instance == null) {
			instance = new ClassStorage();
		}

		return instance;
	}

}
