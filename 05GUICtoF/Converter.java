import java.awt.event.*;
import javax.swing.*;
import java.awt.*; //needed for pane
public class Converter extends JFrame implements ActionListener{
    private Container pane;
    private JButton b,clear;
    private JLabel l,m;
    private JTextField text, result;
    private Container buttons;
    private Container textyStuff;
    private JRadioButton toC, toF;

    public Converter() {
	this.setTitle("Who is the doctor!");
	this.setSize(600,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));

	l = new JLabel("Temperature:",null,JLabel.CENTER);
	m = new JLabel("Converted Temperature:",null,JLabel.CENTER);
	b = new JButton("Convert!");
	clear = new JButton("Clear.");
	text = new JTextField(13);
	result = new JTextField(13);
	toC = new JRadioButton("To Celsius");
	toF = new JRadioButton("To Farenheit");

	// make the buttons call the actionListener
	b.setActionCommand("Convert!");
	b.addActionListener(this);
	clear.setActionCommand("delete");
	clear.addActionListener(this);

	buttons = new Container();
	buttons.setLayout(new FlowLayout());
	buttons.add(clear);
	buttons.add(b);
	buttons.add(toC);
	buttons.add(toF);
 				
	textyStuff = new Container();
	textyStuff.setLayout(new FlowLayout());
	textyStuff.add(l);
	textyStuff.add(m);
	textyStuff.add(text);
	textyStuff.add(result);

	//add the 2 containers
	pane.add(textyStuff);
	pane.add(buttons);
				
    }
    //look at which command is being executed, and choose an action
    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	//System.out.println(action);
	if(action.equals("Convert!")){
	    String s = text.getText();
	    try{
		int t = Integer.parseInt(s);
		if (toC.isSelected()){
		    s = "0";
		} else if (toF.isSelected()){
		    s = "1";
		}
		result.setText(s);
	    } catch (Exception p){ //p for parseint();
	    }
	}
	if(action.equals("delete")){
	    text.setText("");
	    result.setText("");
	}
    }

    public static void main(String[] args) {
	Converter c = new Converter();
	c.setVisible(true);
    }

}
