import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public class Main {
    public static void main(String[] args){
        String accountFilePath = System.clearProperty("user.dir") + "/src/Accounts.txt";

        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(accountFilePath));
            while (br.readLine() != null){


            }
        } catch (IOException e){
            e.printStackTrace();
        }


        SortedSet<UserObj> allAccounts = new SortedSet<UserObj>() {

        }


    }
}
