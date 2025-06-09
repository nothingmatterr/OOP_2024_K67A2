public class IterativeBinarySearch implements Searcher {
    private Sorter sorter;

    public IterativeBinarySearch() {
        /* TODO */
        this.sorter = null;
    }

    public void setSorter(Sorter sorter) {
        /* TODO */
        this.sorter = sorter;
    }

    @Override
    public int search(double value, double[] data) {
        /* TODO */
        if (sorter != null) {
            sorter.sort(data, true);
        }
        return iterativeBinarySearch(value, data);
    }

    /**
     * Tìm kiếm giá trị value trong mảng data, sử dụng thuật toán tìm kiếm nhị phân code theo thuật toán lặp.
     * @param data
     * @param value
     * @return
     */
    private int iterativeBinarySearch(double value, double[] data) {
        /* TODO */
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == value) {
                return mid;
            } else if (data[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}