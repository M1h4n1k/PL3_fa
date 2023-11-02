package sorters;

import java.util.Arrays;

public class QSorter extends Sorter {
    // I understand the idea of qsort, but I cannot write it, it took me ~hour to debug this and finally get it working
    // it uses O(n) memory, but the time complexity is O(nlogn) so satisfies the requirements
    public QSorter(int n){
        super(n);
        name = "quickSort";
    }

    private void qsort(int[] a, int end){
        int pivot = a[0];
        int l = 0, r = end;
        if (l >= r){
            return;
        }

        int li = 0, ri = 0, si = 0;
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int[] same = new int[a.length];

        while (l <= r) {
            if (a[l] < pivot){
                left[li++] = a[l++];
            } else if (a[r] > pivot){
                right[ri++] = a[r--];
            } else if (a[l] == pivot){
                same[si++] = a[l++];
            } else if (a[r] == pivot){
                same[si++] = a[r--];
            } else if (l < r){
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
            }
            comparisons++;
        }

        qsort(left, li - 1);
        qsort(right, ri - 1);

        System.arraycopy(left, 0, a, 0, li);
        System.arraycopy(same, 0, a, li, si);
        System.arraycopy(right, 0, a, li + si, ri);
        if (a.length == arr.length){
            System.arraycopy(a, 0, arr, 0, a.length);
        }

    }

    public void sort(){
        qsort(arr, arr.length - 1);
    }

}
