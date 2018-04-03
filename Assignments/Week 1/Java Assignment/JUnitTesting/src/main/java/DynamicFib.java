public class DynamicFib {
    public static long DyamicFib(){

        long[] arr = new long[25];
        arr[0] = new Long(0);
        arr[1] = new Long(1);
        for (int i = 2; i < arr.length; i++){
            arr[i] = arr[i-1] + arr[i-2];
            //System.out.println(arr[i]);
        }
        return(arr[arr.length-1]);
    }
}
