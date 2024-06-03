package com.windowsapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.windowsapp.model.ClassStorage;

public class MainController {

	ClassStorage dto = ClassStorage.getInstance();

	public static void startSort(JButton btn) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn) {
					String method = (String) ClassStorage.getInstance().getComboBox().getSelectedItem();
					char[] charArray = inputToArray();
					switch (method) {
					case "QuickSort":
						quickSort(charArray, 0, charArray.length - 1);
						display(charArray);
						break;
					case "BubbleSort":
						bubbleSort(charArray);
						display(charArray);
						break;
					case "MergeSort":
						mergeSort(charArray, 0, charArray.length - 1);
						display(charArray);
						break;
					}
				}

			}
		});
	}

	private static void quickSort(char[] array, int low, int high) {
		if (low < high) {
			char pivot = array[high];
			int i = (low - 1);

			for (int j = low; j < high; j++) {
				if (array[j] <= pivot) {
					i++;
					char temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}

			char temp = array[i + 1];
			array[i + 1] = array[high];
			array[high] = temp;

			int pi = i + 1;

			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}

	private static void mergeSort(char[] array, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;

			mergeSort(array, left, middle);
			mergeSort(array, middle + 1, right);

			merge(array, left, middle, right);
		}
	}

	private static void merge(char[] array, int left, int middle, int right) {
		int n1 = middle - left + 1;
		int n2 = right - middle;

		char[] leftArray = new char[n1];
		char[] rightArray = new char[n2];

		for (int i = 0; i < n1; ++i) {
			leftArray[i] = array[left + i];
		}
		for (int j = 0; j < n2; ++j) {
			rightArray[j] = array[middle + 1 + j];
		}

		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}

	private static void bubbleSort(char[] array) {
		int n = array.length;
		boolean swapped;

		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					// Swap array[j] and array[j + 1]
					char temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}
			// If no elements were swapped, the array is sorted
			if (!swapped)
				break;
		}
	}

	private static char[] inputToArray() {
		return ClassStorage.getInstance().getTextField().getText().toCharArray();
	}

	private static void display(char[] charArray) {
		String sortedString = new String(charArray);
		ClassStorage.getInstance().getOutput().setText(sortedString);
	}
}
