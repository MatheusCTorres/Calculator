import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numBtn = new JButton[10];
    JButton[] functionBtn = new JButton[9];
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton decBtn, equBtn, delBtn, clrBtn, negBtn;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, res = 0;
    String op;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);   // no longer editable

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        decBtn = new JButton(".");
        equBtn = new JButton("=");
        delBtn = new JButton("del");
        clrBtn = new JButton("clr");
        negBtn = new JButton("(-)");

        functionBtn[0] = addBtn;
        functionBtn[1] = subBtn;
        functionBtn[2] = mulBtn;
        functionBtn[3] = divBtn;
        functionBtn[4] = decBtn;
        functionBtn[5] = equBtn;
        functionBtn[6] = delBtn;
        functionBtn[7] = clrBtn;
        functionBtn[8] = negBtn;

        for(int i = 0; i<9; i++){
            functionBtn[i].addActionListener(this);
            functionBtn[i].setFont(myFont);
            functionBtn[i].setFocusable(false);     //remove the outline from the btn
        }

        for(int i = 0; i<10; i++){
            numBtn[i] = new JButton(String.valueOf(i)); // set text to the btn
            numBtn[i].addActionListener(this);
            numBtn[i].setFont(myFont);
            numBtn[i].setFocusable(false);
        }

        delBtn.setBounds(50, 430, 100, 50);
        clrBtn.setBounds(150, 430, 100, 50);
        negBtn.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));  // 4x4 and gag btw the btns is 10x10
        panel.setBackground(Color.WHITE);
        panel.add(numBtn[1]);
        panel.add(numBtn[2]);
        panel.add(numBtn[3]);
        panel.add(addBtn);

        panel.add(numBtn[4]);
        panel.add(numBtn[5]);
        panel.add(numBtn[6]);
        panel.add(subBtn);

        panel.add(numBtn[7]);
        panel.add(numBtn[8]);
        panel.add(numBtn[9]);
        panel.add(mulBtn);
        panel.add(decBtn);
        panel.add(numBtn[0]);
        panel.add(equBtn);
        panel.add(divBtn);

        frame.add(negBtn);
        frame.add(panel);
        frame.add(delBtn);
        frame.add(clrBtn);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i<10; i++){
            if(e.getSource() == numBtn[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decBtn){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == addBtn){
            num1 = Double.parseDouble(textField.getText());
            op = "+";
            textField.setText("");
        }

        if(e.getSource() == subBtn){
            num1 = Double.parseDouble(textField.getText());
            op = "-";
            textField.setText("");
        }

        if(e.getSource() == mulBtn){
            num1 = Double.parseDouble(textField.getText());
            op = "*";
            textField.setText("");
        }

        if(e.getSource() == divBtn){
            num1 = Double.parseDouble(textField.getText());
            op = "/";
            textField.setText("");
        }

        if(e.getSource() == equBtn){
            num2 = Double.parseDouble(textField.getText());
            switch(op){
                case "+":
                    res = num1+num2;
                    break;
                case "-":
                    res = num1-num2;
                    break;
                case "*":
                    res = num1*num2;
                    break;
                case "/":
                    res = num1/num2;
                    break;
            }
            textField.setText(String.valueOf(res));
            num1 = res;     // in case if we can use the same result
        }
        if(e.getSource() == clrBtn){
            textField.setText("");
        }
        if(e.getSource() == delBtn){
            String str = textField.getText();
            textField.setText("");

            for(int i = 0; i<str.length()-1;i++){
                textField.setText(textField.getText()+str.charAt(i));   // Will delete the last num
            }
        }

        if(e.getSource() == negBtn){
            Double tmp = Double.parseDouble(textField.getText());
            tmp*=-1;
            textField.setText(String.valueOf(tmp));
        }

    }
}
