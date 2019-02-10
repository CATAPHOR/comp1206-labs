import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class gui1
{
    public static void main(String[] args)
    {
        new Window();
    }
}

class Window extends JFrame 
{
    int presses;
    
    public Window()
    {
        super("Increment/Resetter");
        Container panel = this.getContentPane();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new FlowLayout());

        this.presses = 0;

        JTextArea text = new JTextArea(1,20);
        text.setEditable(false);

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

        this.setSize(300,100);
       	this.setVisible(true);
    }
}

