public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(MyPolynomial polynomial, double lower, double upper) {
        /* TODO */
        double x = (lower + upper) / 2.0;
        for (int i = 0; i < maxIterations; i++) {
            double fx = polynomial.evaluate(x);
            double dfx = polynomial.derivative().evaluate(x);
            if (Math.abs(fx) < tolerance) {
                return x;
            }
            if (dfx == 0) {
                // Derivative is zero, cannot proceed
                break;
            }
            x = x - fx / dfx;
        }
        return x;
    }
}