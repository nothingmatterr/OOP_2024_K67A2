public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
        /* TODO */
    }

    @Override
    public double solve(MyPolynomial polynomial, double lower, double upper) {
        double x0 = lower;
        double x1 = upper;
        double f0 = polynomial.evaluate(x0);
        double f1 = polynomial.evaluate(x1);

        for (int i = 0; i < maxIterations; i++) {
            if (Math.abs(f1 - f0) < 1e-12) {
                break;
            }
            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            if (Math.abs(x2 - x1) < tolerance) {
                return x2;
            }
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = polynomial.evaluate(x1);
        }
        return x1;
        /* TODO */
    }
}