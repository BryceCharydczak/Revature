public class PrototypeDriver {

    public static void main(String[] args){
        Students stu1 = new Students();
        stu1.loadData();

        Students stu2;

        try{
            stu2 = (Students)stu1.clone();
        } catch (CloneNotSupportedException e){
            stu2 = new Students();
            e.printStackTrace();
        }

        for(int i = 0; i < stu1.getStudentList().size(); i++){
            System.out.println("stu1, student: " + stu1.getStudentList().get(i));
            System.out.println("stu2, student: " + stu2.getStudentList().get(i));

        }

        System.out.println("stu1 == stu2? " + (stu1 == stu2));
        System.out.println("stu1.equals(stu2)? " + stu1.equals(stu2));


    }
}
