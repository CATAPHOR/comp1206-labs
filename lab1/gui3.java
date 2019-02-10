//necessary imports for gui api usage
import javax.swing.*;
import java.awt.*;

public class gui3
{
    public static void main(String[] args)
    {
        //call FontChooserGUI class constructor to create gui
        new FontChooserGUI2();
    }
}

//gui code class
class FontChooserGUI2 extends javax.swing.JFrame
{
    public FontChooserGUI2()
    {
        //call JFrame()
        super("Font Chooser");
        //set to terminate program on close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set JFrame's ContentPane to a JPanel, define layout and size of window
        JPanel panel = new JPanel();
        this.setContentPane(panel);
        panel.setLayout(new FlowLayout());
        this.setSize(555, 100);

        //create a GridLayout JPanel with two vertically stacked JCheckBoxes
        JPanel checkBoxGroup = new JPanel();
        checkBoxGroup.setLayout(new GridLayout(2, 1));
        checkBoxGroup.add(new JCheckBox("Bold"));
        checkBoxGroup.add(new JCheckBox("Italic"));

        //creat JComboBox Component to display a dropdown menu of fonts to choose from
        String[] fonts = {"Times", "Helvetica", "Courier"};
        JComboBox comboBoxFonts = new JComboBox<String>(fonts);
        comboBoxFonts.setSelectedIndex(0);

        //add button group JPanels, and other Components to content pane
        panel.add(checkBoxGroup);
        panel.add(comboBoxFonts);
        panel.add(new JTextField(25));
        panel.add(new JButton("OK"));

        //enable visibility
        this.setVisible(true);
    }
}