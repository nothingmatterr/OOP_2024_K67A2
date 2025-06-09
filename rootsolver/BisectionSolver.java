public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
        /* TODO */
    }

    @Override
    public double solve(MyPolynomial polynomial, double lower, double upper) {
        double fLower = polynomial.evaluate(lower);
        double fUpper = polynomial.evaluate(upper);

        if (fLower * fUpper > 0) {
            throw new IllegalArgumentException("Function has the same sign at the endpoints.");
        }

        double mid = 0.0;
        for (int i = 0; i < maxIterations; i++) {
            mid = (lower + upper) / 2.0;
            double fMid = polynomial.evaluate(mid);

            if (Math.abs(fMid) < tolerance || (upper - lower) / 2.0 < tolerance) {
                return mid;
            }

            if (fLower * fMid < 0) {
                upper = mid;
                fUpper = fMid;
            } else {
                lower = mid;
                fLower = fMid;
            }
        }
        return mid;
        /* TODO */
    }
}