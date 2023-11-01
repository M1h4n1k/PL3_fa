public class MergeSorter extends Sorter {
    private static int[] merge(int[] arr, int[] brr){
        int[] crr = new int[arr.length + brr.length];
        int i = 0, j = 0, k = 0;
        while (i < arr.length || j < brr.length){
            if (j == brr.length){
                crr[k] = arr[i];
                i++;
            } else if (i == arr.length) {
                crr[k] = brr[j];
                j++;
            } else if (arr[i] < brr[j]){
                crr[k] = arr[i];
                i++;
            } else {
                crr[k] = brr[j];
                j++;
            }
            k++;
        }
        return crr;
    }

    public static int[] mergeSort(int[] _arr) {
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
