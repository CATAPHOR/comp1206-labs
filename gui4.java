//necessary imports for gui api usage
import java.awt.*;
import javax.swing.*;

public class gui4
{
	public static void main(String[] args)
	{
		//call MusicGui class constructor to generate application UI 
		new MusicGui();
	}
}

//gui code class
class MusicGui extends JFrame
{
	public MusicGui()
	{
		//call JFrame()
		super("Music Player");
        //set to terminate program on close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        //set JFrame's ContentPane to a JPanel, define layout and size of window
        JPanel panel = new JPanel();
        this.setContentPane(panel);
        panel.setLayout(new BorderLayout());
        this.setSize(1280, 720);
        
        //create centre JPanel to hold further Compenents
        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BorderLayout());
        
        //create playlist JTabbedPane and place in centre of centrePanel
        JTabbedPane playlistPane = new JTabbedPane();
        Component playlist = makeTextPanel("playlist");
        playlistPane.addTab("playlist #1", playlist);
        centrePanel.add(playlistPane, BorderLayout.CENTER);
        
        //add placeholder JButtons to centrePanel
        centrePanel.add(new JButton("album art + waveform"), BorderLayout.NORTH);
        centrePanel.add(new JButton("EQ"), BorderLayout.SOUTH);
        
        //add add all placeholder 
        panel.add(makeTextPanel("music metadata"), BorderLayout.WEST);
        panel.add(centrePanel, BorderLayout.CENTER);
        panel.add(new JButton("player controls"), BorderLayout.NORTH);
        
        //enable visibility
        this.setVisible(true);
	}
	
	Component makeTextPanel(String text) 
	{
	    JPanel panel = new JPanel();
	    JLabel textFill = new JLabel(text);
	    textFill.setHorizontalAlignment(JLabel.CENTER);
	    panel.setLayout(new GridLayout(1, 1));
	    panel.add(textFill);
	    return panel;
	}

}