import java.util.Random;
import java.util.Scanner;

public class guessgame
{
    private double userAccuracy = 0.0;
    private int userScore = 0;
    private int attempts = 0;
    private int compNum = 0;
    public static void main(String [] args)
    {
        guessgame game = new guessgame();
        game.reset();
        game.play();
    }

    public void reset()
    {
        Random random = new Random();
        compNum = random.nextInt(10);
        attempts = 0;
        userAccuracy = 0;
        if(compNum == 0)
        {
            reset();
        }

    }

    public void play()
    {
        System.out.print("Enter a number between 1 - 10");
        Scanner scnr = new Scanner(System.in);
        if(scnr.hasNextInt())
        {
            int userChoice = scnr.nextInt();
            if(userChoice != compNum)
            {
                this.attempts++;
            }
            userAccuracy = (((double)attempts / 10)*100.0);
            if(userChoice == compNum)
            {
                userScore++;
                System.out.println("You got " + userAccuracy + "% incorrct. After " + attempts + " attempts. Total points: " + userScore);
                System.out.println("Would you like to play around? y/n");
                if(scnr.next().toLowerCase().equals ("y"))
                {
                    reset();
                    play();
                }
                else
                {
                    System.exit(0);
                }
            }
            else
            {
                if(userChoice == 10 || userChoice == 1)
                {
                    System.out.println("You are incorrect. I told you that you should choose a number BETWEEN 1 and 10.");
                }
                else
                {
                    System.out.print("You are incorrect");
                }
            }
        }
        else
        {
            play();
        }
    }
}
