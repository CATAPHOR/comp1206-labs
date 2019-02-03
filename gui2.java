//necessary imports for gui api usage
import javax.swing.*;
import java.awt.*;

public class gui2
{
    public static void main(String[] args)
    {
        //call FontChooserGUI class constructor to create gui
        new FontChooserGUI();
    }
}

//gui code class
class FontChooserGUI extends javax.swing.JFrame
{
    public FontChooserGUI()
    {
        //call JFrame()
        super("Font Chooser");
        //set to terminate program on close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set JFrame's ContentPane to a JPanel, define layout and size of window
        JPanel panel = new JPanel();
        this.setContentPane(panel);
        panel.setLayout(new FlowLayout());
        this.setSize(555, 123);

        //create a GridLayout JPanel with two vertically stacked JCheckBoxes
        JPanel checkBoxGroup = new JPanel();
        checkBoxGroup.setLayout(new GridLayout(2, 1));
        checkBoxGroup.add(new JCheckBox("Bold"));
        checkBoxGroup.add(new JCheckBox("Italic"));

        //initialise JRadioButtons for font selection; Times button checked by default on start
        JRadioButton times = new JRadioButton("Times", true);
        JRadioButton helvetica = new JRadioButton("Helvetica");
        JRadioButton courier = new JRadioButton("Courier");

        //add JRadioButtons to ButtonGroup to make selection of each element mutually exclusive
        ButtonGroup fonts = new ButtonGroup();
        fonts.add(times);
        fonts.add(helvetica);
        fonts.add(courier);

        //create a GridLayout JPanel with the JRadioButtons vertically stacked
        JPanel radioButtonGroup = new JPanel();
        radioButtonGroup.setLayout(new GridLayout(3, 1));
        radioButtonGroup.add(times);
        radioButtonGroup.add(helvetica);
        radioButtonGroup.add(courier);

        //add button group JPanels, and other Components to content pane
        panel.add(checkBoxGroup);
        panel.add(radioButtonGroup);
        panel.add(new JTextField(25));
        panel.add(new JButton("OK"));

        //enable visibility
        this.setVisible(true);
    }
}