public class SubString {
    public static String substringMethod(String str, int idx){
        String answer ="";
        char[] charArr = str.toCharArray();

        for (int i = 0; i < idx+1; i++){
            answer+= charArr[i];
        }
        return answer;
    }
}
