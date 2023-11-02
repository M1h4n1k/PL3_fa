package sorters;

public class InsertionSorter extends Sorter {

    public InsertionSorter(int n) {
        super(n);
        name = "insertionSort";
    }

    public void sort() {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                comparisons++;
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }
}
