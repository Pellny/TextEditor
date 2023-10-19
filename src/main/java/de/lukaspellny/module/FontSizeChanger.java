package de.lukaspellny.module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontSizeChanger extends JFrame {
    private JTextArea textArea;

    public FontSizeChanger(JTextArea textArea) {
        this.textArea = textArea;

        JLabel fontSizeLabel = new JLabel("Schriftgröße: ");
        JTextField fontSizeField = new JTextField(2);
        JButton changeButton = new JButton("Ändern");

        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int newSize = Integer.parseInt(fontSizeField.getText());
                    textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, newSize));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ungültige Schriftgröße");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(fontSizeLabel);
        panel.add(fontSizeField);
        panel.add(changeButton);

        this.add(panel);
        this.setTitle("Schriftgröße ändern");
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}