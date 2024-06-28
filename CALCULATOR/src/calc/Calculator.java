package calc;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
private static final Color WHITE = null;
	//	private static final boolean WHITE = true;
	JFrame frame;
	JTextField textfield;
	JButton[]numberButtons =new JButton[10];
	JButton[]functionButtons=new JButton[10];
	JButton addButton,subButton,copyButton,pasteButton,mulButton,divButton;
	
	JButton decButton,equButton,delButton,clrButton;
	JPanel panel;
	
	
	
Font myFont=new Font("Monospaced",Font.BOLD,27);
double num1 =0,num2=0,result=0;
String operator;

Calculator() {
	frame=new JFrame("CALCULATOR");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(420,550);
	frame.setLayout(null);
	
	
	textfield =new JTextField();
	textfield.setBounds(50,25,300,50);
	textfield.setFont(myFont);
	frame.setFocusable(true);
	copyButton=new JButton("COPY");
	pasteButton=new JButton("PASTE");
	addButton = new JButton("+");
	subButton = new JButton("-");
	mulButton = new JButton("*");
	divButton = new JButton("/");
	decButton = new JButton(".");
	equButton = new JButton("=");
	delButton = new JButton("DELETE");
	clrButton = new JButton("CLEAR");
	
	
	functionButtons[0]= copyButton;
	functionButtons[1]= pasteButton;
	functionButtons[2]=addButton;
	functionButtons[3]=subButton;
	functionButtons[4]=mulButton;
	functionButtons[5]=divButton;
	functionButtons[6]=decButton;
	functionButtons[7]=equButton;
	functionButtons[8]=delButton;
	functionButtons[9]=clrButton;
	
	for(int i=0;i<10;i++) {
		functionButtons[i].addActionListener(this);
		functionButtons[i].setFont(myFont);
		functionButtons[i].setFocusable(false);
	}
	
	for(int i=0;i<10;i++) {
		numberButtons[i]=new JButton(String.valueOf(i));
		numberButtons[i].addActionListener(this);
		numberButtons[i].setFont(myFont);
		numberButtons[i].setFocusable(false);

	}
	copyButton.setBounds(50,430,115,40);
	pasteButton.setBounds(220,430,115,40);
	delButton.setBounds(220,100,130,40);
	clrButton.setBounds(50,100,115,40);
	
	
	panel =new JPanel();
	panel.setBounds(50,150,300,270);
	panel.setLayout(new GridLayout(4,4,10,10));
	panel.setBackground(Color.GRAY);
	
	copyButton.setBackground(Color.white);
	pasteButton.setBackground(Color.white);
	delButton.setBackground(Color.white);
	clrButton.setBackground(Color.white);
//	ADDING NUMBER BUTTONS 
	panel.add(numberButtons[1]);
	panel.add(numberButtons[2]);
	panel.add(numberButtons[3]);
	panel.add(addButton);
	panel.add(numberButtons[4]);
	panel.add(numberButtons[5]);
	panel.add(numberButtons[6]);
	panel.add(subButton);
	
	panel.add(numberButtons[7]);
	panel.add(numberButtons[8]);
	panel.add(numberButtons[9]);
	panel.add(mulButton);
	panel.add(decButton);
	panel.add(numberButtons[0]);
	panel.add(equButton);
	panel.add(divButton);
	
	
	
	frame.add(copyButton);
	frame.add(pasteButton);
	frame.add(textfield);
	frame.add(delButton);
	frame.add(clrButton);
	frame.setVisible(true);
	frame.add(panel);
	
	
	
	
	frame.setVisible(true);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Calculator calc=new Calculator();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(Integer.toString(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1=Double.parseDouble(textfield.getText());
			operator ="+";
			textfield.setText("");
		}
		if(e.getSource() == subButton) {
			num1=Double.parseDouble(textfield.getText());
			operator ="-";
			textfield.setText("");
		}
			if(e.getSource() == mulButton) {
				num1=Double.parseDouble(textfield.getText());
				operator ="*";
				textfield.setText("");
			}
			if(e.getSource() == divButton) {
				num1=Double.parseDouble(textfield.getText());
				operator ="/";
				textfield.setText("");
			}
			if(e.getSource()==equButton) {
				num2=Double.parseDouble(textfield.getText());
				
			
			
			switch(operator) {
			case"+":
				result=num1+num2;
				break;
			case"-":
				result=num1-num2;
				break;
			case"*":
				result=num1*num2;
				break;
			case "/":
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string =textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
			textfield.setText(textfield.getText()+string.charAt(i));	
			}
			}
			
	}

}
