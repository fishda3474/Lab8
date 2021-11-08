import java.awt.*;
import java.awt.event.*;
import javax.swing.*; //Adding objects
import java.util.Random;

public class GuessingGame implements ActionListener{ //creating class with actionlistener
JTextField guesstxt;
JButton guessbtn;
JButton PAbtn;
JLabel promptlbl;
JLabel highLowlbl;
JLabel lastGuesslbl;
Random r = new Random();
int rNum; //Adding in all my classwide variables

GuessingGame() {
  rNum = r.nextInt(99) + 1; //creating a random number

  JFrame frame = new JFrame("Guessing Game");
  frame.setLayout(new FlowLayout());
  frame.setSize(240, 130); //initializing my frame. It's 130 high because it overflows otherwise.

  guesstxt = new JTextField(10);
  guesstxt.setActionCommand("myTF"); //initializing my text JTextField
  guesstxt.addActionListener(this);

  guessbtn = new JButton("Guess");
  PAbtn = new JButton("Play Again"); //initializing my buttons
  guessbtn.addActionListener(this);
  PAbtn.addActionListener(this);

  promptlbl = new JLabel("Enter your guess: ");
  highLowlbl = new JLabel(""); //initializing my labels
  lastGuesslbl = new JLabel(""); 

  frame.add(promptlbl);
  frame.add(guesstxt);
  frame.add(guessbtn);  //adding everything to my frame and making it visible.
  frame.add(highLowlbl);
  frame.add(lastGuesslbl);
  frame.add(PAbtn);
  frame.setVisible(true);
}

public void actionPerformed(ActionEvent ae) {
  if(ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(guesstxt.getText());
      if (guess < rNum) {
        highLowlbl.setText("Too Low!");
        guesstxt.setText("");
      } else if (guess > rNum) {               //take in the text and compare it to the guess and react accordingly.
        highLowlbl.setText("Too High!");
        guesstxt.setText("");
      } else {
        highLowlbl.setText("You got it!");
      }
      lastGuesslbl.setText("Last guess was: " + guess);
  } else if(ae.getActionCommand().equals("Play Again")) {
      rNum = r.nextInt(99) + 1;
      highLowlbl.setText(""); 
      lastGuesslbl.setText(""); //choosing a new number and resetting everything
      guesstxt.setText("");
  } else {
    highLowlbl.setText("You pressed enter. Please press the Guess Button.");
  }
}
}