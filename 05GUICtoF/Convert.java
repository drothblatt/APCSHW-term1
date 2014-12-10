import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window2 extends JFrame implements ActionListener{
    private Container pane;
    private Container text; //
    private Container button; //

    private JButton b;
    private JLabel l;
    private JTextField t;
    private JCheckBox c;
    private JCheckBox d;

    public Window2() {
	this.setTitle("GUI Farenheit and Celsius Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);


	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	b = new JButton("Convert");
	l = new JLabel("F and C Converter",null,JLabel.CENTER);
	t = new JTextField(10);
	c = new JRadioButton("to F");
	d = new JRadioButton("to C");
	pane.add(l);
	pane.add(b);
	pane.add(t);
	pane.add(c);
	pane.add(d);
    }

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	if (s.equals("doStuff")){
	    String t = text.getText();
	    if (){// radio button
		// F to C
	    } else if (){
		// C to f
	    }
	    text.setText(t);
	}
    }




    public static void main(String[] args) {
        Window2 g = new Window2();
        g.setVisible(true);
    }
}