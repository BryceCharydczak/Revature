public class nFactorial {
    public static long nFactorial(int n){
        long answer = 1;
        for (int i = 1; i < n+1; i++){
            answer*= i;
        }
        return answer;

    }
}
