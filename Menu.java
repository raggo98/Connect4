import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/**
 * @author (your name) 
 */
public class Menu
{
//public void showMenu(){
     //{
            
           
     //}
   // }
    
/**
* This method is used to call other methods within the program depending on the users choice.
*/    
public void ProcessUserInput()throws IOException
{
    int UserInput;
    do{ 
            System.out.println("Connect 4");
            System.out.println("1. Single player");
            System.out.println("2. Multiplayer");
            System.out.println("3. Save game");
            System.out.println("0. Quit");
            System.out.println("Please enter your choice:");
            UserInput = Genio.getInteger();
      if (UserInput==1){
        ConnectFour.SinglePlayer();
      }
      else if(UserInput==2){
        ConnectFour.Multiplayer();
        }
      else if(UserInput==3){
        ConnectFour.SaveGame();
        }
       else if (UserInput!=0)
         {
             System.out.println("The option which you have chosen is invalid, you must select an option ranging from numbers 0-3.");
         }
     } while (UserInput!=0);
     
     if (UserInput==0)
     {
         ConnectFour.exit();
     }
     }
}