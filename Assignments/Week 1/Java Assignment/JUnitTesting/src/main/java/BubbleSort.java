public class BubbleSort {

    public static int[] bubblesort(int[] arr){
        int[] answer = arr;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return answer;
    }
}
