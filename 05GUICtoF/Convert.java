import java.awt.event.*;
import javax.swing.*;
import java.awt.*; //needed for pane
public class Gui2 extends JFrame implements ActionListener{
    private Container pane;
    private JButton b,clear;
    private JLabel l;
    private JTextField text;
    private Container buttons;
    private Container textyStuff;
    private JCheckBox box;

    public Gui2() {
	this.setTitle("Who is the doctor!");
	this.setSize(600,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));

	l = new JLabel("Text:",null,JLabel.CENTER);
	b = new JButton("Punctuate!");
	clear = new JButton("Exterminate!");
	text = new JTextField(40);
	box = new JCheckBox("!!!!");

	// make the buttons call the actionListener
	b.setActionCommand("addPeriod");
	b.addActionListener(this);
	clear.setActionCommand("delete");
	clear.addActionListener(this);

	buttons = new Container();
	buttons.setLayout(new FlowLayout());
	buttons.add(clear);
	buttons.add(b);
	buttons.add(box);
 				
	textyStuff = new Container();
	textyStuff.setLayout(new FlowLayout());
	textyStuff.add(l);
	textyStuff.add(text);

	//add the 2 containers
	pane.add(textyStuff);
	pane.add(buttons);
				
    }
    //look at which command is being executed, and choose an action
    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	//System.out.println(action);
	if(action.equals("addPeriod")){
	    String s = text.getText();
	    if(box.isSelected()){
		s+="!";
	    }else{
		s+=".";
	    }
	    text.setText(s);
	}
	if(action.equals("delete")){
	    text.setText("");
	}
    }

    public static void main(String[] args) {
	Gui2 g = new Gui2();
	g.setVisible(true);
    }

}
