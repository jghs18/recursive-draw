import java.util.Scanner;
/**
 * 
 * @author John Ghantous
 * @version 
 */
public class Starter
{
    public static void main (String[]args){
        System.out.println("What drawing would you like?\n1) Basic\n2) Extra");
        Scanner reader = new Scanner(System.in);
        int res = reader.nextInt();
        Flower f = new Flower(1000,1000);
        f.draw(100,80,-80,80, false);
        if(res==2)
        {               
            f.draw(100, 400,400,80, false);
            f.draw(100, 400,-400,80, true);
            f.drawTop(0,400,40,80);
        }
        else if(res==1)
        {
            f.drawStem();
            f.drawBack(10,400,300,80);
        }
    }
}