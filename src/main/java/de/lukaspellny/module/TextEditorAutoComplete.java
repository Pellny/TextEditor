package de.lukaspellny.module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TextEditorAutoComplete extends JFrame {
    private JTextArea textArea;
    private JComboBox<String> autoCompleteComboBox;

    public TextEditorAutoComplete() {
        textArea = new JTextArea();
        autoCompleteComboBox = new JComboBox<>();

        List<String> knownWords = new ArrayList<>();
        knownWords.add("Hallo");
        knownWords.add("Welt");
        knownWords.add("Java");
        knownWords.add("Programmieren");

        for (String word : knownWords) {
            autoCompleteComboBox.addItem(word);
        }

        autoCompleteComboBox.setEditable(true);
        autoCompleteComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedWord = autoCompleteComboBox.getSelectedItem().toString();
                appendText(selectedWord);
            }
        });

        JButton clearButton = new JButton("Löschen");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(autoCompleteComboBox);
        controlPanel.add(clearButton);

        add(controlPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setTitle("Text Editor mit Autovervollständigung");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void appendText(String text) {
        String currentText = textArea.getText();
        textArea.setText(currentText + text + " ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextEditorAutoComplete());
    }
}