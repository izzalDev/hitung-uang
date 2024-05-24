package app;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private static Uang uang;
    private static JFrame frame;
    private static JLabel label;
    private static JTextField textField;
    private static JTextArea resultArea;
    private static JButton button;
    private static JPanel panel1, panel2;

    public App() {
        frame = new JFrame("Aplikasi Pecahan Uang");
        label = new JLabel("Masukkan nominal uang:");
        textField = new JTextField();
        button = new JButton("Hitung Pecahan");
        resultArea = new JTextArea();
        panel1 = new JPanel(new GridLayout(3,1));
        panel2 = new JPanel(new BorderLayout(10, 10));
        uang = new Uang(0L);
    }

    public static void main(String[] args) {
        new App();
        frame.setSize(300, 500);
        frame.setMinimumSize(new Dimension(300, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);

        panel1.setBorder(new EmptyBorder(10,10,10,10));
        panel2.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel1.add(label);
        panel1.add(textField);
        panel1.add(button);
        panel2.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uang.setNominal(Long.parseLong(textField.getText()));
                resultArea.setText(uang.getPecahan());
            }
        });

        frame.setVisible(true);
    }
}