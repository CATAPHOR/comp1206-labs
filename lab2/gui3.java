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

        //create panel for mouse motion application, set it to centre of window's BorderLayout
        JPanel mPanel = new JPanel();
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

        p1.addMouseMotionListener(new PanelMover(p1));
        p2.addMouseMotionListener(new PanelMover(p2));
        p3.addMouseMotionListener(new PanelMover(p3));

        //enable visibility
        this.setVisible(true);
    }

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
    }
}

class PanelMover extends MouseAdapter
{
    JPanel panel;
    int x, y;
    boolean drag = false;
    
    public PanelMover(JPanel panel)
    {
        this.panel = panel;
    }

    public void mousePressed(MouseEvent e) 
    {
        this.x = e.getX();
        this.y = e.getY();
    }

    public void mouseDragged(MouseEvent e) 
    {
        panel.setLocation(e.getLocationOnScreen().x - this.x, e.getLocationOnScreen().y - this.y);
    }
}

/* public void handleDrag(final JPanel panel){
    panel.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent me) {
             x = me.getX();
             y = me.getY();
        }
    });
    panel.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent me) {
            me.translatePoint(me.getComponent().getLocation().x-x, me.getComponent().getLocation().y-y);
            panel.setLocation(me.getX(), me.getY());
        }
    });
}
*/