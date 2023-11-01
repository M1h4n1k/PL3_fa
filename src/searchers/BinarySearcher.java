package searchers;

public class BinarySearcher extends Searcher {
    public BinarySearcher() {
        name = "binary";
    }

    public boolean find(int key) {
        int l = 0, r = arr.length;
        int m = arr.length / 2;
        while (l < r) {
            if (arr[m] == key) {
                return true;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                r = m;
            }
            m = (l + r) / 2;
        }
        return false;
    }
}
