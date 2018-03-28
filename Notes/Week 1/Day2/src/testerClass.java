class testerClass{

    public static void main(String [] args){

        int t1 = 0;
        int t2 = 1;
        int n = 100;

            long[] arr = new long[n];
            arr[0] = new Long(t1);
            arr[1] = new Long(t2);
            for (int i = 2; i < n; i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
        System.out.println(arr[n-1]);
    }

}