public class TestMod {

    public static int testMod(int x){
        float flt = (float)x;
        float divided = flt/2;
        String converter = String.valueOf(divided);
        String[] splitting = converter.split("\\.");

        if (splitting[1].equals("0")){
            //System.out.println("This integer is even");
            return 1;
        } else {
            //System.out.println("This integer is odd");
            return 0;
        }
    }
}
