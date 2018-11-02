import java.lang.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JOptionPane;


public class Calculator implements ActionListener {

    private JTextField display;
    private String input = "";
    private JFrame cal;

    public Calculator () {

        cal = new JFrame("A Calculator");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);

        JPanel sysPanel = new JPanel();
        // default flow layout
        topPanel.add(sysPanel, BorderLayout.SOUTH);

        topPanel.add(Box.createRigidArea(new Dimension(300, 25)), BorderLayout.NORTH);

        display = new JTextField(20);
        topPanel.add(display, BorderLayout.CENTER);

        addButton(sysPanel, "About");
        addButton(sysPanel, "Exit");
        addButton(sysPanel, "Clear");

        JPanel buttonPanel = new JPanel();
        // flow layout

        JPanel numberGrid = new JPanel();
        numberGrid.setLayout(new GridLayout(4, 3));

        for (int i = 9; i >= 0; i--) {
            Integer currentNumber = i;
            addButton(numberGrid, currentNumber.toString());
        }
        addButton(numberGrid, ".");
        addButton(numberGrid, "-");
        buttonPanel.add(numberGrid);

        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(new GridLayout(5, 1));
        addButton(operationPanel, "/");
        addButton(operationPanel, "*");
        addButton(operationPanel, "-");
        addButton(operationPanel, "+");
        addButton(operationPanel, "=");
        buttonPanel.add(operationPanel);

        mainPanel.add(buttonPanel);
        cal.add(mainPanel);

        cal.setSize(300, 400);
        // cal.setDefaultLookAndFeelDecorated(true);
        cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cal.setVisible(true);

    }

    private void addButton (JPanel pPanel, String pString) {
        JButton button = new JButton(pString);
        button.addActionListener(this);
        pPanel.add(button);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            System.exit(-1);
        } else if (e.getActionCommand().equals("About")) {
            JOptionPane popUp = new JOptionPane();
            String message = "JACalculator \n" +
                    "https://github.com/martintc/JACalculator";
            popUp.showMessageDialog(cal, message);
        } else if (e.getActionCommand().equals("Clear")) {
            input = "";
            display.setText(input);
        } else if (e.getActionCommand().equals("=")) {
            ParseCalculation calculate = new ParseCalculation(input);
            if (calculate.run()) {
                Double answer = calculate.getAnswer();
                display.setText(answer.toString());
            } else {
                display.setText("Error");
            }
        } else {
            String buttonInput = e.getActionCommand();
            if (buttonInput.equals("+") || buttonInput.equals("-") || buttonInput.equals("/") || buttonInput.equals("*")) {
                input = input + " " + buttonInput + " ";
            } else {
                input = input + buttonInput;
            }
            display.setText(input);
        }


    }

}