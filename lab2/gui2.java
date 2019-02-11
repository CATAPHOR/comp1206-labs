//imports for gui/event handling
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
		JCheckBox bold = new JCheckBox("Bold");
		JCheckBox italic = new JCheckBox("Italic");
        checkBoxGroup.add(bold);
        checkBoxGroup.add(italic);

        //initialise JRadioButtons for font selection; Times button checked by default on start
        JRadioButton times = new JRadioButton("Times");
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
		JTextField text = new JTextField(25);
        panel.add(text);
		JButton ok = new JButton("OK");
        panel.add(ok);
		
		//event-handling for JRadioButtons
		times.addActionListener(new TextButtonListener(text));
		helvetica.addActionListener(new TextButtonListener(text));
		courier.addActionListener(new TextButtonListener(text));

		//event-handling for OK button
		ok.addActionListener(e -> System.out.println(text.getText()));

		//event-handling for JCheckBoxes
		bold.addItemListener(new FontStyleListener(text));
		italic.addItemListener(new FontStyleListener(text));

		//click times JRadioButton to default it to selected as well as to set text
		times.doClick();
		
        //enable visibility
        this.setVisible(true);
    }
}

//event handler for JRadioButtons
class TextButtonListener implements ActionListener
{
	JTextField text;
	String buttonPressed;
	
	//take JRadioButton and JTextField to initialise class vars
	public TextButtonListener(JTextField text)
	{
		this.text = text;
	}
	
	//implement actionPerformed
	public void actionPerformed(ActionEvent e)
	{
		buttonPressed = ((JRadioButton) e.getSource()).getText();
		
		//check which button is selected; set text to reflect
		if (buttonPressed.equals("Times"))
		{
			text.setText("Times New Roman");
		}
		else if (buttonPressed.equals("Helvetica"))
		{
			text.setText("Helvetica");
		}
		else if (buttonPressed.equals("Courier"))
		{
			text.setText("Courier New");
		}
		
		//set JTextField's font to that of the selected JRadioButton; transfer font style
		text.setFont(new Font(text.getText(), text.getFont().getStyle(), 14));
	}
}

//event handler for JCheckBox
class FontStyleListener implements ItemListener
{
	JTextField text;
	int style;
	
	//constructor sets JTextField to class var
	public FontStyleListener(JTextField text)
	{
		this.text = text;
	}
	
	//implement itemStateChange
	public void itemStateChanged(ItemEvent e)
	{
		//initialise font style constant
		style = ((JCheckBox) e.getSource()).getText().equals("Bold") ? Font.BOLD : Font.ITALIC;
		
		//if selected, add font style constant to existing
		if (e.getStateChange() == ItemEvent.SELECTED)
		{
			text.setFont(text.getFont().deriveFont(text.getFont().getStyle() + style));
		}
		//if deselected, subtract font style constant from existing
		else if (e.getStateChange() == ItemEvent.DESELECTED)
		{
			text.setFont(text.getFont().deriveFont(text.getFont().getStyle() - style));
		}
	}
}
