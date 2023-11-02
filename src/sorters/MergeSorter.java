package sorters;

public class MergeSorter extends Sorter {
    public MergeSorter(int n){
        super(n);
        name = "mergesort";
    }

    private int[] merge(int[] a, int[] b){
        int[] crr = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length || j < b.length){
            if (j == b.length){
                crr[k] = a[i];
                i++;
            } else if (i == a.length) {
                crr[k] = b[j];
                j++;
            } else if (a[i] < b[j]){
                crr[k] = a[i];
                i++;
            } else {
                crr[k] = b[j];
                j++;
            }
            comparisons++;
            k++;
        }
        return crr;
    }

    public int[] mergeSort(int[] _arr) {
        if (_arr.length <= 1) {
            return _arr;
        }
        int[] a = new int[_arr.length / 2];
        int[] b = new int[_arr.length - a.length];
        System.arraycopy(_arr, 0, a, 0, a.length);
        System.arraycopy(_arr, _arr.length / 2, b, 0, b.length);

        a = mergeSort(a);
        b = mergeSort(b);
        _arr = merge(a, b);
        return _arr;
    }

    public void sort(){
        arr = mergeSort(arr);
    }
}
