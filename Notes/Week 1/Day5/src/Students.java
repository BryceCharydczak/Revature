import java.lang.reflect.Array;
import java.util.ArrayList;

public class Students implements Cloneable {
    private ArrayList<String> studentList;
    public Students(){
        studentList = new ArrayList<String>();
    }
    public Students(ArrayList<String> newList){
        this.studentList = newList;
    }

    public void loadData(){
        studentList.add("Thomas");
        studentList.add("Bob");
        studentList.add("Bryce");
        studentList.add("Lydia");

    }

    public ArrayList<String> getStudentList(){
        return studentList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        ArrayList<String> temp = new ArrayList<String>();
        for(String student: this.getStudentList()){
            temp.add(student);
        }
        return new Students(temp);
    }
}
