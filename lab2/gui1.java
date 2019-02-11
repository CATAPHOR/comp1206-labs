//imports for gui/event handling
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class gui1
{
    public static void main(String[] args)
    {
		//call Window() to create gui
        new Window();
    }
}

//gui code class
class Window extends JFrame 
{
	//number of presses since last reset
    int presses;
    
    public Window()
    {
		//JFrame() creates window
        super("Increment/Resetter");
		//create panel for ContentPane of window
        Container panel = this.getContentPane();
		//set to terminate program on window exit
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//set to flow layout
        panel.setLayout(new FlowLayout());

		//initialise number of presses
        this.presses = 0;

		//create un-editable JTextArea element
        JTextArea text = new JTextArea(1,20);
        text.setEditable(false);

		//create buttons, add necessary lambda/anonymous ActionListeners
        JButton increment = new JButton("Increment");
        JButton reset = new JButton("Reset");       
        panel.add(increment);
        panel.add(reset);
        panel.add(text);
        increment.addActionListener(e -> text.setText("Number of presses since reset/start: " + ++presses));
        reset.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            presses = 0;
                                            text.setText("Number of presses since reset/start: " + presses);
                                        }
                                    });

		//set size of window and make visible
        this.setSize(300,100);
       	this.setVisible(true);
    }
}

