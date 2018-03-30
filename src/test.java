public class test {
    public static void main (String [] args){
        short a = 8;
        go((short)a);
    }
    public static void go(short x){
        System.out.println("worksS");
    }
    public static void go(int x){
        System.out.println("worksI");
    }
    public static void go(long x){
        System.out.println("worksL");
    }

}
