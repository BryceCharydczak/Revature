import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AccountCollection extends HashMap<String,UserObj> {
    private static final long serialVersionUID = 1L;

    public AccountCollection(){

        File file = new File("Accounts.txt");

        BufferedReader br = null;
        HashMap<String, UserObj> map = new HashMap<String, UserObj>();

        try{
            br = new BufferedReader(new FileReader(file));
            String holder;
            while ((holder = br.readLine()) != null){
                String[] temp = holder.split("\\s+");
                UserObj obj = new UserObj();
                obj.setFirstName(temp[0]);
                obj.setLastName(temp[1]);
                obj.setUsername(temp[2]);
                obj.setPassword(temp[3]);
                obj.setBalance(Integer.parseInt(temp[4]));


                this.put(obj.getUsername()+obj.getPassword(), obj);

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
