import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendFileDriver {
    public static void main(String[] args){
        try{
            String content = "\ncontent to add to the file";
            String path = "filepath.txt";

            File file = new File(filePath);


            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.close();

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
