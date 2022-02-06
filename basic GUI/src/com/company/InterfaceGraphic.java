package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGraphic implements ActionListener {
    private int count = 0;
    JFrame jFrame;
    JPanel jPanel;
    JLabel jLabel;
    JButton jButton;
    JButton jButtonDialogue;

    public InterfaceGraphic() {
        jFrame = new JFrame();

        jPanel = new JPanel();
        jButton = new JButton("KLIKNIJ MNIE!");
        jButton.addActionListener(this);
        jButtonDialogue = new JButton("KLIKNIJ MNIE TEŻ!");
        jButtonDialogue.addActionListener(new addMore());
        jLabel = new JLabel("kliknięcia: 0");


        jPanel.setBorder(BorderFactory.createEmptyBorder(100, 150, 100, 150));
        jPanel.add(jButton);
        jPanel.add(jButtonDialogue);
        jPanel.add(jLabel);
        jPanel.setLayout(new GridLayout(0, 1));

        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setTitle("GUI");
        jFrame.pack();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        jLabel.setText("kliknięcia: " + count);
    }

    class addMore implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            {
                String[] opcje = {"10", "50", "100"};
                int x = JOptionPane.showOptionDialog(null, "ile kliknięć dodać?", "Dodawanie", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcje, 0);
                switch (x) {
                    case 0:
                        count = count + 10;
                        break;
                    case 1:
                        count = count + 50;
                        break;
                    case 2:
                        count = count + 100;
                        break;
                }
                jLabel.setText("kliknięcia: " + count);
            }
        }
    }
}
