import javax.swing.*;

public class RockPaperScissors
{
    String name = "AAA";
    int computerDecision;
    int userChoice;
    int userScore;
    int computerScore;
    public static void main(String[] args)
    {
        RockPaperScissors Ghan = new RockPaperScissors();
        Ghan.setup();
    }

    void setup()
    {
        name = JOptionPane.showInputDialog("What is your name?");
        play();
        JFrame frame = new JFrame("RockPaperScissors");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    void getuseranswer()
    {
            userChoice = -1;

            while (userChoice < 0)
            {
                String usrdesision = JOptionPane.showInputDialog(name + ", what would you like to chose");
                usrdesision = usrdesision.trim().toLowerCase();

                if (usrdesision.equals("rock"))
                {
                    userChoice = 0;
                }
                else if (usrdesision.equals("paper"))
                {
                    userChoice = 1;
                }
                else if (usrdesision.equals("scissors"))
                {
                    userChoice = 2;
                }
            }
    }

    void getComputerDecision()
    {
        double decision = Math.random() * 2;
        computerDecision = (int) decision;
    }

    private int getWinner()
    {
        if (userChoice == computerDecision)
        {
            return 2;
        }
        else if (userChoice == 1 && computerDecision == 0)
        {
            return 1;
        }
        else if (userChoice == 1 && computerDecision == 2)
        {
            return 0;
        }
        else if (userChoice == 0 && computerDecision == 2)
        {
            return 1;
        }
        else if (userChoice == 0 && computerDecision == 1)
        {
            return 0;
        }
        else if (userChoice == 2 && computerDecision == 1)
        {
            return 1;
        }
        else if (userChoice == 2 && computerDecision == 0)
        {
            return 0;
        }
        else
        {
        // will return 2 if it is not within the expected patterns. It should never run but in case that something will go wrong with the compiler, it is a fault-safe.
            return 2;
        }
    }

    private void userwantstoplayagin()
    {
        String message;
        switch (this.getWinner())
        {
            case 0:
                this.computerScore++;
                message = "You lost. ";
                switch (this.computerDecision)
                {
                    case 0:
                        message += "The computer chose rock. ";
                        break;
                    case 1:
                        message += "The computer chose paper. ";
                        break;
                    case 2:
                        message += "The computer chose scissors. ";
                        break;
                }
                switch (this.userChoice)
                {
                    case 0:
                        message += "You chose rock. ";
                        break;
                    case 1:
                        message += "You chose paper. ";
                        break;
                    case 2:
                        message += "You chose scissors. ";
                        break;
                }

                break;
            case 1:
                this.userScore++;
                message = "You won. ";
                switch (this.computerDecision)
                {
                    case 0:
                        message += "The computer chose rock. ";
                        break;
                    case 1:
                        message += "The computer chose paper. ";
                        break;
                    case 2:
                        message += "The computer chose scissors. ";
                        break;
                }
                switch (this.userChoice)
                {
                    case 0:
                        message += "You chose rock. ";
                        break;
                    case 1:
                        message += "You chose paper. ";
                        break;
                    case 2:
                        message += "You chose scissors. ";
                        break;
                }

                break;
            default:
                message = "You draw. ";
                switch (this.computerDecision)
                {
                    case 0:
                        message += "The computer chose rock. ";
                        break;
                    case 1:
                        message += "The computer chose paper. ";
                        break;
                    case 2:
                        message += "The computer chose scissors. ";
                        break;
                }
                switch (this.userChoice)
                {
                    case 0:
                        message += "You chose rock. ";
                        break;
                    case 1:
                        message += "You chose paper. ";
                        break;
                    case 2:
                        message += "You chose scissors. ";
                        break;
                }

                break;

        }
        message += "\nYou have " + userScore + ". The computer has " + computerScore + ". Would you like to play again?";
        String[] options = {"Yes","No"};
        int yesNo = JOptionPane.showOptionDialog(null,message, "Play Again?",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null, options,null);
        if(userScore == 10 || computerScore == 10)
        {

        }
        else if (yesNo == 0)
        {
            System.out.print("YES");
            this.play();
        }
        else if (yesNo == 1)
        {
            System.out.print("NO");
        }
    }

    void play()
    {
        getuseranswer();
        getComputerDecision();
        userwantstoplayagin();

    }

}
