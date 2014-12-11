import java.awt.event.*;
import javax.swing.*;
import java.awt.*; //needed for pane
import java.text.DecimalFormat; //for rounding
public class Converter extends JFrame implements ActionListener{
    private Container pane;
    private JButton b,clear;
    private JLabel l,m;
    private JTextField text, result;
    private Container buttons;
    private Container textyStuff;
    private JRadioButton toC, toF;

    public Converter() {
	this.setTitle("Celsius/Farenheit Converter");
	this.setSize(750,125);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));

	l = new JLabel("Temperature:",null,JLabel.CENTER);
	m = new JLabel("Converted Temperature:",null,JLabel.CENTER);
	b = new JButton("Convert!");
	clear = new JButton("Clear.");
	text = new JTextField(25);
	result = new JTextField(35);
	toC = new JRadioButton("To Celsius");
	toF = new JRadioButton("To Farenheit");

	// make the buttons call the actionListener
	b.setActionCommand("Convert!");
	b.addActionListener(this);
	clear.setActionCommand("delete");
	clear.addActionListener(this);

	buttons = new Container();
	buttons.setLayout(new GridLayout());
	buttons.add(clear);
	buttons.add(b);
	buttons.add(toC);
	buttons.add(toF);
 				
	textyStuff = new Container();
	textyStuff.setLayout(new GridLayout());
	textyStuff.add(l);
	textyStuff.add(text);
	textyStuff.add(m);
	textyStuff.add(result);

	//add the 2 containers
	pane.add(textyStuff);
	pane.add(buttons);
				
    }
    //look at which command is being executed, and choose an action
    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();


	if(action.equals("Convert!")){
	    String s = text.getText();
	    try{
		double t = Double.parseDouble(s);
		result.setText("");
		if (toC.isSelected() && toF.isSelected()){
		    result.setText("Must choose a conversion.");
		} else if(toC.isSelected()){
		    t = (t-32)*(5.0/9.0);
		    if ( (t % 1) == 0 ){
			int rT = (int)t;
			result.setText("" + rT);
		    } else{
			t = rounding(t);
			result.setText("" + t);		    
		    }	  
		} else if (toF.isSelected()){
		    t = t*(9.0/5.0) + 32;
		    if ( (t % 1) == 0 ){
			int rT = (int)t;
			result.setText("" + rT);
		    } else{
			t = rounding(t);
			result.setText("" + t);		    
		    }
		} else{
		    text.setText("");
		    result.setText("");
		}
	    } catch (Exception p){ //p for parseDouble();
		result.setText("Need number.");
	    }
	}
	if(action.equals("delete")){
	    text.setText("");
	    result.setText("");
	}
    }

    public double rounding(double x){
	DecimalFormat h = new DecimalFormat("#.#");
	return Double.valueOf(h.format(x));
    }
	

    public static void main(String[] args) {
	Converter c = new Converter();
	c.setVisible(true);
    }

}
