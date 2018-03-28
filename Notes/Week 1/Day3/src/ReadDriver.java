import java.io.*;

public class ReadDriver {
    public static void main(String[] args){
        BufferedReader br = null;
        BufferedReader br2 = null;
        BufferedWriter bw = null;
        File filePath =  new File("\\media\\removable\\UNTITLED\\Revature\\Notes\\Week 1\\Day3\\src\\Input.txt");


        try {
            br = new BufferedReader(new FileReader(filePath));
            System.out.println("Read file using readLine() method");
            String line = br.readLine();
            while(line != null){
                System.out.println(line);
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }


        try {
            br2 = new BufferedReader(new FileReader(filePath));

            System.out.println("Read file using read() method");

            int val = 0;
            char myChar;

            while((val = br2.read()) != -1){
                myChar = (char) val;
                if (myChar == '\n'){System.out.println();}
                System.out.print(myChar);
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
