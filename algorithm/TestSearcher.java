public class TestSearcher {
    private Searcher searcher;

    public TestSearcher(Searcher searcher) {
        /* TODO */
        this.searcher = searcher;
    }

    public static void main(String[] args) {
        /* Yêu cầu:
        - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [10 - 20].
        - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
        - Tạo đối tượng có kiểu dữ liệu BinarySearch được tham chiếu đến bởi một biến có kiểu dữ liệu Search.
          Dùng đối tượng này test thuật toán tìm kiếm nhị phân với mảng dữ liệu đã sinh ra sử dụng 3 thuật toán sắp xếp khác nhau như đã cho.

          Các kết quả test được in ra terminal theo định dạng: ví dụ
          Using Bubble Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 3.0: 2

          Using Insertion Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 6.0:-1

        - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_BinarySearch.txt.
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BinarySearch>.zip (Ví dụ, NguyenVanA_123456_BinarySearch.zip),
          nộp lên classroom
         */
        java.util.Random rand = new java.util.Random();
        int n = rand.nextInt(11) + 10;
        double[] data = new double[n];
        for (int i = 0; i < n; i++) {
            data[i] = Math.round(rand.nextDouble() * 1000) / 10.0;
        }
        double searchValue = data[rand.nextInt(n)];
        double notFoundValue = 10000.0;

        StringBuilder output = new StringBuilder();

        // Bubble Sort
        output.append("Using Bubble Sort Algorithm:\n");
        output.append("Before sorting: ").append(arrayToString(data)).append("\n");
        double[] arr1 = java.util.Arrays.copyOf(data, data.length);
        RecursiveBinarySearch binarySearch1 = new RecursiveBinarySearch();
        binarySearch1.setSorter(new BubbleSort());
        binarySearch1.search(searchValue, arr1);
        output.append("After sorting: ").append(arrayToString(arr1)).append("\n");
        int idx1 = binarySearch1.search(searchValue, arr1);
        output.append("Binary search giá trị ").append(searchValue).append(":").append(idx1).append("\n");

        // Insertion Sort
        output.append("\nUsing Insertion Sort Algorithm:\n");
        output.append("Before sorting: ").append(arrayToString(data)).append("\n");
        double[] arr2 = java.util.Arrays.copyOf(data, data.length);
        RecursiveBinarySearch binarySearch2 = new RecursiveBinarySearch();
        binarySearch2.setSorter(new InsertionSort());
        binarySearch2.search(notFoundValue, arr2);
        output.append("After sorting: ").append(arrayToString(arr2)).append("\n");
        int idx2 = binarySearch2.search(notFoundValue, arr2);
        output.append("Binary search giá trị ").append(notFoundValue).append(":").append(idx2).append("\n");

        // No Sorter (should not sort)
        output.append("\nUsing No Sort Algorithm:\n");
        output.append("Before sorting: ").append(arrayToString(data)).append("\n");
        double[] arr3 = java.util.Arrays.copyOf(data, data.length);
        RecursiveBinarySearch binarySearch3 = new RecursiveBinarySearch();
        int idx3 = binarySearch3.search(searchValue, arr3);
        output.append("After sorting: ").append(arrayToString(arr3)).append("\n");
        output.append("Binary search giá trị ").append(searchValue).append(":").append(idx3).append("\n");

        System.out.print(output);

        try {
            java.nio.file.Files.write(java.nio.file.Paths.get("TenSinhVien_MaSinhVien_BinarySearch.txt"), output.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testLinearSearch() {
        /* TODO
           - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [10 - 20].
           - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
           - Tạo đối tượng có kiểu dữ liệu LinearSearch, lưu vào biến searcher.
             Dùng đối tượng này test thuật toán tìm kiếm tuyến tính với mảng dữ liệu đã sinh ra.

             Các kết quả test được in ra terminal theo định dạng: ví dụ
             Data: [5.0 4.0 3.0 2.0 1.0]
             Linear search giá trị 3.0: 2
         */
        java.util.Random rand = new java.util.Random();
        int n = rand.nextInt(11) + 10;
        double[] data = new double[n];
        for (int i = 0; i < n; i++) {
            data[i] = Math.round(rand.nextDouble() * 1000) / 10.0;
        }
        double searchValue = data[rand.nextInt(n)];
        searcher = new LinearSearch();
        System.out.println("Data: " + arrayToString(data));
        int idx = searcher.search(searchValue, data);
        System.out.println("Linear search giá trị " + searchValue + ": " + idx);
    }

    public void testIterativeBinarySearch() {
        /* TODO
           - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [10 - 20].
           - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
           - Tạo đối tượng có kiểu dữ liệu IterativeBinarySearch, lưu vào biến searcher.
             Dùng đối tượng này test thuật toán tìm kiếm nhị phân với mảng dữ liệu đã sinh ra sử dụng 3 thuật toán sắp xếp khác nhau như đã cho.

             Các kết quả test được in ra terminal theo định dạng: ví dụ
             Using Bubble Sort Algorithm:
             Before sorting: [5.0 4.0 3.0 2.0 1.0]
             After sorting: [1.0 2.0 3.0 4.0 5.0]
             Iterative binary search giá trị 3.0: 2

             Using Insertion Sort Algorithm:
             Before sorting: [5.0 4.0 3.0 2.0 1.0]
             After sorting: [1.0 2.0 3.0 4.0 5.0]
             Iterative binary search giá trị 6.0:-1
         */
        java.util.Random rand = new java.util.Random();
        int n = rand.nextInt(11) + 10;
        double[] data = new double[n];
        for (int i = 0; i < n; i++) {
            data[i] = Math.round(rand.nextDouble() * 1000) / 10.0;
        }
        double searchValue = data[rand.nextInt(n)];
        double notFoundValue = 10000.0;

        // Bubble Sort
        System.out.println("Using Bubble Sort Algorithm:");
        System.out.println("Before sorting: " + arrayToString(data));
        double[] arr1 = java.util.Arrays.copyOf(data, data.length);
        IterativeBinarySearch iterative1 = new IterativeBinarySearch();
        iterative1.setSorter(new BubbleSort());
        iterative1.search(searchValue, arr1);
        System.out.println("After sorting: " + arrayToString(arr1));
        int idx1 = iterative1.search(searchValue, arr1);
        System.out.println("Iterative binary search giá trị " + searchValue + ": " + idx1);

        // Insertion Sort
        System.out.println("\nUsing Insertion Sort Algorithm:");
        System.out.println("Before sorting: " + arrayToString(data));
        double[] arr2 = java.util.Arrays.copyOf(data, data.length);
        IterativeBinarySearch iterative2 = new IterativeBinarySearch();
        iterative2.setSorter(new InsertionSort());
        iterative2.search(notFoundValue, arr2);
        System.out.println("After sorting: " + arrayToString(arr2));
        int idx2 = iterative2.search(notFoundValue, arr2);
        System.out.println("Iterative binary search giá trị " + notFoundValue + ":" + idx2);
    }

    public void testRecursiveBinarySearch() {
        /* TODO
           - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [10 - 20].
           - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
           - Tạo đối tượng có kiểu dữ liệu RecursiveBinarySearch, lưu vào biến searcher.
             Dùng đối tượng này test thuật toán tìm kiếm nhị phân với mảng dữ liệu đã sinh ra sử dụng 3 thuật toán sắp xếp khác nhau như đã cho.

             Các kết quả test được in ra terminal theo định dạng: ví dụ
             Using Bubble Sort Algorithm:
             Before sorting: [5.0 4.0 3.0 2.0 1.0]
             After sorting: [1.0 2.0 3.0 4.0 5.0]
             Recursive binary search giá trị 3.0: 2

             Using Insertion Sort Algorithm:
             Before sorting: [5.0 4.0 3.0 2.0 1.0]
             After sorting: [1.0 2.0 3.0 4.0 5.0]
             Recursive binary search giá trị 6.0:-1
         */
        java.util.Random rand = new java.util.Random();
        int n = rand.nextInt(11) + 10;
        double[] data = new double[n];
        for (int i = 0; i < n; i++) {
            data[i] = Math.round(rand.nextDouble() * 1000) / 10.0;
        }
        double searchValue = data[rand.nextInt(n)];
        double notFoundValue = 10000.0;

        // Bubble Sort
        System.out.println("Using Bubble Sort Algorithm:");
        System.out.println("Before sorting: " + arrayToString(data));
        double[] arr1 = java.util.Arrays.copyOf(data, data.length);
        RecursiveBinarySearch recursive1 = new RecursiveBinarySearch();
        recursive1.setSorter(new BubbleSort());
        recursive1.search(searchValue, arr1);
        System.out.println("After sorting: " + arrayToString(arr1));
        int idx1 = recursive1.search(searchValue, arr1);
        System.out.println("Recursive binary search giá trị " + searchValue + ": " + idx1);

        // Insertion Sort
        System.out.println("\nUsing Insertion Sort Algorithm:");
        System.out.println("Before sorting: " + arrayToString(data));
        double[] arr2 = java.util.Arrays.copyOf(data, data.length);
        RecursiveBinarySearch recursive2 = new RecursiveBinarySearch();
        recursive2.setSorter(new InsertionSort());
        recursive2.search(notFoundValue, arr2);
        System.out.println("After sorting: " + arrayToString(arr2));
        int idx2 = recursive2.search(notFoundValue, arr2);
        System.out.println("Recursive binary search giá trị " + notFoundValue + ":" + idx2);
    }

    private static String arrayToString(double[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}