package GuiRockPaperScissors;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gameStarter implements ActionListener, KeyListener {
    JFrame mainFrame;

    JPanel panel1; //first panel inside mainFrame
    JPanel panel2; //second panel inside mainFrame

    JButton button1; // start button
    JButton button2; // exit button

    JLabel label1_1; // first label of panel1
    JLabel label1_2; // second label of panel1

    ImageIcon mainFrameIcon; 

    //
    gameFrameClass mainob = new gameFrameClass();

    public void GameRunner() {
        // ----------------------------------------------------------
        // setting up the first screen, the home screen of the game (mainFrame)

        mainFrame = new JFrame("Java - Rock Paper Scissors");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(450, 345);
        mainFrame.setFocusable(true);
        mainFrame.requestFocus();
        mainFrame.setLocation(458, 130);
        mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainFrame.setResizable(false);
        mainFrame.addKeyListener(this);
        mainFrameIcon = new ImageIcon("images/rock.png");
        mainFrame.setIconImage(mainFrameIcon.getImage());

        // -----------------------------------------------------------
        // setting up the first panel and the text (labels) inside it

        // first JPanel inside the first screen (mainFrame)
        panel1 = new JPanel();
        //
        label1_1 = new JLabel();

        // setting up the first panel
        panel1.setPreferredSize(new Dimension(450, 170));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panel1.setBorder(BorderFactory.createEtchedBorder());

        // setting up the labels
        label1_2 = new JLabel();
        label1_1.setText("Java Fundamentals");
        label1_2.setText("Rock Paper Scissors");
        label1_1.setFont(new Font(null, Font.BOLD, 40));
        label1_2.setFont(new Font(null, Font.BOLD, 30));

        // add labels to panel1 (first panel inside mainFrame)
        panel1.add(label1_1);
        panel1.add(label1_2);

        // add panel1 to main frame
        mainFrame.add(panel1);

        // ------------------------------------------------------
        // setting up the second panel and in this case the buttons inside it since I
        // don't have labels in it

        // second JPanel of the first screen (frame)
        panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(450, 130));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 15));

        // setting up the first button
        button1 = new JButton("Start");
        button1.setPreferredSize(new Dimension(120, 40));
        button1.setFont(new Font(null, Font.BOLD, 20));
        button1.setFocusable(false);
        button1.addActionListener(this);

        // setting up the second button
        button2 = new JButton("Exit");
        button2.setPreferredSize(new Dimension(120, 40));
        button2.setFont(new Font(null, Font.BOLD, 20));
        button2.setFocusable(false);
        button2.addActionListener(this);

        // adding buttons into panel2 (second panel in mainFrame)
        panel2.add(button1);
        panel2.add(button2);

        // adding the panel2 to mainFrame
        mainFrame.add(panel2);

        // -------------------------------------------------------

        // turning the mainFrame visibility true
        mainFrame.setVisible(true);
    }

    // ------------------------------------------------------------
    // creating an Override to when the user press some of the buttons, some actions
    // runs

    @Override
    public void actionPerformed(ActionEvent e) {
        // if the user press button1(start), remove panels 1 and 2
        if (e.getSource() == button1) {
            mainFrame.remove(panel1);
            mainFrame.remove(panel2);
            mainFrame.repaint();
            mainob.gameFrame();
            mainFrame.dispose();
            // repaint, dispose
        }
        // if user press button2(exit), we'll close the program
        if (e.getSource() == button2) {
            System.exit(0);
        }
    }

    // ------------------------------------------------------------
    // Override method for when some key are pressed, some actions runs

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            // when user type the keyChar of 's', we remove panels 1 and 2, and move to the
            // gameFrame
            case 's':
                mainFrame.remove(panel1);
                mainFrame.remove(panel2);

                // preparing to change the mainFrame
                mainFrame.repaint();

                // execute method gameFrame from gameFrameClass to change the frame to the
                // gameFrame
                mainob.gameFrame();

                // Remove the mainFrame
                mainFrame.dispose();
                break;

            // when user type 'e' quit the program
            case 'e':
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
