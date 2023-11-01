package sorters;

public class BubbleSorter extends Sorter {
    public BubbleSorter(){
        name = "bubble sorting";
    }

    public void sort(){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}