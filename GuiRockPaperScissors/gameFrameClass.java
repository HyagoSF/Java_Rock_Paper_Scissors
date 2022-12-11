package GuiRockPaperScissors;

//importing swing to create the UI
import javax.swing.*;

// importing the Abstract Window Toolkit (AWT) is Java's original platform-dependent windowing, graphics, and user-interface widget toolkit, preceding Swing.
import java.awt.*;
import java.awt.event.*;

//importing Random to create a Random number
import java.util.Random;

public class gameFrameClass implements ActionListener, ComponentListener {

    int Xlocation = 458; // Position X where the GameFrame will start
    int Ylocation = 130; // Position Y where the GameFrame will start

    int rounds = 1; // starter round
    int userScore = 0; // starter User Score
    int ComScore = 0; // starter Computer Score
    int userinput; // defining the user input
    int Cominput; // defining the computer input
    String winner;
    String finalwinner;
    String button5Text = "Next Round";

    JFrame gameFrame = new JFrame("Rock paper Scissors");
    JScrollPane scrollPane;

    // Instantiating the panels inside the window
    JPanel panel1; // panel to count the rounds

    JPanel panel2; // panel to put the user buttons options

    JPanel panel3; // to put the labels of "You showed" and "COM showed" inside it
    JPanel panel3_1;
    JPanel panel3_2;

    JPanel panel4; // panel to show who won the round in the gameFrame, and in the last frame shows the score of each player(player and the COM)

    JPanel panel5;  // to show the button and label to go to the next round
    JPanel panel5_1;
    JPanel panel5_2;

    JLabel label1; // to show the rounds

    JLabel label2; // starts just saying to the user choose one button between rock, paper and
                   // scissors, and when the game ends it turns to show the label of who won

    JLabel label3_1; // label "You showed"
    JLabel label3_2; // label to show the icon of the COM play
    JLabel label3_3; // label "COM showed"
    JLabel label3_4; // Label to show the Computer choice Icon

    JLabel label4; // to label who is the winner of the round

    JLabel label5_1; // to label the winner and the results

    // instantiating the all the Buttons
    JButton button1l2_Rock;
    JButton button2l2_Paper;
    JButton button3l2_Scissors;
    JButton button1l5;
    JButton buttonPA1;
    JButton buttonPA2;

    // intantiating the icons
    ImageIcon userIcon;
    ImageIcon comIcon;
    ImageIcon frameIcon;

    public void gameFrame() {
        // ------------------Main Body--------------------------
        // Frame of the game screen

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(450, 480);
        gameFrame.setLocation(Xlocation, Ylocation);
        gameFrame.addComponentListener(this);
        gameFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        gameFrame.setResizable(false);
        frameIcon = new ImageIcon("images/paper.png");
        gameFrame.setIconImage(frameIcon.getImage());
        // -----------------------------------------------------
        // Creating and setting up a panel1 to count the rounds

        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(450, 93));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        panel1.setBorder(BorderFactory.createEtchedBorder());

        // Creating a JLabel with text to show the rounds
        label1 = new JLabel();
        label1.setText("ROUND:" + rounds);
        label1.setFont(new Font(null, Font.BOLD, 38));

        // add label1 to panel1
        panel1.add(label1);

        // -------------------------------------------------------
        // Creating and setting up a panel2 to put some buttons to the user choose his
        // option

        panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(450, 60));
        panel2.setLayout(new FlowLayout(FlowLayout.LEADING, 3, 15));
        panel2.setBorder(BorderFactory.createEtchedBorder());

        label2 = new JLabel();
        label2.setText("Choose One:");
        label2.setFont(new Font(null, Font.BOLD, 18));

        button1l2_Rock = new JButton("ROCK");
        button2l2_Paper = new JButton("PAPER");
        button3l2_Scissors = new JButton("SCISSORS");

        button1l2_Rock.setFont(new Font("Comic Sans", Font.BOLD, 16));
        button2l2_Paper.setFont(new Font("Comic Sans", Font.BOLD, 16));
        button3l2_Scissors.setFont(new Font("Comic Sans", Font.BOLD, 16));

        button1l2_Rock.addActionListener(this);
        button2l2_Paper.addActionListener(this);
        button3l2_Scissors.addActionListener(this);

        button1l2_Rock.setFocusable(false);
        button2l2_Paper.setFocusable(false);
        button3l2_Scissors.setFocusable(false);

        panel2.add(label2);
        panel2.add(button1l2_Rock);
        panel2.add(button2l2_Paper);
        panel2.add(button3l2_Scissors);

        // -------------------------------------------------------
        // Panel3 to put the labels of who played each play

        panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(450, 150));
        panel3.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));

        // First panel to label
        panel3_1 = new JPanel();
        panel3_1.setBorder(BorderFactory.createEtchedBorder());
        panel3_1.setPreferredSize(new Dimension(225, 150));
        panel3_1.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 15));

        // Label inside this panel
        label3_1 = new JLabel();
        label3_1.setText("You Showed:");
        label3_1.setFont(new Font("Ubuntu", Font.BOLD, 17));

        label3_2 = new JLabel();

        panel3_1.add(label3_1);
        panel3_1.add(label3_2);

        // Second panel to label
        panel3_2 = new JPanel();
        panel3_2.setBorder(BorderFactory.createEtchedBorder());
        panel3_2.setPreferredSize(new Dimension(225, 150));
        panel3_2.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 15));

        // Label inside this second panel
        label3_3 = new JLabel();
        label3_3.setText("COM Showed:");
        label3_3.setFont(new Font("Ubuntu", Font.BOLD, 17));

        label3_4 = new JLabel(); // Label to show the Computer choice Icon

        panel3_2.add(label3_3);
        panel3_2.add(label3_4);

        // -------------------------------------------------------

        panel3.add(panel3_1);
        panel3.add(panel3_2);

        // -------------------------------------------------------

        panel4 = new JPanel();
        panel4.setBorder(BorderFactory.createEtchedBorder());
        panel4.setPreferredSize(new Dimension(450, 60));
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        label4 = new JLabel();
        label4.setFont(new Font("Ubuntu", Font.BOLD, 30));

        panel4.add(label4);

        // -------------------------------------------------------

        panel5 = new JPanel();
        panel5.setPreferredSize(new Dimension(450, 60));
        panel5.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));

        // -------------------------------------------------------

        panel5_1 = new JPanel();
        panel5_1.setBorder(BorderFactory.createEtchedBorder());
        panel5_1.setPreferredSize(new Dimension(225, 60));
        panel5_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));

        label5_1 = new JLabel();
        label5_1.setFont(new Font("Ubuntu", Font.BOLD, 20));

        panel5_1.add(label5_1);
        // -------------------------------------------------------

        panel5_2 = new JPanel();
        panel5_2.setBorder(BorderFactory.createEtchedBorder());
        panel5_2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panel5_2.setPreferredSize(new Dimension(225, 60));

        button1l5 = new JButton();
        button1l5.setText(button5Text);
        button1l5.setPreferredSize(new Dimension(150, 40));
        button1l5.setFont(new Font("Comic Sans", Font.BOLD, 17));
        button1l5.setEnabled(false);
        button1l5.addActionListener(this);
        button1l5.setFocusable(false);
        panel5_2.add(button1l5);
        // -------------------------------------------------------

        panel5.add(panel5_1);
        panel5.add(panel5_2);

        // -------------------------------------------------------

        gameFrame.add(panel1);
        gameFrame.add(panel2);
        gameFrame.add(panel3);
        gameFrame.add(panel4);
        gameFrame.add(panel5);

        gameFrame.setVisible(true);

        // ----------------------------------------------------

    }
    // end of gameFrame
    // ==========================================================

                public void finalFrame() {
                    // ------------------Final Body--------------------------
                    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gameFrame.setSize(450, 350);
                    gameFrame.setLocation(Xlocation, Ylocation);
                    gameFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                    gameFrame.setResizable(false);
                    frameIcon = new ImageIcon("images/scissors.png");
                    gameFrame.setIconImage(frameIcon.getImage());
                    // ------------------------------------------------------

                    panel1 = new JPanel();
                    panel1.setPreferredSize(new Dimension(450, 100));
                    panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
                    panel1.setBorder(BorderFactory.createEtchedBorder());

                    label1 = new JLabel();
                    label1.setText("GAME OVER");
                    label1.setFont(new Font(null, Font.BOLD, 48));
                    gameFrame.add(panel1);
                    panel1.add(label1);

                    // ------------------------------------------------------

                    panel2 = new JPanel();
                    panel2.setPreferredSize(new Dimension(450, 70));
                    panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 8));
                    panel2.setBorder(BorderFactory.createEtchedBorder());

                    label2 = new JLabel();
                    label2.setFont(new Font("Ubuntu", Font.ITALIC, 45));

                    panel2.add(label2);
                    gameFrame.add(panel2);

                    // -------------------------------------------------------

                    panel4 = new JPanel();
                    panel4.setBorder(BorderFactory.createEtchedBorder());
                    panel4.setPreferredSize(new Dimension(450, 60));
                    panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));

                    label4 = new JLabel();
                    label4.setFont(new Font("Ubuntu", Font.BOLD, 25));

                    panel4.add(label4);
                    gameFrame.add(panel4);
                    // ------------------------------------------------------
                    panel5 = new JPanel();
                    panel5.setPreferredSize(new Dimension(450, 60));
                    panel5.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));

                    // -------------------------------------------------------

                    panel5_1 = new JPanel();
                    panel5_1.setBorder(BorderFactory.createEtchedBorder());
                    panel5_1.setPreferredSize(new Dimension(225, 60));
                    panel5_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

                    buttonPA1 = new JButton("Play Again");
                    buttonPA1.setPreferredSize(new Dimension(150, 40));
                    buttonPA1.setFont(new Font("Comic Sans", Font.BOLD, 17));
                    buttonPA1.addActionListener(this);
                    buttonPA1.setFocusable(false);
                    panel5_1.add(buttonPA1);
                    // -------------------------------------------------------

                    panel5_2 = new JPanel();
                    panel5_2.setBorder(BorderFactory.createEtchedBorder());
                    panel5_2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
                    panel5_2.setPreferredSize(new Dimension(225, 60));

                    buttonPA2 = new JButton("Exit");
                    buttonPA2.setPreferredSize(new Dimension(150, 40));
                    buttonPA2.setFont(new Font("Comic Sans", Font.BOLD, 17));
                    buttonPA2.addActionListener(this);
                    buttonPA2.setFocusable(false);
                    panel5_2.add(buttonPA2);

                    panel5.add(panel5_1);
                    panel5.add(panel5_2);
                    gameFrame.add(panel5);

                    // -------------------------------------------------------

                    gameFrame.setVisible(true);
                }
                // end of finalFrame
                // ==========================================================

    // -----------------Location Changer-------------------------
    // to change the location of components when the window gameFrame changes

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        Xlocation = gameFrame.getX();
        Ylocation = gameFrame.getY();
        gameFrame.setLocation(Xlocation, Ylocation);
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    // ===================ButtonListener========================

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1l2_Rock) {
            // rock button

            userinput = 1;
            userIcon = new ImageIcon("images/rock2.png");
            label3_2.setIcon(userIcon);
            comGen();
            checker();
            button1l5.setEnabled(true);
            button1l2_Rock.setEnabled(false);
            button2l2_Paper.setEnabled(false);
            button3l2_Scissors.setEnabled(false);
            button1l5.setText(button5Text);

        }
        if (e.getSource() == button2l2_Paper) {
            // paper button

            userinput = 2;
            userIcon = new ImageIcon("images/paper2.png");
            label3_2.setIcon(userIcon);
            comGen();
            checker();
            button1l5.setEnabled(true);
            button1l2_Rock.setEnabled(false);
            button2l2_Paper.setEnabled(false);
            button3l2_Scissors.setEnabled(false);

        }
        if (e.getSource() == button3l2_Scissors) {
            // scissors button

            userinput = 3;
            userIcon = new ImageIcon("images/scissors2.png");
            label3_2.setIcon(userIcon);
            comGen();
            checker();
            button1l5.setEnabled(true);
            button1l2_Rock.setEnabled(false);
            button2l2_Paper.setEnabled(false);
            button3l2_Scissors.setEnabled(false);

        }

        if (e.getSource() == button1l5) {
            // NextRound button

            if (rounds < 3) {
                rounds++;
                gameFrame.remove(panel1);
                gameFrame.remove(panel2);
                gameFrame.remove(panel3);
                gameFrame.remove(panel4);
                gameFrame.remove(panel5);
                gameFrame.repaint();
                gameFrame();
            } else if (rounds == 3) {
                rounds++;
                System.out.println("Value of rounds:" + rounds);
                gameFrame.remove(panel1);
                gameFrame.remove(panel2);
                gameFrame.remove(panel3);
                gameFrame.remove(panel4);
                gameFrame.remove(panel5);
                gameFrame.repaint();
                finalFrame();
                label4.setText("Player:" + userScore + " || Com:" + ComScore);
                finalchecker();
            }
        }

        if (e.getSource() == buttonPA1) {
            rounds = 1;
            userScore = 0;
            ComScore = 0;
            button5Text = "Next Round";
            gameFrame.remove(panel1);
            gameFrame.remove(panel2);
            gameFrame.remove(panel3);
            gameFrame.remove(panel4);
            gameFrame.remove(panel5);
            gameFrame.repaint();
            gameFrame();
        }
        if (e.getSource() == buttonPA2) {
            System.exit(0);
        }

    }

    // -----------------------------------------------------------

    public void checker() {
        if (userinput == 3 && Cominput == 2 ||
                userinput == 2 && Cominput == 1 ||
                userinput == 1 && Cominput == 3) {
            String winner = "Player Won";
            label4.setText(winner);
            userScore++;

            label5_1.setText("Player:" + userScore + " || Com:" + ComScore);

            if (rounds == 3) {
                button5Text = "Final Score";
                button1l5.setText(button5Text);
            }
        } else if (Cominput == 3 && userinput == 2 ||
                Cominput == 2 && userinput == 1 ||
                Cominput == 1 && userinput == 3) {
            String winner = "Com Won";
            label4.setText(winner);
            ComScore++;

            label5_1.setText("Player:" + userScore + " || Com:" + ComScore);

            if (rounds == 3) {
                button5Text = "Final Score";
                button1l5.setText(button5Text);
            }
        } else if (Cominput == userinput) {
            String winner = "Draw ";
            label4.setText(winner);

            label5_1.setText("Player:" + userScore + " || Com:" + ComScore);

            if (rounds == 3) {
                button5Text = "Final Score";
                button1l5.setText(button5Text);
            }
        }
    }

    // -----------------------------------------------------------

    public void finalchecker() {
        if (userScore > ComScore) {
            finalwinner = "PLAYER WINS";
            label2.setText(finalwinner);
        } else if (ComScore > userScore) {
            finalwinner = "COM WINS";
            label2.setText(finalwinner);
        } else if (ComScore == userScore) {
            finalwinner = "DRAW GAME";
            label2.setText(finalwinner);
        }
    }

    // -----------------------------------------------------------

    public void comGen() {
        Random random = new Random();
        Cominput = random.nextInt(3) + 1;

        switch (Cominput) {
            case 1:
                Cominput = 1;
                comIcon = new ImageIcon("images/rock2.png");
                label3_4.setIcon(comIcon);
                break;

            case 2:
                Cominput = 2;
                comIcon = new ImageIcon("images/paper2.png");
                label3_4.setIcon(comIcon);
                break;

            case 3:
                Cominput = 3;
                comIcon = new ImageIcon("images/scissors2.png");
                label3_4.setIcon(comIcon);
                break;
        }

    }

}