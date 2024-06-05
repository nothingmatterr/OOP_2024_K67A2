public class RecursiveBinarySearch implements Searcher {
    private Sorter sorter;

    public RecursiveBinarySearch() {
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
        return recursiveBinarySearch(value, data);
    }

    /**
     * Tìm kiếm giá trị value trong mảng data từ vị trí from tới vị trí to,
     * sử dụng thuật toán tìm kiếm nhị phân code theo thuật toán đệ quy.
     * @param value
     * @param data
     * @param from
     * @param to
     * @return
     */
    private int recursiveBinarySearch(double value, double[] data, int from, int to) {
        /* TODO */
        if (from > to) {
            return -1;
        }
        int mid = from + (to - from) / 2;
        if (data[mid] == value) {
            return mid;
        } else if (data[mid] < value) {
            return recursiveBinarySearch(value, data, mid + 1, to);
        } else {
            return recursiveBinarySearch(value, data, from, mid - 1);
        }
    }

    /**
     * Tìm kiếm giá trị value trong toàn bộ mảng data, sử dụng thuật toán tìm kiếm nhị phân code theo thuật toán đệ quy.
     * @param value
     * @param data
     * @return
     */
    private int recursiveBinarySearch(double value, double[] data) {
        /* TODO */
        return recursiveBinarySearch(value, data, 0, data.length - 1);
    }

    /**
     * Sắp xếp mảng dữ liệu data.
     * @param data
     */
    private void sort(double[] data) {
        /* TODO */
        if (sorter != null) {
            sorter.sort(data, true);
        }
    }
}