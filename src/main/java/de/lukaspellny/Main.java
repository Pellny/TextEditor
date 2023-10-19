package de.lukaspellny;

import de.lukaspellny.module.FontSizeChanger;
import de.lukaspellny.module.TextEditor;
import de.lukaspellny.module.TextEditorAutoComplete;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SwingUtilities.invokeLater(() -> {
            TextEditor textEditor = new TextEditor();
            // FontSizeChanger fontSizeChanger = new FontSizeChanger(new JTextArea());
            // TextEditorAutoComplete text = new TextEditorAutoComplete();
        });
    }
}