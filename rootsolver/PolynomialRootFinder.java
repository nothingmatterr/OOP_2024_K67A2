public class PolynomialRootFinder {
    private MyPolynomial polynomial;
    private RootSolver rootSolver;

    /**
     * Khởi tạo mặc định
     */
    public PolynomialRootFinder() {
        /* TODO */
        this.polynomial = null;
        this.rootSolver = null;
    }

    /**
     * Khởi tạo đa thức.
     * @param polynomial
     */
    public PolynomialRootFinder(MyPolynomial polynomial) {
        /* TODO */
        this.polynomial = polynomial;
        this.rootSolver = null;
    }

    /**
     * Khởi tạo đa thức và phương pháp tìm nghiệm.
     * @param polynomial
     * @param rootSolver
     */
    public PolynomialRootFinder(MyPolynomial polynomial, RootSolver rootSolver) {
        /* TODO */
        this.polynomial = polynomial;
        this.rootSolver = rootSolver;
    }

    public void setPolynomial(MyPolynomial polynomial) {
        /* TODO */
        this.polynomial = polynomial;
    }

    public void setRootSolver(RootSolver rootSolver) {
        /* TODO */
        this.rootSolver = rootSolver;
    }

    /**
     * Tìm nghiệm của đa thức trong đoạn từ lower đến upper.
     * @param lower
     * @param upper
     * @return
     */
    public double solve(double lower, double upper) {
        /* TODO */
        if (polynomial == null || rootSolver == null) {
            throw new IllegalStateException("Polynomial or RootSolver is not set.");
        }
        return rootSolver.solve(polynomial, lower, upper);
    }
}