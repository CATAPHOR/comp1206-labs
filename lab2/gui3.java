//imports for gui/event handling
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class gui3
{
    public static void main(String[] args)
    {
         //call MouseProgram class constructor to create gui/application
        new MouseProgram();
    }
}

//gui/app code class
class MouseProgram extends JFrame
{
    //class vars
    Random r;
    String s1, s2, s3;
    JLabel mLabel;
    JLayeredPane mPanel;

    //constructor, contains gui etc.
    public MouseProgram()
    {
        //call JFrame()
        super("Mouse Tracking");
        //set to terminate program on close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //assign random object to class var
        r = new Random();

        //set JFrame's ContentPane to a JPanel, define layout and size of window
        JPanel panel = new JPanel();
        this.setContentPane(panel);
        panel.setLayout(new BorderLayout());
        this.setSize(1000, 1000);

        //create layered pane for mouse motion application (allows JPanels to change displayed layer), set it to centre of window's BorderLayout
        mPanel = new JLayeredPane();
        mPanel.setLayout(null);
        panel.add(mPanel, BorderLayout.CENTER);

        //create panels, add to mPanel, and give each a unique colour
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        mPanel.add(p1);
        mPanel.add(p2);
        mPanel.add(p3);
        p1.setBackground(Color.RED);
        p2.setBackground(Color.GREEN);
        p3.setBackground(Color.BLUE);

        //set bounds of JPanels to random values to create coloured blocks
        p1.setBounds(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));
        p2.setBounds(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));
        p3.setBounds(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));

        //add panel to south to place label in
        JPanel lPanel = new JPanel();
        lPanel.setLayout(new FlowLayout());
        panel.add(lPanel, BorderLayout.SOUTH);

        //default string vals
        this.s1 = "0, 0";
        this.s2 = "0, 0";
        this.s3 = "0, 0";

        //create JLabel to display mouse coordinates relative to each JPanel
        this.mLabel = new JLabel("R: " + s1 + " G: " + s2 + " B: " + s3);
        lPanel.add(mLabel);

        //event-handling; add mouse listeners to JPanels
        p1.addMouseMotionListener(new MouseListener());
        p2.addMouseMotionListener(new MouseListener());
        p3.addMouseMotionListener(new MouseListener());

        p1.addMouseListener(new PanelMover());
        p2.addMouseListener(new PanelMover());
        p3.addMouseListener(new PanelMover());

        //enable visibility
        this.setVisible(true);
    }

    //declare and initialise variables to hold x and y positions of JPanel and mouseclick for drag events
    int px = 0;
    int py = 0;
    int mx = 0;
    int my = 0;

    //nested class updates string constituents of mLabel text then updates
    class MouseListener extends MouseAdapter
    {
        //override mouseMoved to monitor mouse hover movement
        public void mouseMoved(MouseEvent e)
        {
            //store colour of JPanel which generated MouseEvent
            Color bg = ((JPanel) e.getSource()).getBackground();
            //update appropriate string based on colour
            if (bg == Color.RED)
            {
                s1 = e.getX() + ", " + e.getY();
            }
            else if (bg == Color.GREEN)
            {
                s2 = e.getX() + ", " + e.getY();
            }
            else if (bg == Color.BLUE)
            {
                s3 = e.getX() + ", " + e.getY();
            }

            //update mLabel
            mLabel.setText("R: " + s1 + " G: " + s2 + " B: " + s3);
        }

        //mouse dragging will succeed a mousepress event, where the four vars are set; used to calculate where to reposition JPanel to
        public void mouseDragged(MouseEvent e) 
        {
            //set location to the original panel location + (location of mouse - original mousepress location) for x and y
            ((JPanel) e.getSource()).setLocation(px + (e.getLocationOnScreen().x - mx), py + (e.getLocationOnScreen().y - my));
        }
    }

    //panelmover generates the four variables required to accurately calculate the movement coordinates for JPanels
    class PanelMover extends MouseAdapter
    {
        //drag boolean used to control the timing so one instance of a mouse press event is isolated
        boolean drag = false;

        //mousepress isolates one event, gets x,y positions of panel and mousepress
        public void mousePressed(MouseEvent e) 
        {
            if (!this.drag)
            {
                //JPanel x, y positions
                px = ((JPanel) e.getSource()).getX();
                py = ((JPanel) e.getSource()).getY();
                //mousePress event x, y positions
                mx = e.getLocationOnScreen().x;
                my = e.getLocationOnScreen().y;
                
                //move pressed JPanel to the front of mPanel
                mPanel.moveToFront((JPanel) e.getSource());
            }
            //set drag to false to prevent any more coordinate gets until mouse is released
            this.drag = true;
        }

        //reset drag boolean to false once drag event concludes (mouse is released)
        public void mouseReleased(MouseEvent e)
        {
            this.drag = false;
        }
    }
}