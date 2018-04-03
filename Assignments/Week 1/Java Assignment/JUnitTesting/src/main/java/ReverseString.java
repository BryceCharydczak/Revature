public class ReverseString {
    public static String reverseString(String string){
        char[] chars = string.toCharArray();
        String answer = "";
        for(int i = 0; i < chars.length; i++){
            answer+= chars[chars.length-i-1];
        }
        return answer;
    }
}
