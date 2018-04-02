import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class AssociateCollection extends LinkedList<Associate> {


        private static final long serialVersionUID = 1L;

        public AssociateCollection() {
            String filePath = "/var/host/media/removable/UNTITLED/Revature/Assignments/Week 1/Associate Automation/src/Names.txt";
            BufferedReader br = null;
            try{
                br = new BufferedReader(new FileReader(filePath));
                String line;

                while( (line = br.readLine() ) != null) {
                    this.add(new Associate(line));
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            /*
            this.add(new Associate("Alex Pich"));
            this.add(new Associate("Dimitrei Nazi"));
            this.add(new Associate("Angelique Elkins"));
            this.add(new Associate("Bryce Charydczak"));
            this.add(new Associate("Byron Hall"));
            this.add(new Associate("Pedro De los Reyes"));
            this.add(new Associate("Quinn Wong"));
            this.add(new Associate("William Strauss"));
            this.add(new Associate("Philip Escobedo"));
            this.add(new Associate("Dennis Park"));
            this.add(new Associate("Noah Dering"));
            this.add(new Associate("Myles Casanas"));
            this.add(new Associate("Brandon Semba"));
            this.add(new Associate("Zachary Vaughn"));
            this.add(new Associate("Danny Chhun"));
            this.add(new Associate("Karl Cavanaugh"));
            this.add(new Associate("Joanel Vasquez"));
            this.add(new Associate("Richard Vo"));
            this.add(new Associate("Alexia Doramus"));
            this.add(new Associate("Antonio Marrero Bonilla"));
            this.add(new Associate("Joseph Edward Gonzales"));
            this.add(new Associate("Cameryn Holstick"));
            this.add(new Associate("Michael Ade"));
        }
        */


    }
}
