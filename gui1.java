//necessary imports for gui api usage
import javax.swing.*;
import java.awt.*;

public class gui1
{
    public static void main(String[] args)
    {
        //call FormGui class constructor to create gui
        new FormGui();
    }
}

//gui code class
class FormGui extends javax.swing.JFrame
{
    //constructor creates gui when called
    public FormGui()
    {
        //call JFrame()
        super("Simple Submit Cancel Form");
        //set to terminate program on close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set JFrame's ContentPane to a JPanel, define layout and size of window
        JPanel panel = new JPanel();
        this.setContentPane(panel);
        panel.setLayout(new FlowLayout());
        this.setSize(340, 106);
        
        //add Component gui elements to panel
        panel.add(new JTextField(25));
        panel.add(new JButton("Submit"));
        panel.add(new JButton("Cancel"));

        //enable visibility
        this.setVisible(true);
    }
}