import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Write a description of class Connect4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConnectFour {
    final int boardWidth=8;
    final int boardHeight=8;
    int totalMovesPlayed;
    int[][] board;


    public void ConnectFour(){
        board=new int[boardHeight][boardWidth];
        totalMovesPlayed=0;
    }
    //main(String args[])throws IOException{
    public static void SinglePlayer()throws IOException{

        ConnectFour c4=new ConnectFour();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Connect 4");
        System.out.println("Key in -1 to save your game");
        outer:
        
        while(true){
            //PLAYER 1.
            while(true){
                System.out.println("\n\nPlayer 1 play:");
                int column=0;
                column=Integer.parseInt(br.readLine());
                if(c4.isPlayable(column)){
                    if(c4.playMove(column, 1)){
                        c4.printBoard();
                        System.out.println("\n\nPlayer 1 wins!!!");
                        break outer;
                    }
                    break;
                }
                else
                    System.out.println("Column "+column+" is already full!!");
            }
            c4.printBoard();

            //AI   
            while(true){
                System.out.println("\n\nPlayer 2 play:");
                int column = (int )(Math.random() * 7 + 0); 
                if(c4.isPlayable(column)){
                    if(c4.playMove(column, 2)){
                        c4.printBoard();
                        System.out.println("\n\nPlayer 2 wins!!!");
                        break outer;
                    }

                    break;
                }
                else
                    System.out.println("Column "+column+" is already full!!");
            }
            c4.printBoard();

            if(c4.isFull()){
                System.out.print("Game drawn. Both of you suck at this!!! ");
                break;
            }
        }

      }
      
      public static void Multiplayer()throws IOException{

        ConnectFour c4=new ConnectFour();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Connect 4");
        System.out.println("Key in -1 to save your game");
        outer:
        
        while(true){
            //PLAYER 1.
            while(true){
                System.out.println("\n\nPlayer 1 play:");
                int column=0;
                column=Integer.parseInt(br.readLine());
                if(c4.isPlayable(column)){
                    if(c4.playMove(column, 1)){
                        c4.printBoard();
                        System.out.println("\n\nPlayer 1 wins!!!");
                        break outer;
                    }
                    break;
                }
                else
                    System.out.println("Column "+column+" is already full!!");
            }
            c4.printBoard();

            //Player 2 
            while(true){
                System.out.println("\n\nPlayer 2 play:");
                int column=0;
                column=Integer.parseInt(br.readLine());
                if(c4.isPlayable(column)){
                    if(c4.playMove(column, 1)){
                        c4.printBoard();
                        System.out.println("\n\nPlayer 2 wins!!!");
                        break outer;
                    }
                    break;
                }
                else
                    System.out.println("Column "+column+" is already full!!");
            }
            c4.printBoard();

            if(c4.isFull()){
                System.out.print("Game drawn. Both of you suck at this!!! ");
                break;
            }
        }
    }

    public void printBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 0)
                    System.out.print("_  ");
                else
                    System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }

        for(int i=0;i<boardWidth;i++)
            System.out.print("*  ");
        System.out.println();

        for(int i=0;i<boardWidth;i++)
            System.out.print(i+"  ");
        System.out.println();
    }

    public boolean playMove(int column, int playerNum){
        int i=0;
        for(i=0;i<boardHeight;i++){
            if(board[i][column] == 1 || board[i][column] == 2){
                board[i-1][column]=playerNum;
                break;
            }
        }
        if(i == boardHeight)
            board[i-1][column]=playerNum;

        totalMovesPlayed++;
        return isConnected(i-1,column);
    }

    public boolean isPlayable(int column)
    {
        return board[0][column] == 0; 
    }

    public boolean isFull(){
        return totalMovesPlayed == boardHeight*boardWidth;
    }

    public boolean isConnected(int x, int y){
        int num=board[x][y];
        int count=0;
        int i=y;

        //HORIZONTAL.
        while(i<boardWidth && board[x][i] == num){
            count++;
            i++;
        }
        i=y-1;
        while(i>=0 && board[x][i] == num){
            count++;
            i--;
        }
        if(count == 4)
            return true;

        //VERTICAL.
        count=0;
        int j=x;
        while(j<boardHeight && board[j][y] == num){
            count++;
            j++;
        }
        if(count == 4)
            return true;

        //SECONDARY DIAGONAL.
        count=0;
        i=x;
        j=y;
        while(i<boardWidth && j<boardHeight && board[i][j] == num){
            count++;
            i++;
            j++;
        }
        i=x-1;
        j=y-1;
        while(i>=0 && j>=0 && board[i][j] == num){
            count++;
            i--;
            j--;
        }
        if(count == 4)
            return true;

        //LEADING DIAGONAL.
        count=0;
        i=x;
        j=y;
        while(i<boardWidth && j>=0 && board[i][j] == num){
            count++;
            i++;
            j--;
        }
        i=x-1;
        j=y+1;
        while(i>=0 && j<boardHeight && board[i][j] == num){
            count++;
            i--;
            j++;
        }
        if(count == 4)
            return true;

        return false;
    } 
    public static void SaveGame()
    {
        PrintWriter printWriter = null;
        FileOutputStream outputStream = null;
        String Write = ""; 
        try
        {
            outputStream = new FileOutputStream("Test.txt");
            printWriter = new PrintWriter(outputStream); 
            while (true)
            {
                System.out.println("Please enter the text to write to file");
                Write = Genio.getString();
                if (Write.isEmpty()) break;
                printWriter.println(Write + " ");

            }
        }
        catch (IOException e)
        {
            System.out.println("Error when writing to file.");
        }
        finally
        {
            if (printWriter != null)
            {
                printWriter.close();    
            }
        }
    }
    public static void exit()
        {
         System.out.println("Goodbye :)");
        }    
}